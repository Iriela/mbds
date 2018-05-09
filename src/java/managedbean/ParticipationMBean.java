/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import Helper.Constants;
import Helper.TestHelper;
import entities.Test;
import entities.Testresult;
import entities.Users;
import entities.Word;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import services.session.HistoricManager;
import services.session.WordManager;

/**
 *
 * @author iriel
 */
@Named(value = "participationMBean")
@ViewScoped
public class ParticipationMBean implements Serializable{
    
    public ParticipationMBean() {
    }
    
    private boolean showCorrection;
    private boolean isFR_EN;
    private int idtest;
    private DataModel<Word> testHistoric; 
    private String[] userInput;    
    private int score;
    
    @EJB
    private WordManager wordManager;
    
    @EJB
    private HistoricManager historyManager;
    
    public void submit(boolean isFREN){
        int userScore = TestHelper.CalculateScore(userInput,isFREN ? Constants._FR : Constants._EN, testHistoric);
        this.setScore(userScore);
        /*Testresult testresult = new Testresult();
        testresult.setIdtest(new Test(new Integer(idtest).longValue()));
        testresult.setIduser(new Users(1l));
        historyManager.addUserTestResult(testresult);*/
    }
    
    public int getIdTest() {  
      return this.idtest;
    }  
          
    public void setIdTest(int idtest) {  
      this.idtest = idtest;
    }
    
    public void changeShowStatus(){
        showCorrection = !showCorrection;
    }
    
    public boolean getShowCorrection(){
        return showCorrection;
    }
    
    public DataModel<Word> getWordList(){
        return testHistoric;
    }

    public String[] getUserInput() {
        return userInput;
    }

    public void setUserInput(String[] userInput) {
        this.userInput = userInput;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
    
    public void loadWords(boolean isFREN) {
        List<Word> wordList = wordManager.getWords(String.valueOf(idtest));
        Word[] array = wordList.toArray(new Word[wordList.size()]);
        this.testHistoric = new ArrayDataModel<>(array);
        this.userInput = new String[wordList.size()];
        this.isFR_EN = isFREN;
    }
}
