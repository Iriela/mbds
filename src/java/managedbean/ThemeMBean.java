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
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import services.session.ListManager;
import services.session.WordManager;

/**
 *
 * @author Kiady
 */
@Named(value = "themeMBean")
@ViewScoped
public class ThemeMBean implements Serializable{

    @EJB
    private ListManager listManager;
    
    @EJB
    private WordManager wordManager;
    
    
    private int idTheme;
    private List<Word> wordList; 
    
    /**
     * Creates a new instance of ThemeMBean
     */
    public ThemeMBean() {
    }
    
    
    public List<entities.List> getAllTheme(){
        System.out.println(">>><<<<<<>>>>>");
        return listManager.getAllList();
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }
    
    public void loadWords() {
        this.wordList =  wordManager.getWords(String.valueOf(idTheme));
    }
    
    
}
