/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import emasa.entidades.Aviso;
import emasa.entidades.Brigada;
import emasa.entidades.OrdTrabajo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author malex
 */
@Named(value = "controlOrdenTrabajo")
@RequestScoped
public class ControlOrdenTrabajo implements Serializable{

    

    
    private Integer idAviso;
    private Integer sup;

   
    
    private List<OrdTrabajo> listOrd;
    private OrdTrabajo ordSelected;
    private OrdTrabajo ordHelper;
    @Inject
    private OpcionesAviso aviso;

    public OrdTrabajo getOrdSelected() {
        return ordSelected;
    }

     public Integer getSup() {
        return sup;
    }

    public void setSup(Integer sup) {
        this.sup = sup;
    }
    
    public void setOrdSelected(OrdTrabajo ordSelected) {
        this.ordSelected = ordSelected;
    }

  public Integer getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(Integer idAviso) {
        this.idAviso = idAviso;
    }

    public OrdTrabajo getOrdHelper() {
        return ordHelper;
    }

    public void setOrdHelper(OrdTrabajo ordHelper) {
        this.ordHelper = ordHelper;
    }

    public OpcionesAviso getAviso() {
        return aviso;
    }

   
    public void setAviso(OpcionesAviso aviso) {
        this.aviso = aviso;
    }
    public ControlOrdenTrabajo() {
    }
    
    

    public List<OrdTrabajo> getListOrd() {
        return listOrd;
    }

    public void setListOrd(List<OrdTrabajo> listOrd) {
        this.listOrd = listOrd;
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Orden de trabajo Seleccionada", String.valueOf(((OrdTrabajo) event.getObject()).getIdOrden())); 
        
        
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Orden de trabajo no Seleccionada", String.valueOf(((OrdTrabajo) event.getObject()).getIdOrden()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
   
    
    @PostConstruct
    
    public void init()
    {
        List<OrdTrabajo> listOrden=new ArrayList<OrdTrabajo>();
        listOrd= new ArrayList<>();
      /*  ordHelper = new OrdTrabajo();
        ordHelper.setEstado("abierto");
        Date sys =new Date();
        ordHelper.setFechaCreacion(sys);
        ordHelper.setIdOrden(1);
        ordHelper.setNumBrigada(new Brigada(2)); 
        aviso.getHistoricoReciente().getOrdTrabajoCollection().add(ordHelper); */
        
        listOrden=(List<OrdTrabajo>) aviso.getHistoricoReciente().getOrdTrabajoCollection();
        
        for (OrdTrabajo t:  listOrden)
        {
            if (t.getEstado().equals("abierto"))
            {
                listOrd.add(t);
            }
        }
        
        idAviso=aviso.getAviso().getIdAviso();
        sup=aviso.getSupervisor();
        
        
    }
    
   
    
    
}
