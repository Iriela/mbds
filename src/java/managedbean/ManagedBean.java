/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import Helper.SessionHelper;
import entities.Test;
import entities.Users;
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
import services.session.UserManager;

/**
 *
 * @author iriel
 */
@Named(value = "testManagedBean")
@ViewScoped
public class ManagedBean implements Serializable {

    @EJB
    private WordManager wordManager;

    private List<entities.List> list;
    private List<entities.Testresult> listTestHistoric;
    private List<entities.Test> listTest;
    private SessionHelper sessionhelper=new SessionHelper();
    
    @EJB
    private ListManager listManager;
    
    @EJB
    private UserManager userManager;
    
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
            return listManager.getUserList(sessionhelper.getUserManagedBean().getLoggeduser());
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
    
    public boolean getTableEmpty() {
        List<Word> listWord = wordManager.getWords();
        return listWord.isEmpty();
    }
    
    public void insertDB() {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        
        String[] wordsFR = new String[50];
        wordsFR[0] = "patron";
        wordsFR[1] = "classe";
        wordsFR[2] = "cours";
        wordsFR[3] = "sec";
        wordsFR[4] = "effort";
        wordsFR[5] = "egal";
        wordsFR[6] = "usine";
        wordsFR[7] = "devoirs";
        wordsFR[8] = "diplome";
        wordsFR[9] = "directeur";
        wordsFR[10] = "muscle";
        wordsFR[11] = "emploi du temps";
        wordsFR[12] = "savant";
        wordsFR[13] = "competence";
        wordsFR[14] = "agrafeuse";
        wordsFR[15] = "equipe";
        wordsFR[16] = "outil";
        wordsFR[17] = "travail";
        wordsFR[18] = "lieu de travail";
        wordsFR[19] = "des hors-d'oeuvre";
        wordsFR[20] = "pomme";
        wordsFR[21] = "banane";
        wordsFR[22] = "bar";
        wordsFR[23] = "haricot";
        wordsFR[24] = "boeuf";
        wordsFR[25] = "biere";
        wordsFR[26] = "billet";
        wordsFR[27] = "bouteille";
        wordsFR[28] = "bol";
        wordsFR[29] = "action";
        wordsFR[30] = "acteur";
        wordsFR[31] = "art";
        wordsFR[32] = "chaine";
        wordsFR[33] = "foule";
        wordsFR[34] = "celebre";
        wordsFR[35] = "jeu";
        wordsFR[36] = "golf";
        wordsFR[37] = "promenade";
        wordsFR[38] = "plus fort";
        wordsFR[39] = "air";
        wordsFR[40] = "apparaitre";
        wordsFR[41] = "nuageux";
        wordsFR[42] = "froid";
        wordsFR[43] = "sombre";
        wordsFR[44] = "tomber";
        wordsFR[45] = "brouillard";
        wordsFR[46] = "gris";
        wordsFR[47] = "chaleur";
        wordsFR[48] = "chaud";
        wordsFR[49] = "glace";
        
        String[] wordsEN = new String[50];
        wordsEN[0] = "boss";
        wordsEN[1] = "class";
        wordsEN[2] = "degree";
        wordsEN[3] = "dry";
        wordsEN[4] = "effort";
        wordsEN[5] = "equal";
        wordsEN[6] = "factory";
        wordsEN[7] = "homework";
        wordsEN[8] = "job";
        wordsEN[9] = "manager";
        wordsEN[10] = "muscle";
        wordsEN[11] = "schedule";
        wordsEN[12] = "scientist";
        wordsEN[13] = "skill";
        wordsEN[14] = "stapler";
        wordsEN[15] = "team";
        wordsEN[16] = "tool";
        wordsEN[17] = "work";
        wordsEN[18] = "workspace";
        wordsEN[19] = "appetizers";
        wordsEN[20] = "apple";
        wordsEN[21] = "banana";
        wordsEN[22] = "bar";
        wordsEN[23] = "bean";
        wordsEN[24] = "beef";
        wordsEN[25] = "beer";
        wordsEN[26] = "bill";
        wordsEN[27] = "bottle";
        wordsEN[28] = "bowl";
        wordsEN[29] = "action";
        wordsEN[30] = "actor";
        wordsEN[31] = "art";
        wordsEN[32] = "channel";
        wordsEN[33] = "crowd";
        wordsEN[34] = "famous";
        wordsEN[35] = "game";
        wordsEN[36] = "golf";
        wordsEN[37] = "hike";
        wordsEN[38] = "louder";
        wordsEN[39] = "air";
        wordsEN[40] = "appear";
        wordsEN[41] = "cloudy";
        wordsEN[42] = "cold";
        wordsEN[43] = "dark";
        wordsEN[44] = "fall";
        wordsEN[45] = "fog";
        wordsEN[46] = "gray";
        wordsEN[47] = "heat";
        wordsEN[48] = "hot";
        wordsEN[49] = "ice";
        
        for(Long i=0L;i<wordsEN.length;i++) {
            if(i.intValue()<=15) {
                Word word = new Word(i,wordsFR[i.intValue()],wordsEN[i.intValue()],"4|1",1L,date,date);
                wordManager.update(word);
            }
            else if(i.intValue()>15 && i.intValue()<=30) {
                Word word = new Word(i,wordsFR[i.intValue()],wordsEN[i.intValue()],"3|2",1L,date,date);
                wordManager.update(word);
            }
            else if(i.intValue()>30 && i.intValue()<=35) {
                Word word = new Word(i,wordsFR[i.intValue()],wordsEN[i.intValue()],"2|3",1L,date,date);
                wordManager.update(word);
            }
            else {
                Word word = new Word(i,wordsFR[i.intValue()],wordsEN[i.intValue()],"1|2",1L,date,date);
                wordManager.update(word);
            }
        }
        
        
        
        Users user1 = new Users(1L,false,"user","user",date,date);
        Users user2 = new Users(2L,true,"admin","admin",date,date);
        
        
        entities.List list1 = new entities.List(1L,"Travail","Ensemble des mots concernant le travail en generale",user1,date,date);
        entities.List list2 = new entities.List(2L,"Aliment","Ensemble des mots concernant les aliments ",user2,date,date);
        entities.List list3 = new entities.List(3L,"Sport","Ensemble des mots concernant le sport en generale",user2,date,date);
        entities.List list4 = new entities.List(4L,"Boulot","Ensemble des mots concernant le boulot",user1,date,date);
        
        Test test1 = new Test(1L,user1,list1,date,date);
        Test test2 = new Test(2L,user1,list1,date,date);
        Test test3 = new Test(3L,user2,list1,date,date);
        
        testManager.update(test1);
        testManager.update(test2);
        testManager.update(test3);
                
        
        userManager.update(user1);
        userManager.update(user2);
        
        listManager.update(list1);
        listManager.update(list2);
        listManager.update(list3);
        listManager.update(list4);
        
    }
    
    public void dropInit() {
       listManager.deleteAllList();
       wordManager.deleteAllWords();
       userManager.deleteAllUsers();
       testManager.deleteAllTest();
       insertDB(); 
    }
    
    public void init() {
        listManager.deleteAllList();
        wordManager.deleteAllWords();
        userManager.deleteAllUsers();
        testManager.deleteAllTest();
        insertDB();
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
