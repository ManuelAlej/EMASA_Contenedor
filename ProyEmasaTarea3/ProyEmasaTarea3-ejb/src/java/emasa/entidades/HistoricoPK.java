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
public class HistoricoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_AVISO")
    private Integer idAviso;
    
    @Basic(optional = false)
    @Column(name = "FECHA_ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    
    @Basic(optional = false)
    @Column(name = "SUPERVISOR")
    private Integer supervisor;

    public HistoricoPK() {
    }

    public HistoricoPK(Integer idAviso, Date fechaActualizacion, Integer supervisor) {
        this.idAviso = idAviso;
        this.fechaActualizacion = fechaActualizacion;
        this.supervisor = supervisor;
    }

    public Integer getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(Integer idAviso) {
        this.idAviso = idAviso;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Integer supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAviso != null ? idAviso.hashCode() : 0);
        hash += (fechaActualizacion != null ? fechaActualizacion.hashCode() : 0);
        hash += (supervisor != null ? supervisor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoPK)) {
            return false;
        }
        HistoricoPK other = (HistoricoPK) object;
        if ((this.idAviso == null && other.idAviso != null) || (this.idAviso != null && !this.idAviso.equals(other.idAviso))) {
            return false;
        }
        if ((this.fechaActualizacion == null && other.fechaActualizacion != null) || (this.fechaActualizacion != null && !this.fechaActualizacion.equals(other.fechaActualizacion))) {
            return false;
        }
        if ((this.supervisor == null && other.supervisor != null) || (this.supervisor != null && !this.supervisor.equals(other.supervisor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HistoricoPK{" + "idAviso=" + idAviso + ", fechaActualizacion=" + fechaActualizacion + ", supervisor=" + supervisor + '}';
    }   
}
