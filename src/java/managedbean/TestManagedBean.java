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
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import services.session.ListManager;

/**
 *
 * @author iriel
 */
@Named(value = "testManagedBean")
@ViewScoped
public class TestManagedBean implements Serializable{

    private List<Test> listTestByUser;
    private List<entities.List> list;
    
    @EJB
    private ListManager listManager;
    /**
     * Creates a new instance of TestManagedBean
     */
    public TestManagedBean() {
    }
    
    public List<Test> getListTestByUser(){
        if(listTestByUser == null){
            return listManager.getUserTests(1);
        }
        return listTestByUser;
    }
    
    public List<entities.List> getListList(){
        return listManager.getUserList(1);
    }
}
