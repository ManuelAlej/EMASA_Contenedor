/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Lupi
 */
@Entity
@Table(name = "ORD_TRABAJO")
@NamedQueries({
    
    @NamedQuery(name="OrdTrabajo.buscarPorNombre",
                query="SELECT c FROM OrdTrabajo c WHERE c.idOrden = :idOrden"),
}) 
public class OrdTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ORDEN")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idOrden;
    
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    @Basic(optional = false)
    @Column(name = "TRABAJO_A_REALIZAR")
    private String trabajoARealizar;
    
    @JoinColumn(name = "NUM_BRIGADA", referencedColumnName = "NUM_BRIGADA")
    @ManyToOne
    private Brigada numBrigada;
    
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    
    @Column(name = "FECHA_FINALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinalizacion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordTrabajo")
    private Collection<Actuaciones> actuaciones = new ArrayList<>(); ;
    
    @JoinColumns({
        @JoinColumn(name = "ID_AVISO", referencedColumnName = "ID_AVISO"),
        @JoinColumn(name = "FECHA_ACTUALIZACION", referencedColumnName = "FECHA_ACTUALIZACION"),
        @JoinColumn(name = "SUPERVISOR", referencedColumnName = "SUPERVISOR")})
    @ManyToOne(cascade={CascadeType.PERSIST},fetch=FetchType.LAZY) //cambiado
    private Historico historico;

    public OrdTrabajo() {
    }

    public OrdTrabajo(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public OrdTrabajo(Integer idOrden, Date fechaCreacion, String trabajoARealizar, Brigada numBrigada, String estado) {
        this.idOrden = idOrden;
        this.fechaCreacion = fechaCreacion;
        this.trabajoARealizar = trabajoARealizar;
        this.numBrigada = numBrigada;
        this.estado = estado;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTrabajoARealizar() {
        return trabajoARealizar;
    }

    public void setTrabajoARealizar(String trabajoARealizar) {
        this.trabajoARealizar = trabajoARealizar;
    }

    public Brigada getNumBrigada() {
        return numBrigada;
    }

    public void setNumBrigada(Brigada numBrigada) {
        this.numBrigada = numBrigada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Collection<Actuaciones> getActuacionesCollection() {
        return actuaciones;
    }

    public void setActuacionesCollection(Collection<Actuaciones> actuacionesCollection) {
        this.actuaciones = actuacionesCollection;
    }

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdTrabajo)) {
            return false;
        }
        OrdTrabajo other = (OrdTrabajo) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrdTrabajo{" + "idOrden=" + idOrden + ", fechaCreacion=" + fechaCreacion + ", trabajoARealizar=" + trabajoARealizar + ", numBrigada=" + numBrigada + ", estado=" + estado + ", fechaFinalizacion=" + fechaFinalizacion + '}';
    }  
}
