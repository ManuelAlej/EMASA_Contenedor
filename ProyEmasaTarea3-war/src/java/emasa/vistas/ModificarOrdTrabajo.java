/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.entidades.Actuaciones;
import emasa.entidades.ActuacionesPK;
import emasa.entidades.Brigada;
import emasa.negocio.ActuacionesNegocio;
import emasa.negocio.BrigadaNegocio;
import emasa.negocio.OrdTrabajoNegocio;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author malex
 */
@Named(value = "modificarOrdTrabajo")
@SessionScoped

public class ModificarOrdTrabajo implements Serializable {

    @Inject
    private ControlOrdenTrabajo ord;

    @EJB
    OrdTrabajoNegocio ordTrabajoNegocio;
    @EJB 
    ActuacionesNegocio actuacionesNegocio;
    @EJB
    BrigadaNegocio brigadaNegocio;
    private String actuacionesRealizadas = "";
    private String actuacionesObservaciones = "";
    private Integer idAviso;
    private Integer supervisor;

    public Integer getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Integer supervisor) {
        this.supervisor = supervisor;
    }

    public Integer getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(Integer idAviso) {
        this.idAviso = idAviso;
    }

    public ControlOrdenTrabajo getOrd() {
        return ord;
    }

    public void setOrd(ControlOrdenTrabajo ord) {
        this.ord = ord;
    }

    public String getActuacionesObservaciones() {
        return actuacionesObservaciones;
    }

    public void setActuacionesObservaciones(String actuacionesObservaciones) {
        this.actuacionesObservaciones = actuacionesObservaciones;
    }

    public String getActuacionesRealizadas() {
        return actuacionesRealizadas;
    }

    public void setActuacionesRealizadas(String actuacionesRealizadas) {
        this.actuacionesRealizadas = actuacionesRealizadas;
    }

   
    public String getTrabajo_realizar() {
        return trabajo_realizar;
    }

    public void setTrabajo_realizar(String trabajo_realizar) {
        this.trabajo_realizar = trabajo_realizar;
    }
    private String trabajo_realizar;

    public BrigadaNegocio getBrigadaNegocio() {
        return brigadaNegocio;
    }

    public void setBrigadaNegocio(BrigadaNegocio brigadaNegocio) {
        this.brigadaNegocio = brigadaNegocio;
    }

    public OrdTrabajoNegocio getOrdTrabajoNegocio() {
        return ordTrabajoNegocio;
    }

    public void setOrdTrabajoNegocio(OrdTrabajoNegocio ordTrabajoNegocio) {
        this.ordTrabajoNegocio = ordTrabajoNegocio;
    }

    // private OrdTrabajo ord;
    /**
     * Creates a new instance of Orden_trabajo
     */
    public ModificarOrdTrabajo() {

    }

    @PostConstruct

    public void init() {

       idAviso=ord.getIdAviso();
       supervisor=ord.getSup();
        
        //orden_trabajo.add(new OrdTrabajo((integer)*10+1));
        if (ord.getOrdSelected().getEstado().equals("")) {
            ord.getOrdSelected().setEstado("---------");
        }

        if (actuacionesRealizadas.equals("")) {
            actuacionesRealizadas = "Vacio";
        }
        if (actuacionesObservaciones.equals("")) {
            actuacionesObservaciones = "Vacio";
        }

    }

    public String modificarActuacion() {
        //id_aviso,fecha_entrada,supervisor_asignado,descripcion,direccion,estado,duplicado,fechacierre,tipodeaviso,urgencia,ubicacion_gps,red_agua

        Actuaciones actuacion = new Actuaciones();

        actuacion.setOperRealizadas(actuacionesRealizadas);
        actuacion.setObservaciones(actuacionesObservaciones);
        
        actuacion.setActuacionesPK(new ActuacionesPK(new Date(),ord.getOrdSelected().getIdOrden()));
        
        

        

        ord.getOrdSelected().getActuacionesCollection().add(actuacion);

        ordTrabajoNegocio.actualizarOrden(ord.getOrdSelected());
        
       // actuacionesNegocio.persist(actuacion);

        return "modificarOrdenTrabajoClient.xhtml";

    }

    public String historicoOT() {
        return "historicoOTClient.xhtml";
    }

    public String cerrarOT() {

        if (ord.getOrdSelected().getEstado().equals("abierto")) {
            ord.getOrdSelected().setEstado("cerrado");

            ordTrabajoNegocio.actualizarOrden(ord.getOrdSelected());
            return "avisoClient.xhtml";
        }

        return null;

    }
    public String listaActuaciones()
    {
        return "historicoOTClient.xhtml";
    }

}
