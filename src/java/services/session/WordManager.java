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
    
    public Word update(Word word) {
        return em.merge(word);
    }

    public void persist(Object word) {
        em.persist(word);
    }
}
