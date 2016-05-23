/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.entidades.Actuaciones;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author malex
 */
@Named(value = "controlActuaciones")
@SessionScoped
public class ControlActuaciones implements Serializable {

    /**
     * Creates a new instance of ControlActuaciones
     */
   
    private Actuaciones actuacionSelected; 
    @Inject 
    private ModificarOrdTrabajo ordenTrabajo;

    public ModificarOrdTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(ModificarOrdTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }
    
     public Actuaciones getActuacionSelected() {
        return actuacionSelected;
    }

    public void setActuacionSelected(Actuaciones actuacionSelected) {
        this.actuacionSelected = actuacionSelected;
    }
    

   
    
    public ControlActuaciones() {
    }
    
    public List<Actuaciones> getActuaciones(){
        List<Actuaciones> res=new ArrayList<>();
        
        
        
        res=(List<Actuaciones>)ordenTrabajo.getOrd().getOrdSelected().getActuacionesCollection();
        
        
        return res;
        
        
       
        
    }
    
    public String volver()
    {
        return "modificarOrdenTrabajoClient.xhtml";
    }
}
