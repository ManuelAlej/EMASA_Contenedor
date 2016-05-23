/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.entidades.Aviso;
import emasa.entidades.Datos;
import emasa.entidades.Empleado;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Rocco
 */
@Named(value = "controlAsignacion")
@SessionScoped
public class ControlAsignacion implements Serializable {
    
    
    @Inject
    private OpcionesAviso aviso;
    private  Empleado empleado;
    private Empleado SupervisorSelected;
    @Inject
    private Datos datos;
    
    
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
    public List<Empleado> getSupervisores(){
        
      List<Empleado> res=new ArrayList<>();  
      List<Empleado> trabajadores=datos.getEmpleados();
      for(Empleado e:trabajadores){
          if(e.getCargo().equals("OPmov")){
              res.add(e);
          }
      }      
        return res;
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Supervisor Seleccionado", ((Empleado) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        aviso.getHistoricoReciente().setIdEmpleado(SupervisorSelected);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Supervisor Deseleccionado", ((Empleado) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public Empleado getSupervisorSelected() {
        return SupervisorSelected;
    }

    public void setSupervisorSelected(Empleado SupervisorSelected) {
        this.SupervisorSelected = SupervisorSelected;
    }
   
          
}
