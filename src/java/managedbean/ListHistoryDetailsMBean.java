/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entities.Test;
import entities.Testresult;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import services.session.HistoricManager;

/**
 *
 * @author iriel
 */
@Named(value = "listHistoryDetailsMBean")
@ViewScoped
public class ListHistoryDetailsMBean implements Serializable{

    public ListHistoryDetailsMBean() {
    }
    
    private int idlist;  
    private List<Testresult> testHistoric;  
          
    @EJB
    private HistoricManager historicManager;
          
    public int getIdlist() {  
      return this.idlist;
    }  
          
    public void setIdlist(int idlist) {  
      this.idlist = idlist;
    }  
  
    public List<entities.Testresult> getTestHistoric() {  
      return this.testHistoric;
    }  
          
    public void loadTesthistoric() {  
        this.testHistoric = historicManager.getTestHistoric(new entities.List(new Integer(this.idlist).longValue()));  
    }  
}
