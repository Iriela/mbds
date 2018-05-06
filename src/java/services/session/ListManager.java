/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.session;

import entities.Test;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author iriel
 */
@Stateless
public class ListManager {
    
    @PersistenceContext(unitName = "ProjectPU")
    private EntityManager em;
    
    public List<Test> getUserTests(int user) {
        Query query = em.createQuery("SELECT t FROM Test t");
        //query.setParameter("iduser", ""+user);
        //System.out.println(" user id: "+user.getIduser());
        return query.getResultList();
    }
    
    public List<entities.List> getUserList(int user){
        Query query = em.createQuery("SELECT l FROM List l");
        return query.getResultList();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
