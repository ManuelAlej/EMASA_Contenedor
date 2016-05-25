/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.negocio;

import emasa.entidades.Empleado;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author malex
 */
@Stateless
@LocalBean
public class EmpleadoNegocio {
    
    @PersistenceContext(unitName = "ProyEmasaTarea3-ejbPU")
    EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public List<Empleado> listaSupervisores()
    {
        TypedQuery<Empleado> query=em.createNamedQuery("lista.Supervisores",Empleado.class);
        return query.getResultList();
    }
    public List<Empleado> listaEmpleados(){
        TypedQuery<Empleado> query=em.createNamedQuery("lista.Empleados",Empleado.class);
        return query.getResultList();
    }
    public Empleado findEmployee(String usuario, String password){
        TypedQuery<Empleado> query=em.createNamedQuery("lista.login",Empleado.class);
        query.setParameter("eMail", usuario );
        query.setParameter("password", password);
        return query.getSingleResult();
        
       
    }
    
     public List<Empleado> listaOpmov()
    {
        TypedQuery<Empleado> query=em.createNamedQuery("lista.Opmov",Empleado.class);
        return query.getResultList();
    }
    
    
    public void crearSupervisor(Empleado e) {
        em.persist(e);
    }
    
}
