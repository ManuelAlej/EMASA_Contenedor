/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.entidades.Aviso;
import emasa.entidades.Historico;
import emasa.entidades.Visitas;
import emasa.negocio.AvisoNegocio;
import emasa.negocio.HistoricoNegocio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Jose
 */
@Named(value = "controlHistoricos")
@ViewScoped
public class ControlHistoricos implements Serializable {

    private Historico HistoricoSelected;
    private Aviso aviso;
    @EJB
    private AvisoNegocio avisoNegocio;
     @EJB
    private HistoricoNegocio hisNegocio;
    @Inject
    private CalendarioVista calendario;
    private Integer id;       
    
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
        Integer idaviso;
        if(id==null){
            idaviso=(Integer)FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("id");
            id=idaviso;
        }  
        idaviso=id;
        List<Historico> res=new ArrayList<>();
   
        Date fechaInicio=calendario.getDate2();
        Date fechaFin=calendario.getDate3();
        List<Historico>historicosX= hisNegocio.buscarHistoricos(idaviso);
        if(fechaInicio!=null&&fechaFin!=null){
           
            
            for(Historico c: historicosX){
             Date fechaHistorico=c.getHistoricoPK().getFechaActualizacion();
                if(fechaHistorico.after(fechaInicio)&&fechaHistorico.before(fechaFin)){
                 res.add(c);
                }
            }
        }else{
          res=historicosX;
        }        
        return res;
    }
    public String irDetalles(Historico his){
        FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("Historico", his);
        System.out.println("pppppppppppppppppppppppppppppppppppppppppppppp"+his);
        return "HistDetalles.xhtml";
    }
    
  
    @PostConstruct
    public void init(){
                    
        HistoricoSelected=(Historico) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("Historico");
        System.out.println("888888888888888888888888888888888888888"+HistoricoSelected);
    }
    
}
