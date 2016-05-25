/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.negocio;

import emasa.entidades.Aviso;
import emasa.entidades.Historico;
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
public class HistoricoNegocio {

    @PersistenceContext(unitName = "ProyEmasaTarea3-ejbPU")
    private EntityManager em;

    public void persist(Historico h) {
        em.persist(h);
    }
    
 public List <Historico> buscarHistoricos(Aviso aviso)
  {
      Integer idaviso=aviso.getIdAviso();
      TypedQuery<Historico> query;
    query = em.createQuery("SELECT l from Historico l where l.aviso.idAviso = :daviso AND l.fechaCierre IS NULL ", Historico.class);
     query.setParameter("daviso", idaviso );
      return query.getResultList();
  }
 
  public List <Historico> buscarHistoricos(Integer idaviso)
  {      
      TypedQuery<Historico> query;
    query = em.createQuery("SELECT l from Historico l where l.aviso.idAviso = :daviso", Historico.class);
     query.setParameter("daviso", idaviso );
      return query.getResultList();
  }
  public List <Historico> buscarHistoricos(Integer idaviso,Integer supervisor)
  {      
    //  System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"+idaviso+" : "+supervisor);
      TypedQuery<Historico> query;
    query = em.createQuery("SELECT l from Historico l where l.aviso.idAviso = :daviso AND l.historicoPK.supervisor= :supervisor", Historico.class);
     query.setParameter("supervisor", supervisor );
     query.setParameter("daviso", idaviso );
     System.out.println("#########################################"+query.getResultList());
      return query.getResultList();
  }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void actualizarHistorico(Historico his) {
        
        em.merge(his);
        
    }
}
