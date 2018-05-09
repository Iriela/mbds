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
        try{
            Query query = em.createQuery(queryFor);
            List result = query.getResultList();
            System.out.println("result>>" + result);
            System.out.println("result.get(0)>>" + result.get(0));
            System.out.println("(long)result.get(0)>>" + (long)result.get(0));
            return (long)result.get(0);
        }
        catch(Exception ex){
            return 1L;
        }
    }
}
