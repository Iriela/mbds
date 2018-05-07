/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entities.List;  
import java.io.Serializable;  
import javax.ejb.EJB;  
import javax.faces.view.ViewScoped;  
import javax.inject.Named;
import services.session.ListManager;
import services.session.ListThemeManager; 

/**
 *
 * @author Kiady
 */
@Named(value = "detailListMbean")
@ViewScoped
public class DetailListMBean implements Serializable {  

    
  private int idList;  
  private entities.List list;  
          
  @EJB  
  private ListThemeManager listManager;  
          
  public int getIdList() {  
    return idList;  
  }  
          
  public void setIdList(int idList) {  
    this.idList = idList;  
  }  
          
  /** 
   * Renvoie les détails du client courant (celui dans l'attribut customer de 
   * cette classe), qu'on appelle une propriété (property) 
   */  
    public List getList() {  
      return list;
    }  
          
  /** 
   * Action handler - met à jour la base de données en fonction du client passé 
   * en paramètres, et renvoie vers la page qui affiche la liste des clients. 
   */  
  public String update() {  
    list = ListManager.update(list);
    return "List"; 
  }
          
  public void loadList() {  
    this.list = listManager.getList(idList);  
  }  
    
}
