/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import entities.Word;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iriel
 */
public class WordHelper {
    public static Word addToList(Word word, Long idList){
        String listId = word.getListid();
        if(listId == null || listId.isEmpty()){
            word.setListid(idList.toString());
            return word;
        }
        String[] list = listId.split("|");
        boolean alreadyInList = false;
        for(String item : list){
            if(item.contains(idList.toString())){
                alreadyInList = true;
                break;
            }
        }
        if(!alreadyInList){
            word.setListid(word.getListid()+"|"+idList);
        }
        return word;
    }
}