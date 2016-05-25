/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.entidades.Aviso;
import emasa.entidades.Empleado;
import emasa.entidades.Historico;
import emasa.entidades.HistoricoPK;
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
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;


/**
 *
 * @author malex
 */
@Named(value = "seleccionarSupervisor")
@ViewScoped
public class SeleccionarSupervisor implements Serializable {
    private Empleado e = new Empleado();
    private List<Empleado> supervisoresList;
    private Integer idSup;
    private Integer idAviso;
     @EJB
    private EmpleadoNegocio supervisorEJB;
     @EJB
    private AvisoNegocio avisoEJB;
      @EJB
    private HistoricoNegocio historicoEJB;
      @Inject
    private LoginBean sesion;
    private List<Historico> historicos;
    
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
    
    public Integer getIdSup() {
        return idSup;
    }

    public void setIdSup(Integer idSup) {
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
    
    
    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

   

    public Integer getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(Integer idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    private Integer idSupervisor;

  

   

    private Aviso aviso;
    

    public SeleccionarSupervisor() {

    }

    

    public String cambiarAsignacion() {
        if(idSup==null){
            return "reasignarAvisoClient.xhtml";
        }
       
       aviso=(Aviso) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("avisoSelected");
       
         //cojo el aviso
        
         Historico anterior= (Historico)FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("Historico");
         System.out.println("fdxwscgscchjkrlbjlrgmvnfvbdchbhdvgchd          "+anterior);
         
         
         anterior.setFechaCierre(new Date());
         historicoEJB.actualizarHistorico(anterior);
         
         
        //actualizo el supervisor del aviso
        Historico hist = new Historico();
        hist.setHistoricoPK(new HistoricoPK(aviso.getIdAviso(), new Date(),idSup));
        
        hist.copiarHist(anterior);
        hist.setFechaCierre(null);
      /*          opciones_aviso.getHistoricoReciente();
        hist.getHistoricoPK().setSupervisor(Integer.parseInt(idSup));
        hist.getHistoricoPK().setFechaActualizacion(new Date());
        
     */ 
      
      
      historicoEJB.persist(hist);    // persist al historico
      
      
       
       // aviso.getHistoricoCollection().add(hist);
      // avisoEJB.actualizarAviso(aviso);
        return "bandejaAvisosClient.xhtml"; 

    }

  public Historico getHistoricoReciente() {
        historicos =historicoEJB.buscarHistoricos(aviso.getIdAviso(),sesion.getUsr().getIdEmpleado());
        Historico reciente = historicos.get(0);

        Date fecha = reciente.getHistoricoPK().getFechaActualizacion();

        for (Historico h : historicos) {

            if (h.getHistoricoPK().getFechaActualizacion().after(fecha)) {
                reciente = h;
                fecha = h.getHistoricoPK().getFechaActualizacion();
            }
        }

        return reciente;
    }

    public String b_cancelar() {

        return "avisoClient.xhtml";
    }

}
