/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.negocio;

import emasa.entidades.Brigada;
import emasa.entidades.Empleado;
import emasa.entidades.Visitas;
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
public class VisitasNegocio {

    @PersistenceContext(unitName = "ProyEmasaTarea3-ejbPU")
    private EntityManager em;

    public void persist(Visitas visita) {
        em.persist(visita);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<Visitas> buscarVisitas(Empleado e)
    {
         TypedQuery<Visitas> query=em.createNamedQuery("visitas.buscartodas",Visitas.class);
         query.setParameter("idEmpleado", e.getIdEmpleado() );
        
        return query.getResultList();
        
    }
    
    
    
}
