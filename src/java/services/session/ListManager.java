/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.session;

import Helper.EntityHelper;
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
@LocalBean
public class ListManager {
    @PersistenceContext(unitName = "ProjectPU")
    private EntityManager em;
    
     public entities.List update(entities.List list) { 
        return em.merge(list);
    }

    public static entities.List delete(entities.List list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public List<entities.List> getUserList(Users user){
        Query query = em.createNamedQuery("List.findByIduser");
        query.setParameter("iduser", user);
        List<entities.List> list = query.getResultList();
        list.forEach((item) -> {
            System.out.println(item.getTitle());
        });
        return list;
    }
    
    public List<entities.List> getAllList(){
        Query query = em.createNamedQuery("List.findAll");
        System.out.println(">>>>>");
        List<entities.List> list = query.getResultList();
        
        list.forEach((item) -> {
            System.out.println(item.getTitle());
        });
        return list;
    }
    
    public void deleteAllList() {
        Query query = em.createNamedQuery("List.deleteAll");
        query.executeUpdate();
        em.flush();
    }
    public long getMaxIndexList(){
        return EntityHelper.getMaxIndex(em, Helper.Constants._QUERYFORLIST)+1;
    }
}
