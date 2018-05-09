/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import services.session.ListManager;

/**
 *
 * @author Kiady
 */
@Named(value = "themeMBean")
@ViewScoped
public class ThemeMBean implements Serializable{

    @EJB
    private ListManager listManager;
    
    /**
     * Creates a new instance of ThemeMBean
     */
    public ThemeMBean() {
    }
    
    
    public List<entities.List> getAllTheme(){
        System.out.println(">>><<<<<<>>>>>");
        return listManager.getAllList();
    }
}
