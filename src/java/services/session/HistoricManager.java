/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author iriel
 */
@Stateless
public class HistoricManager {
    @PersistenceContext(unitName = "ProjectPU")
    private EntityManager em;
    
    public List<entities.Testhistoric> getUserTests(int idUser){
        Query query = em.createNamedQuery("Testhistoric.findByIduser");
        query.setParameter("iduser", idUser);
        return query.getResultList();
    }
    
    public entities.Testhistoric getUserTests(int idUser, int idTest){
        Query query = em.createNamedQuery("Testhistoric.findByIduserAndIdTest");
        query.setParameter("iduser", idUser);
        query.setParameter("idtest", idTest);
        List<entities.Testhistoric> result = query.getResultList();
        if(result == null || result.isEmpty()){
            return new entities.Testhistoric();
        }
        return result.get(0);
    }
}
