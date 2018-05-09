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
    
    public boolean getTableEmpty() {
        List<Word> listWord = wordManager.getWords();
        return listWord.isEmpty();
    }
    
    public void insertDB() {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        
        String[] wordsFR = new String[50];
        wordsFR[0] = "un patron";
        wordsFR[1] = "classe";
        wordsFR[2] = "un cours";
        wordsFR[3] = "un diplome";
        wordsFR[4] = "sec";
        wordsFR[5] = "un effort";
        wordsFR[6] = "egal";
        wordsFR[7] = "une usine";
        wordsFR[8] = "les devoirs";
        wordsFR[9] = "le drirecteur";
        wordsFR[10] = "un muscle";
        wordsFR[11] = "un emploi du temps";
        wordsFR[12] = "un savant";
        wordsFR[13] = "une competence";
        wordsFR[14] = "un agrafeuse";
        wordsFR[15] = "une equipe";
        wordsFR[16] = "un outil";
        wordsFR[17] = "le travail";
        wordsFR[18] = "le lieu de travail";
        wordsFR[19] = "des hors-d'oeuvre";
        wordsFR[20] = "une pomme";
        wordsFR[21] = "une banane";
        wordsFR[22] = "un bar";
        wordsFR[23] = "un haricot";
        wordsFR[24] = "un boeuf";
        wordsFR[25] = "une biere";
        wordsFR[26] = "un billet";
        wordsFR[27] = "u bouteille";
        wordsFR[28] = "un bol";
        wordsFR[29] = "une action";
        wordsFR[30] = "un acteur";
        wordsFR[31] = "l'art";
        wordsFR[32] = "un chaine";
        wordsFR[33] = "la foule";
        wordsFR[34] = "celebre";
        wordsFR[35] = "un jeu";
        wordsFR[36] = "le golf";
        wordsFR[37] = "une promenade";
        wordsFR[38] = "plus fort";
        wordsFR[39] = "l'air";
        wordsFR[40] = "apparaitre";
        wordsFR[41] = "nuageux";
        wordsFR[42] = "froid";
        wordsFR[43] = "sombre";
        wordsFR[44] = "tomber";
        wordsFR[45] = "le brouillard";
        wordsFR[46] = "gris";
        wordsFR[47] = "la chaleur";
        wordsFR[48] = "chaud";
        wordsFR[49] = "la glace";
        
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
            Word word = new Word(i,wordsFR[i.intValue()],wordsEN[i.intValue()],"1",1L,date,date);
            wordManager.update(word);
        }
        
    }
    
    public void dropInit() {
       wordManager.deleteAllWords();
       insertDB(); 
    }
    
    public void init() {
        wordManager.deleteAllWords();
        insertDB();
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
