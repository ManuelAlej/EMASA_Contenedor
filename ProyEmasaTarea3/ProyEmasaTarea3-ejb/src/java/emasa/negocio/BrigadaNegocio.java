/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.negocio;

import emasa.entidades.Brigada;
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
public class BrigadaNegocio {

    @PersistenceContext(unitName = "ProyEmasaTarea3-ejbPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    public List<Brigada> buscarBrigadas()
    {
        TypedQuery<Brigada> query=em.createNamedQuery("brigada.buscartodas",Brigada.class);
    
        
        return query.getResultList();
    }

    public void persist(Object object) {
        em.persist(object);
    }
    public Brigada buscarBrigada(Integer idBrigada) {
       
        Brigada brigada=em.find(Brigada.class, idBrigada);
        return brigada;
    }
}
