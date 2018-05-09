/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.session;

import Helper.EntityHelper;
import entities.Users;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author User
 */
@Stateful
public class UserManager {
    
    @PersistenceContext(unitName = "ProjectPU")
    private EntityManager em;

    public Users connect(String login, String password) {

        Query query = em.createNamedQuery("Users.connect");
        query.setParameter("login", login);
        query.setParameter("password", password);
        return (Users)query.getResultList().get(query.getFirstResult());
    }
    
    public Users update(Users user){
        return em.merge(user);
    }
    
    public long getMaxIndexUsers(){
        return EntityHelper.getMaxIndex(em, Helper.Constants._QUERYFORUSERS);
    }
}
