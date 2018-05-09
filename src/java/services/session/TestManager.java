/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.session;

import Helper.EntityHelper;
import entities.Test;
import entities.Word;
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
public class TestManager {
    @PersistenceContext(unitName = "ProjectPU")
    private EntityManager em;
        
    public List<Test> getTests(){
        Query query = em.createNamedQuery("Test.findAll");
        return query.getResultList();
    }
    
    public long getMaxIndexTest(){
        return EntityHelper.getMaxIndex(em, Helper.Constants._QUERYFORTEST)+1;
    }
    
    public long getMaxIndexTestResult(){
        System.out.println("EntityHelper.getMaxIndex(em, Helper.Constants._QUERYFORTESTRESULT);");
        return EntityHelper.getMaxIndex(em, Helper.Constants._QUERYFORTESTRESULT)+1;
    }
    
    public Test update(Test test) {
        return em.merge(test);
    }
    
    public void deleteAllTest() {
        Query query = em.createNamedQuery("Test.deleteAll");
        query.executeUpdate();
        em.flush();
    }
}   
