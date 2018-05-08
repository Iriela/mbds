/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entities.Word;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
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
    
    private int idtest;
    private List<Word> testHistoric; 
    
    @EJB
    private TestManager testManager;
    
    @EJB
    private WordManager wordManager;
    
    public int getIdTest() {  
      return this.idtest;
    }  
          
    public void setIdTest(int idtest) {  
      this.idtest = idtest;
    }
    
    public List<Word> getWordList(){
        return testHistoric;
    }
    
    public void loadWords() {  
        this.testHistoric = wordManager.getWords(String.valueOf(idtest));  
    }
}
