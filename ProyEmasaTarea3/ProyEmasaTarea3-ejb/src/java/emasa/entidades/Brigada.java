/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author Lupi
 */
@Entity
@Table(name = "BRIGADA")
@NamedQueries({
    
    @NamedQuery(name="brigada.buscartodas",
                query="SELECT c FROM Brigada c"),
    
    
}) 
public class Brigada implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "NUM_BRIGADA")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numBrigada;
    
    @Basic(optional = false)
    @Column(name = "TURNO")
    private Integer turno;
    
    @Basic(optional = false)
    @Column(name = "CONTRATA")
    private Character contrata;
    
    @OneToMany(mappedBy = "numBrigada")
    private Collection<Empleado> miembros;

    public Brigada() {
    }

    public Brigada(Integer numBrigada) {
        this.numBrigada = numBrigada;
    }

    public Brigada(Integer numBrigada, Integer turno, Character contrata) {
        this.numBrigada = numBrigada;
        this.turno = turno;
        this.contrata = contrata;
    }

    public Integer getNumBrigada() {
        return numBrigada;
    }

    public void setNumBrigada(Integer numBrigada) {
        this.numBrigada = numBrigada;
    }

    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }

    public Character getContrata() {
        return contrata;
    }

    public void setContrata(Character contrata) {
        this.contrata = contrata;
    }

    public Collection<Empleado> getEmpleadoCollection() {
        return miembros;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.miembros = empleadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numBrigada != null ? numBrigada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brigada)) {
            return false;
        }
        Brigada other = (Brigada) object;
        if ((this.numBrigada == null && other.numBrigada != null) || (this.numBrigada != null && !this.numBrigada.equals(other.numBrigada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Brigada{" + "numBrigada=" + numBrigada + ", turno=" + turno + ", contrata=" + contrata + '}';
    }    
}
