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
@Embeddable
public class ActuacionesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "FECHA_ACTUACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActuacion;
    
    @Basic(optional = false)
    @Column(name = "ID_ORDEN")
    private Integer idOrden;

    public ActuacionesPK() {
    }

    public ActuacionesPK(Date fechaActuacion, Integer idOrden) {
        this.fechaActuacion = fechaActuacion;
        this.idOrden = idOrden;
    }

    public Date getFechaActuacion() {
        return fechaActuacion;
    }

    public void setFechaActuacion(Date fechaActuacion) {
        this.fechaActuacion = fechaActuacion;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fechaActuacion != null ? fechaActuacion.hashCode() : 0);
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActuacionesPK)) {
            return false;
        }
        ActuacionesPK other = (ActuacionesPK) object;
        if ((this.fechaActuacion == null && other.fechaActuacion != null) || (this.fechaActuacion != null && !this.fechaActuacion.equals(other.fechaActuacion))) {
            return false;
        }
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ActuacionesPK{" + "fechaActuacion=" + fechaActuacion + ", idOrden=" + idOrden + '}';
    }    
}
