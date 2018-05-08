/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import Helper.SessionHelper;
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

    private List<entities.List> list;
    private List<entities.Testresult> listTestHistoric;
    private List<entities.Test> listTest;
    private SessionHelper sessionhelper=new SessionHelper();
    
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
        
    // Get all theme created by the user
    public List<entities.List> getTestThemeList(){
        try {
            if (list == null) {
                list = listManager.getUserList(sessionhelper.getUserManagedBean().getLoggeduser());
            }
            return list;
        } catch (Exception exc) {
        }
        return null;
    }
    
    // Get all test done by the user
    public List<entities.Testresult> getUserTestsHistoric(){
        try {
            return historicManager.getUserTests(sessionhelper.getUserManagedBean().getLoggeduser());
        } catch (Exception exc) {

        }
        return null;
    }
    
    public List<entities.Test> getTests(){
        if(listTest == null){
            listTest = testManager.getTests();
        }
        return listTest;
    }
}
