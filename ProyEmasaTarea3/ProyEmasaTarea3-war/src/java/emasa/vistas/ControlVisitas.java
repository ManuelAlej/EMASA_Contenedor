/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.entidades.Aviso;
import emasa.entidades.Empleado;
import emasa.entidades.Visitas;
import emasa.negocio.VisitasNegocio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
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


@Named(value = "controlVisitas")
@ViewScoped
public class ControlVisitas implements Serializable {

    private Empleado empleado;
    private Visitas VisitaSelected;
    @Inject
    private LoginBean login;
    @EJB
    private VisitasNegocio visitaEJB;
    
    /**
     * Creates a new instance of ControlVisitas
     */
    
    public ControlVisitas() {
    }
    
    
    public boolean isEmpleado(){
        empleado=login.getUsr();
        boolean res=false;
        if(empleado.getCargo().equals("Opmov")){
            res=true;
        }
        return res;
    }
   public List<Visitas> getVisitas(){
        empleado=login.getUsr();
        
        
        List<Visitas> help = new ArrayList<Visitas>();
        help=visitaEJB.buscarVisitas(empleado);
        
        System.out.println("JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJjjj    "+empleado+help);
        
        
        return help;
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
    public String verVisita(Visitas visita){
        Aviso av =visita.getHistorico().getAviso();
        System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL     "+av);
        FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("avisoSelected",av);
        
        return "avisoClient.xhtml";
    }
}
    
