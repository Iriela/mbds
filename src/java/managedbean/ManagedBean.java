/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entities.Test;
import entities.Testhistoric;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import services.session.HistoricManager;
import services.session.ListManager;
import services.session.TestManager;

/**
 *
 * @author iriel
 */
@Named(value = "testManagedBean")
@ViewScoped
public class ManagedBean implements Serializable{

    private List<Test> listTestByUser;
    private List<entities.List> list;
    private List<entities.Testhistoric> listTestHistoric;
    
    @EJB
    private ListManager listManager;
    
    @EJB
    private TestManager testManager;
    
    @EJB
    private HistoricManager historicManager;
    
    /**
     * Creates a new instance of TestManagedBean
     */
    public ManagedBean() {
    }
    
    public List<entities.Test> getListTestByUser(){
        if(listTestByUser == null){
            return testManager.getUserTests(1);
        }
        return listTestByUser;
    }
    
    public List<entities.List> getListList(){
        if(list == null){
            return listManager.getUserList(1);
        }
        return list;
    }
    
    public List<entities.Testhistoric> getTestHistoric(){
        if(listTestHistoric == null){
            return historicManager.getUserTests(1);
        }
        return listTestHistoric;
    }
    
    public entities.Testhistoric getTestHistoric(int idTest){
        return historicManager.getUserTests(1,idTest);
    }
}
