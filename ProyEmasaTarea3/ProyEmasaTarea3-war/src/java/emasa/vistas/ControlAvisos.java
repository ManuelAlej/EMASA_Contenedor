/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.entidades.Aviso;
import emasa.entidades.Datos;
import emasa.entidades.Empleado;
import emasa.entidades.Historico;
import emasa.negocio.AvisoNegocio;
import emasa.negocio.HistoricoNegocio;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author alumno
 */

@Named(value="controlAvisos")
@ViewScoped
public class ControlAvisos implements Serializable{

    @Inject
    private LoginBean login;

    
    
  /*  @Inject 
    private Datos datos; */
    private List<Aviso> avisos;
    private Empleado empleado;
    private Aviso avisoSelected;
    @EJB
    private AvisoNegocio avisoNegocio;
    @EJB
    private HistoricoNegocio hisNegocio;
    
    /**
     * Creates a new instance of ControlAvisos
     */
    public ControlAvisos() {
    }
    public List<Aviso> getAvisos(){
        empleado=login.getUsr();
        //avisos =datos.getAvisos();
        avisos=avisoNegocio.buscarAvisos(empleado);
        
        List<Aviso> res=new ArrayList<>();
        for(Aviso av: avisos){
            for (Historico h:av.getHistoricoCollection()){
                                if(h.getHistoricoPK().getSupervisor()==empleado.getIdEmpleado() && (!res.contains(av))){

                    res.add(av);
                }
            } 
        }
        return res;
    }
    public LoginBean getLogin() {
        return login;
    }

    public void setLogin(LoginBean login) {
        this.login = login;
    }
    public String test(){
        
        return "avisoClient.xhtml?idAv=#{avisos.idAviso}";
    }
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public AvisoNegocio getAvisoNegocio() {
        return avisoNegocio;
    }

    public void setAvisoNegocio(AvisoNegocio avisoNegocio) {
        this.avisoNegocio = avisoNegocio;
    }
    //busco el historico mas reciente
    public Historico getHistorico(Aviso aviso){
        List<Historico> historico = null;
         Historico reciente=null;
         if(aviso!=null){//primefaces al intentar ordenar usando el historico manda avisos nulos
             historico=hisNegocio.buscarHistoricos(aviso.getIdAviso(),login.getUsr().getIdEmpleado() );
         
         System.out.println("sdaaaaaaaaaaaaaaaaaaaaaaffagsgga"+aviso+historico);
            if(historico!=null){//siempre tiene que tener un historico
               //creo una lista de historicos para las pruebas, pero aqui siempre debe tener por lo menos un historico
                   
                   for(Historico h :historico){
                       if(reciente==null||h.getHistoricoPK().getFechaActualizacion().after(reciente.getHistoricoPK().getFechaActualizacion())){
                           reciente=h;
                       }
                   }
            }else{
               reciente=new Historico();
               List <Historico> lista=new ArrayList();
               lista.add(reciente);
               aviso.setHistoricoCollection(lista);
           }
         }
         System.out.println("reciente : "+reciente);
        return reciente;
    }
    public boolean isSupervisor(){
        boolean res=false;
        empleado=login.getUsr();
        res= empleado.getCargo().equalsIgnoreCase("Supervisor");
        return res;
    }
    
    public Aviso getAvisoSelected() {
        return avisoSelected;
    }
/****************************************************************************
 * ************************************************
 * *******************************************
 * @param avisoSelected 
 */
    public void setAvisoSelected(Aviso avisoSelected) {
    /*    this.avisoSelected = avisoSelected;
        System.out.println("************************"+avisoSelected);
         FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("avisoSelected", avisoSelected);
        System.out.println("************************"+(Aviso)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("avisoSelected"));
      */  
    }
    
    public void onRowSelect(SelectEvent event) {
        
        FacesMessage msg = new FacesMessage("Aviso Seleccionado", String.valueOf(((Aviso) event.getObject()).getIdAviso()));  
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Aviso Deseleccionado", String.valueOf(((Aviso) event.getObject()).getIdAviso()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public String getFechaReciente(Date fecha){
       SimpleDateFormat formateador = new SimpleDateFormat("dd / MM / yyyy");
       return formateador.format(fecha);
    }
   
    public String cambiar(Aviso aviso) {
        FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("avisoSelected", aviso);
        return "avisoClient.xhtml";
}
     

}

