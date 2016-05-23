/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.negocio;

import emasa.entidades.Brigada;
import emasa.entidades.OrdTrabajo;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author malex
 */
@Stateless
@LocalBean
public class OrdTrabajoNegocio {

    @PersistenceContext(unitName = "ProyEmasaTarea3-ejbPU")
    private EntityManager em;

   
    
   public void anadirOrden(OrdTrabajo t)
   {
        em.persist(t);
   }
   public void actualizarOrden(OrdTrabajo t)
   {
        em.merge(t);
   }

    
    
    
}
