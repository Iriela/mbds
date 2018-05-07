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
        
    public List<entities.List> getUserList(Users user){
        Query query = em.createNamedQuery("List.findByIduser");
        query.setParameter("iduser", user);
        return query.getResultList();
    }
}
