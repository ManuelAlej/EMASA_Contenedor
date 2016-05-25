/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Lupi
 */
@Entity
@Table(name = "AVISO")
@NamedQueries({
    
    @NamedQuery(name="lista.avisos",
                query="SELECT l FROM Aviso l, Historico h WHERE l.idAviso = h.historicoPK.idAviso AND h.historicoPK.supervisor=:idEmpleado AND h.fechaCierre IS NULL AND h.duplicado = FALSE"),
    
        
})
public class Aviso implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID_AVISO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAviso;
    
    @Basic(optional = false)
    @Column(name = "FECHA_ENTRADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrada;
    
    @Basic(optional = false)
    @Column(name = "ORIGEN")
    private String origen;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aviso")
    private Collection<Historico> historico;
    
    @OneToMany(mappedBy = "relacionado")
    private Collection<Aviso> avisosRelacionados;
    
    @JoinColumn(name = "RELACIONADO", referencedColumnName = "ID_AVISO")
    @ManyToOne
    private Aviso relacionado;
    
    @JoinColumn(name = "DNI", referencedColumnName = "DNI")
    @ManyToOne
    private Cliente dni;
    
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne
    private Empleado idEmpleado;

    public Aviso() {
    }

    
    public Aviso(Integer idAviso) {
        this.idAviso = idAviso;
    }

    public Aviso(Integer idAviso, Date fechaEntrada, String origen) {
        this.idAviso = idAviso;
        this.fechaEntrada = fechaEntrada;
        this.origen = origen;
    }

    public Integer getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(Integer idAviso) {
        this.idAviso = idAviso;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Collection<Historico> getHistoricoCollection() {
        return historico;
    }

    public void setHistoricoCollection(Collection<Historico> historicoCollection) {
        this.historico = historicoCollection;
    }

    public Collection<Aviso> getAvisoCollection() {
        return avisosRelacionados;
    }

    public void setAvisoCollection(Collection<Aviso> avisoCollection) {
        this.avisosRelacionados = avisoCollection;
    }

    public Aviso getRelacionado() {
        return relacionado;
    }

    public void setRelacionado(Aviso relacionado) {
        this.relacionado = relacionado;
    }

    public Cliente getDni() {
        return dni;
    }

    public void setDni(Cliente dni) {
        this.dni = dni;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
/*
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAviso != null ? idAviso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aviso)) {
            return false;
        }
        Aviso other = (Aviso) object;
        if ((this.idAviso == null && other.idAviso != null) || (this.idAviso != null && !this.idAviso.equals(other.idAviso))) {
            return false;
        }
        return true;
    }
*/
    @Override
    public String toString() {
        return "Aviso{" + "idAviso=" + idAviso + ", fechaEntrada=" + fechaEntrada + ", origen=" + origen + '}';
    }  
}
