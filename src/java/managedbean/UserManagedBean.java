/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import entities.Users;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import services.session.UserManager;

/**
 *
 * @author User
 */
@Named(value = "userManagedBean")
@SessionScoped
public class UserManagedBean implements Serializable {

    private List<Users> user;
    private Users loggeduser;
    private String login;
    private String password;

    /**
     * Creates a new instance of UserManagedBean
     */
    @EJB
    private UserManager usermanager;

    public UserManagedBean() {
    }

    public Users connectuser() {
        System.out.println("login: " + getLogin());
        System.out.println("password: " + getPassword());
        user = usermanager.connect(login, password);
        if (user.size() == 0) {
            return null;
        } else if (user.size() > 1) {
            return null;
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext externalcontext = context.getExternalContext();
            Map usersessionmap = externalcontext.getSessionMap();
            usersessionmap.put("userManagedBean", this);
            setLoggeduser(user.get(0));
            System.out.println("created: " + user.get(0).getCreationdate());
            return user.get(0);
        }

    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the loggeduser
     */
    public Users getLoggeduser() {
        return loggeduser;
    }

    /**
     * @param loggeduser the loggeduser to set
     */
    public void setLoggeduser(Users loggeduser) {
        this.loggeduser = loggeduser;
    }

}
