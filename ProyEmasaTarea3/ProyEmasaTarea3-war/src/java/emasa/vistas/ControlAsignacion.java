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
import emasa.entidades.Visitas;
import emasa.negocio.EmpleadoNegocio;
import emasa.negocio.VisitasNegocio;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Rocco
 */
@Named(value = "controlAsignacion")
@ViewScoped
public class ControlAsignacion implements Serializable {
    
    
    
    private  Empleado empleado;
    private Empleado SupervisorSelected;
    @EJB
    private EmpleadoNegocio emplNeg;
    @Inject
    private CalendarioVista calendario;
    @EJB 
    private VisitasNegocio visitaEJB;
    
    /**
     * Creates a new instance of ControlAsignacion
     */
    public ControlAsignacion() {
    }
 /*   public List<Empleado> getSupervisores(){
        EmpleadoFacade em=new EmpleadoFacade();
        List<Empleado> lista=em.getAllSupervisores();
        return lista;
    }
*/ 
    public List<Empleado> getOpmov(){
        System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+emplNeg.listaOpmov());
        return  emplNeg.listaOpmov();
    }
    
    
    
    public Empleado getSupervisorSelected() {
        return SupervisorSelected;
    }

    public void setSupervisorSelected(Empleado SupervisorSelected) {
        this.SupervisorSelected = SupervisorSelected;
    }
   public String AsignarOpmov(Empleado empl){
      
         Historico his = (Historico)FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("Historico"); 
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"+his);
     Visitas vis = new Visitas(calendario.getFechaAsignacion());
     
     
     //System.out.println(vis.getEmpleado().getIdEmpleado());
     
    System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
     vis.setHistorico(his);
    vis.setEmpleado(empl);
    
     
    
     visitaEJB.persist(vis);
     System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGg"+vis);
     
     
     
     return "avisoClient.xhtml";
 
   }
         
}
