/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entities.Test;
import entities.Users;
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

    private List<entities.Test> listTestByUser;
    private List<entities.List> list;
    private List<entities.Test> listTestHistoric;
    private List<entities.Test> listTest;
    
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
    
    // Used to get all test done by user
    public List<entities.Test> getListTestByUser(){
        if(listTestByUser == null){
            listTestByUser = testManager.getUserTests(new Users(1l));
        }
        return listTestByUser;
    }
    
    // Get all theme created by the user
    public List<entities.List> getTestThemeList(){
        if(list == null){
            list = listManager.getUserList(new Users(1l));
        }
        return list;
    }
    
    // Get all test done by the user
    public List<entities.Test> getUserTestsHistoric(){
        if(listTestHistoric == null){
            listTestHistoric = historicManager.getUserTests(new Users(1l));
        }
        return listTestHistoric;
    }
    
    public List<entities.Test> getTests(){
        if(listTest == null){
            listTest = testManager.getTests();
        }
        return listTest;
    }
}
