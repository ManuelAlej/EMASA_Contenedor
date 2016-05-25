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
@Table(name = "EMPLEADO")
@NamedQueries({
    
    @NamedQuery(name="lista.Supervisores",
                query="SELECT l FROM Empleado l WHERE l.cargo='Supervisor' order by l.idEmpleado"),
    @NamedQuery(name="lista.Empleados",
                query="SELECT l FROM Empleado l order by l.idEmpleado"),
        @NamedQuery(name="lista.login",
                query="SELECT l FROM Empleado l WHERE l.eMail = :eMail and l.password = :password"),
        @NamedQuery(name="lista.Opmov",
                query="SELECT l FROM Empleado l WHERE l.cargo='Opmov' order by l.idEmpleado"),
})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID_EMPLEADO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEmpleado;
    
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Basic(optional = false)
    @Column(name = "APELLIDOS")
    private String apellidos;
    
    @Basic(optional = false)
    @Column(name = "DNI")
    private String dni;
    
    @Basic(optional = false)
    @Column(name = "E_MAIL")
    private String eMail;
    
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    
    @Basic(optional = false)
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    
    @Basic(optional = false)
    @Column(name = "CARGO")
    private String cargo;
    
    @Basic(optional = false)
    @Column(name = "TURNO")
    private Integer turno;
    
    @Column(name = "ZONA")
    private String zona;
    
    @Column(name = "ESPECIALIDAD")
    private String especialidad;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private Collection<Historico> historico;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private Collection<Visitas> visitas;
    
    @JoinColumn(name = "NUM_BRIGADA", referencedColumnName = "NUM_BRIGADA")
    @ManyToOne
    private Brigada numBrigada;
    
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<Aviso> avisos;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(Integer idEmpleado, String nombre, String apellidos, String dni, String eMail, String password, String departamento, String cargo, Integer turno) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.eMail = eMail;
        this.password = password;
        this.departamento = departamento;
        this.cargo = cargo;
        this.turno = turno;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Collection<Historico> getHistoricoCollection() {
        return historico;
    }

    public void setHistoricoCollection(Collection<Historico> historicoCollection) {
        this.historico = historicoCollection;
    }

    public Collection<Visitas> getVisitasCollection() {
        return visitas;
    }

    public void setVisitasCollection(Collection<Visitas> visitasCollection) {
        this.visitas = visitasCollection;
    }

    public Brigada getNumBrigada() {
        return numBrigada;
    }

    public void setNumBrigada(Brigada numBrigada) {
        this.numBrigada = numBrigada;
    }


    public Collection<Aviso> getAvisoCollection() {
        return avisos;
    }

    public void setAvisoCollection(Collection<Aviso> avisoCollection) {
        this.avisos = avisoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", eMail=" + eMail + ", password=" + password + ", departamento=" + departamento + ", cargo=" + cargo + ", turno=" + turno + ", zona=" + zona + ", especialidad=" + especialidad + '}';
    }    
}
