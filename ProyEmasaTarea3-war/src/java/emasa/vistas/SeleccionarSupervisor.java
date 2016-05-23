/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.entidades.Aviso;
import emasa.entidades.Empleado;
import emasa.entidades.Historico;
import emasa.negocio.AvisoNegocio;
import emasa.negocio.EmpleadoNegocio;
import emasa.negocio.HistoricoNegocio;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;


/**
 *
 * @author malex
 */
@Named(value = "seleccionarSupervisor")
@SessionScoped
public class SeleccionarSupervisor implements Serializable {
    private Empleado e = new Empleado();
    private List<Empleado> supervisoresList;
    private String idSup;
    private Integer idAviso;
     @EJB
    private EmpleadoNegocio supervisorEJB;
     @EJB
    private AvisoNegocio avisoEJB;
      @EJB
    private HistoricoNegocio historicoEJB;
    
 //----Adri desde aqui---
    public Integer getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(Integer idAviso) {
        this.idAviso = idAviso;
    }

    public List<Empleado> getSupervisoresList() {
        return supervisoresList;
    }
    
    public String getIdSup() {
        return idSup;
    }

    public void setIdSup(String idSup) {
        this.idSup = idSup;
    }
    
    public void setSupervisoresList(List<Empleado> supervisoresList) {
        this.supervisoresList = supervisoresList;
    }
    
    public Empleado getE() {
        return e;
    }

    public void setE(Empleado e) {
        this.e = e;
    }
   
    public String add(){
        this.supervisorEJB.crearSupervisor(this.e);
      
       //supervisoresList.add(this.e);   //esto es para que salga inmediatamente el supervisor creado, borrar mas adelante
        this.e = new Empleado();
        return "avisoClient.xhtml";
    } 
    public String createSupervisor(){
        return "crearSupervisor.xhtml";
    }
   
    
    public List<Empleado> verSupervisores(){
       return this.supervisorEJB.listaSupervisores();
    }
    
    @PostConstruct
    public void init(){
        supervisoresList = verSupervisores();
              
    }
    
   
    
    
    
    
    
    //<----Hasta---

    
    
    
    
    
    
    public void setSupervisores(List<Empleado> supervisores) {
        this.supervisores = supervisores;
    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    public OpcionesAviso getOpciones_aviso() {
        return opciones_aviso;
    }

    public void setOpciones_aviso(OpcionesAviso opciones_aviso) {
        this.opciones_aviso = opciones_aviso;
    }

    public Integer getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(Integer idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    private Integer idSupervisor;

    public InicializarSupervisores getService() {
        return service;
    }
    private List<Empleado> supervisores;

    public void setService(InicializarSupervisores service) {
        this.service = service;
    }

    @Inject
    private InicializarSupervisores service;

    private Aviso aviso;
    @Inject
    private OpcionesAviso opciones_aviso;

    public SeleccionarSupervisor() {

    }

    

    public String cambiarAsignacion() {
        if(idSup==null){
            return "reasignarAvisoClient.xhtml";
        }
       
        aviso = opciones_aviso.getAviso(); //cojo el aviso
        
        //actualizo el supervisor del aviso
        Historico hist = opciones_aviso.getHistoricoReciente();
        hist.getHistoricoPK().setSupervisor(Integer.parseInt(idSup));
        hist.getHistoricoPK().setFechaActualizacion(new Date());
        historicoEJB.persist(hist);    // persist al historico
        return "bandejaAvisosClient.xhtml"; 

    }

    public List<Empleado> getSupervisores() {
        return supervisores;
    }

    public String b_cancelar() {

        return "avisoClient.xhtml";
    }

}
