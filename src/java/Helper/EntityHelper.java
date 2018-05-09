/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author iriel
 */
public class EntityHelper {
    public static long getMaxIndex(EntityManager  em, String queryFor){
        Query query = em.createQuery(queryFor);
        List result = query.getResultList();
        if(result.isEmpty()){
            return 1L;
        }
        return (long)result.get(0);
    }
}
