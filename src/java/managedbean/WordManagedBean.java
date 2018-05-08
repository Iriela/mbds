/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import Helper.SessionHelper;
import entities.Word;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.ejb.EJB;
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
    private int ismodifmode=0;
    private Word word;

    @EJB
    private WordManager wordmanager;

    public WordManagedBean() {
        
        
    }

    public List<Word> getListWord() {
        return wordmanager.getWords();
    }
    
    public void insert(){
        System.out.print("testinsert");
    }
    
    public void changemodifmode(int idmodif){
        //Long idlong=new Long(wordmodif.getIduser());
        this.setIsmodifmode(idmodif);
    }
    
    public void showmodif(String key, Word wordmodif){
        System.out.println("key: "+key);
        wordmodif.setKeyword(key);
        System.out.println("key: "+wordmodif.getEnglish());
        wordmanager.update(wordmodif);
    }
    
    public void modif(Word word){
        System.out.println("French: "+word.getFrench());
        System.out.println("English: "+word.getEnglish());
        System.out.println("Keywords: "+word.getKeyword());
    }
    
    public void updateWord(Long Idword, String French, String English, Long Listid, Long Iduser, Date Creationdate, Date Modificationdate, String Keyword){
        /*System.out.println("Idword: "+Idword);
        System.out.println("created: "+sessionhelper.getUserManagedBean().getLoggeduser().getCreationdate());
        Word newword = new Word(1l);
        newword.setCreationdate(new Date());
        newword.setFrench("language");
        newword.setEnglish("langage");
        newword.setIduser(1);
        newword.setKeyword("key");
        newword.setListid("1");
        newword.setModificationdate(new Date());*/
        //return wordmanager.update(newword);
    }

    public List<Word> getWordList(String idlist){
        return wordmanager.getWords(idlist);
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
        wordmanager.update(newword);*/
        return null;
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
                wordmanager.persist(newword);
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

    /**
     * @return the ismodifmode
     */
    public int getIsmodifmode() {
        return ismodifmode;
    }

    /**
     * @param ismodifmode the ismodifmode to set
     */
    public void setIsmodifmode(int ismodifmode) {
        this.ismodifmode = ismodifmode;
    }

    /**
     * @return the word
     */
    public Word getWord() {
        return word;
    }

    /**
     * @param word the word to set
     */
    public void setWord(Word word) {
        this.word = word;
    }
}
