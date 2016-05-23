/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.entidades.Empleado;
import emasa.entidades.Visitas;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@Named(value = "controlVisitas")
@SessionScoped
public class ControlVisitas implements Serializable {

    private Empleado empleado;
    private Visitas VisitaSelected;
    @Inject
    private LoginBean login;
    
    /**
     * Creates a new instance of ControlVisitas
     */
    
    public ControlVisitas() {
    }
    
    
    public boolean isEmpleado(){
        empleado=login.getUsr();
        boolean res=false;
        if(empleado.getCargo().equals("OPmov")){
            res=true;
        }
        return res;
    }
    public List<Visitas> getVisitas(){
        empleado=login.getUsr();
        return (List<Visitas>) empleado.getVisitasCollection();
    }
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Aviso Seleccionado", String.valueOf(((Visitas) event.getObject()).getFechaVisita()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Aviso Deseleccionado", String.valueOf(((Visitas) event.getObject()).getFechaVisita()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public Visitas getVisitaSelected() {
        return VisitaSelected;
    }

    public void setVisitaSelected(Visitas VisitaSelected) {
        this.VisitaSelected = VisitaSelected;
    }
    public String getFecha(Date fecha){
       
       String res="";
       if(fecha!=null){
           SimpleDateFormat formateador = new SimpleDateFormat("dd / MM / yyyy");
           res=formateador.format(fecha);
       }       
       return res;
    }
        
}
    
