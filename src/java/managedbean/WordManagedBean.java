/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import Helper.SessionHelper;
import entities.Word;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import javax.ejb.EJB;
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.Part;
import services.session.WordManager;

/**
 *
 * @author User
 */
@Named(value = "wordManagedBean")
@ViewScoped
public class WordManagedBean implements Serializable {

    private List<Word> listword;
    private Part fileuploaded;
    private Scanner fileContent;
    private String idinsert;
    private SessionHelper sessionhelper=new SessionHelper();

    @EJB
    private WordManager wordmanager;

    public WordManagedBean() {
        
    }

    public List<Word> getListWord() {
        if (listword == null) {
            return wordmanager.getWords();
        }
        return listword;
    }
    
    public Word insertnewWord(){
        System.out.println("created: "+sessionhelper.getUserManagedBean().getLoggeduser().getCreationdate());
        Word newword = new Word(1l);
        newword.setCreationdate(new Date());
        newword.setFrench("language");
        newword.setEnglish("langage");
        newword.setIduser(1);
        newword.setKeyword("key");
        newword.setListid("1");
        newword.setModificationdate(new Date());
        //return wordmanager.update(newword);
        return null;
    }

    public void insertWord() {
        Word newword = new Word(1l);
        newword.setCreationdate(new Date());
        newword.setFrench("language");
        newword.setEnglish("langage");
        newword.setIduser(1);
        newword.setKeyword("key");
        newword.setListid("1");
        newword.setModificationdate(new Date());
        wordmanager.update(newword);
    }

    public void upload() {
        try {
            fileContent = new Scanner(fileuploaded.getInputStream());
            while (fileContent.hasNextLine()) {
                String line = fileContent.nextLine();
                String[] splitLine=line.split(",");
                Word newword = new Word(Long.parseLong(splitLine[0]));
                newword.setCreationdate(new Date());
                newword.setFrench(splitLine[1]);
                newword.setEnglish(splitLine[2]);
                newword.setIduser(Integer.parseInt(splitLine[3]));
                newword.setListid(splitLine[4]);
                newword.setKeyword(splitLine[5]);
                newword.setModificationdate(new Date());
                wordmanager.update(newword);
                System.out.println(line);
            }
            /*Path folder = Paths.get("C:\\Users\\User\\Documents\\Tsito");
            String filename = fileuploaded.toString().split(",")[0].split("=")[1].toString().split("\\.")[0];
            String extension = fileuploaded.toString().split(",")[0].split("=")[1].toString().split("\\.")[1];
            Path filepath = Files.createTempFile(folder, filename + "-", "." + extension);
            InputStream input = fileuploaded.getInputStream();
            Files.copy(input, filepath, StandardCopyOption.REPLACE_EXISTING);*/

        } catch (IOException e) {

        }
    }

    public Part getFileuploaded() {
        return fileuploaded;
    }

    public void setFileuploaded(Part fileuploaded) {
        this.fileuploaded = fileuploaded;
    }

    /**
     * @return the idinsert
     */
    public String getIdinsert() {
        return idinsert;
    }

    /**
     * @param idinsert the idinsert to set
     */
    public void setIdinsert(String idinsert) {
        this.idinsert = idinsert;
    }
}
