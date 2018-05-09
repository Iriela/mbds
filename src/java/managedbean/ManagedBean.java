/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import Helper.SessionHelper;
import entities.Word;
import services.session.WordManager;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

    @EJB
    private WordManager wordManager;

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
    
    public void initBdd(){
        System.out.println("INITIALISATION");
        
        Word word1;
        long id=1;
        long idUser=1;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        word1 = new Word(id,"Ballon","Ball",idUser,date,date);
        
        List<Word> listWord = wordManager.getWords();
        if(listWord.isEmpty()) {
            System.out.println("WORD TABLE IS EMPTY");
            //wordManager.update(word1);
        }
        else {
            System.out.println("WORD IS NOT EMPTY");
            //wordManager.deleteAllWords();
            //wordManager.update(word1);
        }
        
        
    }
    
    public boolean getTableEmpty() {
        List<Word> listWord = wordManager.getWords();
        return listWord.isEmpty();
    }
    
    public void dropInit() {
        
        System.out.println("INITIALISATION");
        
        Word word1;
        long id=1;
        long idUser=1;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        word1 = new Word(id,"Ballon","Ball",idUser,date,date);
        
        wordManager.deleteAllWords();
        wordManager.update(word1);
        
    }
    
    public void init() {
        
        System.out.println("INITIALISATION");
        
        Word word1;
        long id=1;
        long idUser=1;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        word1 = new Word(id,"Ballon","Ball",idUser,date,date);
        
        wordManager.update(word1);
        
    }
    
    
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
