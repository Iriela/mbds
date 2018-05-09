/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.session;

import entities.Test;
import entities.Users;
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
    
     public static entities.List update(entities.List list) { 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    }

    public static entities.List delete(entities.List list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public List<entities.List> getUserList(Users user){
        Query query = em.createNamedQuery("List.findByIduser");
        query.setParameter("iduser", user);
        return query.getResultList();
    }
    
    public void deleteAllList() {
        Query query = em.createNamedQuery("Word.deleteAll");
        query.executeUpdate();
    }
}
