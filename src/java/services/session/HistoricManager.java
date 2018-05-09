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
    
    public List<entities.Testresult> getTestHistoric(entities.List list){
        Query query = em.createNamedQuery("Testresult.findByIdlist");
        query.setParameter("idlist", list);
        return query.getResultList();
    }
    
    public List<entities.Testresult> getUserTests(entities.Users user){
        Query query = em.createNamedQuery("Testresult.findByIduser");
        query.setParameter("iduser", user);
        return query.getResultList();
    }
    
    public entities.Test getUserTests(entities.Users user, entities.Test test){
        Query query = em.createNamedQuery("Test.findByIduserAndIdTest");
        query.setParameter("iduser", user);
        query.setParameter("idtest", test);
        List<entities.Test> result = query.getResultList();
        if(result == null || result.isEmpty()){
            return new entities.Test();
        }
        return result.get(0);
    }
    
    public void addUserTestResult(entities.Testresult testresult){
        em.persist(testresult);
        em.flush();
    }
}
