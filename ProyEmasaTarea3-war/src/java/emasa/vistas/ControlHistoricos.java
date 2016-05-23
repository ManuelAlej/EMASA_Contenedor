/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.entidades.Historico;
import emasa.entidades.Visitas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Jose
 */
@Named(value = "controlHistoricos")
@SessionScoped
public class ControlHistoricos implements Serializable {

    private Historico HistoricoSelected;
    
    @Inject
    private OpcionesAviso aviso;
    @Inject
    private CalendarioVista calendario;
            
    public ControlHistoricos() {
    }
     public void onRowSelect(SelectEvent event) {
    
        FacesMessage msg = new FacesMessage("Historico Seleccionado", String.valueOf(((Historico) event.getObject()).getDireccion()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        
    }
    
    public Historico getHistoricoSelected() {
        return HistoricoSelected;
    }

    public void setHistoricoSelected(Historico HistoricoSelected) {
        
        this.HistoricoSelected = HistoricoSelected;
    }
    public List<Historico> getHistoricos(){
        List<Historico> res=new ArrayList<>();
       
        Date fechaInicio=calendario.getDate2();
        Date fechaFin=calendario.getDate3();
        if(fechaInicio!=null&&fechaFin!=null){
            
            for(Historico c: aviso.getHistoricos()){
             Date fechaHistorico=c.getHistoricoPK().getFechaActualizacion();
                if(fechaHistorico.after(fechaInicio)&&fechaHistorico.before(fechaFin)){
                 res.add(c);
                }
            }
        }else{
          res=aviso.getHistoricos();
        }        
        return res;
    }
    
}
