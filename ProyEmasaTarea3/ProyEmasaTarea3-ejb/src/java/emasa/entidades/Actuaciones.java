/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Lupi
 */
@Entity
@Table(name = "ACTUACIONES")
public class Actuaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected ActuacionesPK actuacionesPK;
    
    @Basic(optional = false)
    @Column(name = "OPER_REALIZADAS")
    private String operRealizadas;
    
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    
    @JoinColumn(name = "ID_ORDEN", referencedColumnName = "ID_ORDEN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OrdTrabajo ordTrabajo;

    public Actuaciones() {
    }

    public Actuaciones(ActuacionesPK actuacionesPK) {
        this.actuacionesPK = actuacionesPK;
    }

    public Actuaciones(ActuacionesPK actuacionesPK, String operRealizadas) {
        this.actuacionesPK = actuacionesPK;
        this.operRealizadas = operRealizadas;
    }

    public Actuaciones(Date fechaActuacion, Integer idOrden) {
        this.actuacionesPK = new ActuacionesPK(fechaActuacion, idOrden);
    }

    public ActuacionesPK getActuacionesPK() {
        return actuacionesPK;
    }

    public void setActuacionesPK(ActuacionesPK actuacionesPK) {
        this.actuacionesPK = actuacionesPK;
    }

    public String getOperRealizadas() {
        return operRealizadas;
    }

    public void setOperRealizadas(String operRealizadas) {
        this.operRealizadas = operRealizadas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public OrdTrabajo getOrdTrabajo() {
        return ordTrabajo;
    }

    public void setOrdTrabajo(OrdTrabajo ordTrabajo) {
        this.ordTrabajo = ordTrabajo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actuacionesPK != null ? actuacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actuaciones)) {
            return false;
        }
        Actuaciones other = (Actuaciones) object;
        if ((this.actuacionesPK == null && other.actuacionesPK != null) || (this.actuacionesPK != null && !this.actuacionesPK.equals(other.actuacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Actuaciones{" + "fecha_actuacion=" + actuacionesPK.getFechaActuacion() + ", Orden=" + actuacionesPK.getIdOrden() + ", operRealizadas=" + operRealizadas + ", observaciones=" + observaciones + ", ordTrabajo=" + ordTrabajo + '}';
    }   
}
