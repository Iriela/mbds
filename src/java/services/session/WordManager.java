/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.session;

import entities.Test;
import entities.Word;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author User
 */
@Stateless
@LocalBean
public class WordManager {
    
    @PersistenceContext(unitName = "ProjectPU")
    private EntityManager em;

    public List<Word> getWords() {
        Query query = em.createNamedQuery("Word.findAll");
        return query.getResultList();
    }
    
    public void deleteAllWords() {
        Query query = em.createNamedQuery("Word.deleteAll");
        query.executeUpdate();
        em.flush();
    }
    
    public List<Word> getWords(String idlist){
        Query query = em.createNamedQuery("Word.extendedFindListid");
        String p1 = "%|"+ idlist + "|%";
        String p2 = idlist + "|%";
        String p3 = "%|" + idlist;
        String p4 = idlist;
        query.setParameter("p1", p1);
        query.setParameter("p2", p2);
        query.setParameter("p3", p3);
        query.setParameter("p4", p4);
        return query.getResultList();
    }
    
    public Word update(Word word) {
        return em.merge(word);
    }

    public void persist(Object word) {
        em.persist(word);
    }
}
