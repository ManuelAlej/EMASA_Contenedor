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
@Table(name = "HISTORICO")
public class Historico implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected HistoricoPK historicoPK;
    
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    
    @Basic(optional = false)
    @Column(name = "DUPLICADO")
    private Boolean duplicado;
    
    @Column(name = "FECHA_CIERRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;
    
    @Column(name = "TIPO_AVISO")
    private String tipoAviso;
    
    @Column(name = "CAUSA")
    private String causa;
    
    @Column(name = "URGENCIA")
    private String urgencia;
    
    @Column(name = "UBICACION_GPS")
    private String ubicacionGps;
    
    @Column(name = "RED_AGUA")
    private String redAgua;
    
    @Column(name = "DOC_ADJUNTO")
    private String docAdjunto;
    
    @JoinColumn(name = "ID_AVISO", referencedColumnName = "ID_AVISO", insertable = false, updatable = false)
     @ManyToOne(cascade={CascadeType.PERSIST},fetch=FetchType.LAZY) //cambiado
    private Aviso aviso;
    
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne(cascade={CascadeType.PERSIST},fetch=FetchType.LAZY) //cambiado
    private Empleado idEmpleado;
    
    @JoinColumn(name = "SUPERVISOR", referencedColumnName = "ID_EMPLEADO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleado idSupervisor;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "historico")
    private Visitas visitas;
    
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "historico") //cambiado
    private Collection<OrdTrabajo> ordenesTrabajo = new ArrayList<>(); //cambiado

    public Historico() {
    }

    public Historico(HistoricoPK historicoPK) {
        this.historicoPK = historicoPK;
    }

    public Historico(HistoricoPK historicoPK, String descripcion, String direccion, String estado, Boolean duplicado) {
        this.historicoPK = historicoPK;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.estado = estado;
        this.duplicado = duplicado;
    }

    public Historico(Integer idAviso, Date fechaActualizacion, Integer supervisor) {
        this.historicoPK = new HistoricoPK(idAviso, fechaActualizacion, supervisor);
    }

    public HistoricoPK getHistoricoPK() {
        return historicoPK;
    }

    public void setHistoricoPK(HistoricoPK historicoPK) {
        this.historicoPK = historicoPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getDuplicado() {
        return duplicado;
    }

    public void setDuplicado(Boolean duplicado) {
        this.duplicado = duplicado;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getTipoAviso() {
        return tipoAviso;
    }

    public void setTipoAviso(String tipoAviso) {
        this.tipoAviso = tipoAviso;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String getUbicacionGps() {
        return ubicacionGps;
    }

    public void setUbicacionGps(String ubicacionGps) {
        this.ubicacionGps = ubicacionGps;
    }

    public String getRedAgua() {
        return redAgua;
    }

    public void setRedAgua(String redAgua) {
        this.redAgua = redAgua;
    }

    public String getDocAdjunto() {
        return docAdjunto;
    }

    public void setDocAdjunto(String docAdjunto) {
        this.docAdjunto = docAdjunto;
    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Visitas getVisitas() {
        return visitas;
    }

    public void setVisitas(Visitas visitas) {
        this.visitas = visitas;
    }

    public Collection<OrdTrabajo> getOrdTrabajoCollection() {
        return ordenesTrabajo;
    }

    public void setOrdTrabajoCollection(Collection<OrdTrabajo> ordTrabajoCollection) {
        this.ordenesTrabajo = ordTrabajoCollection;
    }

    public Empleado getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(Empleado idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historicoPK != null ? historicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historico)) {
            return false;
        }
        Historico other = (Historico) object;
        if ((this.historicoPK == null && other.historicoPK != null) || (this.historicoPK != null && !this.historicoPK.equals(other.historicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Historico{" + "fechaActualizacion=" + historicoPK.getFechaActualizacion() + "aviso=" + historicoPK.getIdAviso()+ "supervisor=" + historicoPK.getSupervisor() + ", descripcion=" + descripcion + ", direccion=" + direccion + ", estado=" + estado + ", duplicado=" + duplicado + ", fechaCierre=" + fechaCierre + ", tipoAviso=" + tipoAviso + ", causa=" + causa + ", urgencia=" + urgencia + ", ubicacionGps=" + ubicacionGps + ", redAgua=" + redAgua + ", docAdjunto=" + docAdjunto + ", aviso=" + aviso + ", idEmpleado=" + idEmpleado + ", visitas=" + visitas + '}';
    }    
}
