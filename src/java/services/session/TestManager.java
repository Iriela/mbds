/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.session;

import entities.Test;
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
}   
