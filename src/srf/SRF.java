/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srf;

/**
 *
 * @author JiJi
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
public class SRF {
    /**
     * @param args the command line arguments
     */
    public static ArrayList errors = new ArrayList();
    public static SRFMainWindow mw = new SRFMainWindow();
    
    public static void main(String[] args) {
        System.out.println("Stupid Reddit Formatter");
        mw.setTitle("Stupid Reddit Formatter");
        mw.setVisible(true);
    }
    
    public static String getText(String filename, ArrayList inputStrings, boolean mode) throws Exception{
        String payload = "";
        String output = "";
        
        //vars for reading the file
        Boolean strict = mode;
        BufferedReader br = new BufferedReader(new FileReader(filename));
        
        //reading the file and storing in an array
        String defaultWords = br.readLine();
        //init default words array and overflow
        ArrayList<String> defaultWordArray = new ArrayList(Arrays.asList(defaultWords.split(";")));
        String overflow = defaultWordArray.get(defaultWordArray.size() - 1);
        defaultWordArray.remove(defaultWordArray.size() - 1);//removes overflow from the default words list
        int maxWords = defaultWordArray.size();
        //stores the rest in payload
        String line;
        while ((line = br.readLine()) != null){
            if(line.contains("$C")){
                String comment = line;
                mw.commentLabel.setText(comment.replace("$C",""));
            } else{
                payload += line + "\n";
            }
        }
        
        if(strict){
            System.out.println("Strict Mode");
            output = payloadRender(payload.replace("$Overflow",""), defaultWordArray);
        } else if(inputStrings.size() >= maxWords){
            System.out.println("Overflow mode: "+(inputStrings.size() - maxWords));
            String overflowInsert = "";
            for(int overflowWord = inputStrings.size() - maxWords; overflowWord > 0; overflowWord--){
                overflowInsert += overflowInsert + overflow;
                overflowInsert = overflowInsert.replace("$Overflow", "$W{"+(inputStrings.size() - overflowWord)+"}");
            }
            output = payloadRender(payload.replace("$Overflow",overflowInsert), inputStrings);
        } else{
            System.out.println("Underflow mode");
            String underflow = payload.replace("$Overflow", "");
            for(int u = maxWords - inputStrings.size(); u > 0; u--){
                underflow = underflow.replace("$W{"+(maxWords-u)+"}", "");
            }
            output = payloadRender(underflow, inputStrings);
        }
        
        return output;
    }
    
    public static String payloadRender(String payload, ArrayList<String> words){
            try{
                for(int currentWord = 0; currentWord < words.size(); currentWord++){
                    payload = payload.replace("$W{"+currentWord+"}", words.get(currentWord));
                }
            }
            catch(ArrayIndexOutOfBoundsException e){
                errors.add("Word count does not match formatted count");
                e.printStackTrace();
            }
        return payload;
    }
}
