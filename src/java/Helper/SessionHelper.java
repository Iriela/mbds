/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import entities.Users;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import managedbean.UserManagedBean;

/**
 *
 * @author User
 */
public class SessionHelper {

    private UserManagedBean userManagedBean;

    public SessionHelper() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext externalcontext = context.getExternalContext();
            Map usersessionmap = externalcontext.getSessionMap();
            userManagedBean = (UserManagedBean) usersessionmap.get("userManagedBean");
        } catch (Exception exc) {

        }
    }

    public static Users getCurrentUser(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext externalcontext = context.getExternalContext();
            Map usersessionmap = externalcontext.getSessionMap();
            UserManagedBean userManagedBean = (UserManagedBean) usersessionmap.get("userManagedBean");
            return userManagedBean.getLoggeduser();
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    /**
     * @return the userManagedBean
     */
    public UserManagedBean getUserManagedBean() {
        return userManagedBean;
    }

    /**
     * @param userManagedBean the userManagedBean to set
     */
    public void setUserManagedBean(UserManagedBean userManagedBean) {
        this.userManagedBean = userManagedBean;
    }
}
