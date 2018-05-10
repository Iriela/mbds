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
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import services.session.HistoricManager;
import services.session.TestManager;
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
    
    private int size;
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
    
    @EJB
    private TestManager testManager;
    
    public void submit(boolean isFR){
        Integer userScore = TestHelper.CalculateScore(userInput,isFR ? Constants._FR : Constants._EN, testHistoric,size-1);
        //System.out.println("score "+userScore);
        
        this.setScore(userScore);
        long l = testManager.getMaxIndexTestResult();
        //System.out.print("L value >>>"+l);
        Testresult testresult = new Testresult(l);
        testresult.setIdtest(new Test(new Integer(idtest).longValue()));
        testresult.setIduser(new Users(1l));
        testresult.setScore(new Short(userScore.toString()));
        testresult.setCreationdate(new Date());
        testresult.setModificationdate(new Date());
        historyManager.addUserTestResult(testresult);
        this.userInput = new String[size];
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

    public String getFormattedString(){
        return "Your score is : " + score+"/20";
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
        this.size = wordList.size();
        this.userInput = new String[this.size];
        this.isFR_EN = isFREN;
    }
}
