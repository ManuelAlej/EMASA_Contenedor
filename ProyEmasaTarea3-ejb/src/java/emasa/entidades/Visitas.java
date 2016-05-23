/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.Column;

/**
 *
 * @author Lupi
 */
@NamedQueries({
    
    @NamedQuery(name="visitas.buscartodas",
                query="SELECT c FROM Visitas c"),
}) 
@Entity
@Table(name = "VISITAS")
public class Visitas implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID_VISITA")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idVisita;
    
    @Basic(optional = false)
    @Column(name = "FECHA_VISITA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVisita;
    
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleado idEmpleado;
    
    @JoinColumns({
        @JoinColumn(name = "ID_AVISO", referencedColumnName = "ID_AVISO"),
        @JoinColumn(name = "FECHA_ACTUALIZACION", referencedColumnName = "FECHA_ACTUALIZACION"),
        @JoinColumn(name = "SUPERVISOR", referencedColumnName = "SUPERVISOR")})
    @OneToOne(optional = false)
    private Historico historico;
    

    public Visitas() {
    }

    public Visitas(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public Visitas(Date fechaVisita, Empleado empleado) {
        this.fechaVisita = fechaVisita;
        this.idEmpleado = empleado;
    }

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
    }

    public Integer getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(Integer idVisita) {
        this.idVisita = idVisita;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public Empleado getEmpleado() {
        return idEmpleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.idEmpleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.idVisita);
        hash = 17 * hash + Objects.hashCode(this.fechaVisita);
        hash = 17 * hash + Objects.hashCode(this.idEmpleado);
        hash = 17 * hash + Objects.hashCode(this.historico);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Visitas other = (Visitas) obj;
        if (!Objects.equals(this.idVisita, other.idVisita)) {
            return false;
        }
        if (!Objects.equals(this.fechaVisita, other.fechaVisita)) {
            return false;
        }
        if (!Objects.equals(this.idEmpleado, other.idEmpleado)) {
            return false;
        }
        if (!Objects.equals(this.historico, other.historico)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Visitas{" + "idVisita=" + idVisita + ", fechaVisita=" + fechaVisita + ", empleado=" + idEmpleado + ", historico=" + historico + '}';
    }
}
