/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.session;

import entities.Test;
import entities.Users;
import entities.List;
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
public class ListThemeManager {
    
    @PersistenceContext(unitName = "ProjectPU")
    private EntityManager em;
        
    public entities.List getList(long idList) {  
      return em.find(entities.List.class, idList);  
    }
}
