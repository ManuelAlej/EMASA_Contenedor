/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.negocio;


import emasa.entidades.Aviso;
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
public class AvisoNegocio {
@PersistenceContext(unitName = "ProyEmasaTarea3-ejbPU")
    EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

public void actualizarAviso(Aviso a) {
        em.merge(a);
    }

 public List<Aviso> buscarAvisos(Empleado e){
        TypedQuery<Aviso> query=em.createNamedQuery("lista.avisos",Aviso.class);
        query.setParameter("idEmpleado", e.getIdEmpleado() );
        
        return query.getResultList();
        
        
    }
}
