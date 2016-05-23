/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.entidades.Aviso;
import emasa.entidades.Datos;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Rocco
 */
@Named(value = "controlRelacion")
@Dependent
public class ControlRelacion {

    @Inject
    private OpcionesAviso aviso;
    @Inject
    private Datos datos;
    private Aviso avisoSelected;
    /**
     * Creates a new instance of ControlRelacion
     */
    public ControlRelacion() {
    }
    public List<Aviso> getAvisos(){
       List<Aviso> avisos=datos.getAvisos();
       return avisos;                
    }
      public Aviso getAvisoSelected() {
        return avisoSelected;
    }

    public void setAvisoSelected(Aviso avisoSelected) {
        this.avisoSelected = avisoSelected;
    }
    
    public void onRowSelect(SelectEvent event) {
       aviso.getAviso().setRelacionado((Aviso) event.getObject());
        FacesMessage msg = new FacesMessage("Aviso Seleccionado", String.valueOf(((Aviso) event.getObject()).getIdAviso()));  
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Aviso Deseleccionado", String.valueOf(((Aviso) event.getObject()).getIdAviso()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
