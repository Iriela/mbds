/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import entities.Word;
import javax.faces.model.DataModel;

/**
 *
 * @author iriel
 */
public class TestHelper {
    public static int CalculateScore(String[] userInput, String lang, DataModel<Word> words){
        int score = 0;
        int i=0;
        for(Word word : words){
            System.out.println("FR: "+word.getFrench()+" EN:"+userInput[i]);
            if(lang.equalsIgnoreCase(Constants._EN)){
                if(!word.getFrench().equalsIgnoreCase(userInput[i])) continue;
                score++;
            }
            else if(lang.equalsIgnoreCase(Constants._FR)){
                if(!word.getEnglish().equalsIgnoreCase(userInput[i])) continue;
                score++;
            }
            i++;
        }
        return score;
    }
}
