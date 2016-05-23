/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.negocio;

import emasa.entidades.Cliente;
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
public class ClienteNegocio {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "ProyEmasaTarea3-ejbPU")
    EntityManager em;
    
     public void addClient(Cliente c) {
        em.persist(c);
    }
}
