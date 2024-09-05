/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValidateTextfield.custom;

import javafx.scene.control.TextField;

/**
 *
 * @author ENOCK KOUNTCHOU
 */
public class NumberTextField extends TextField{
    
    public NumberTextField(){
    this.setPromptText("ENTRER SEULMENT DES NOMBRES");
    }
    
    @Override
    public void replaceText(int i , int il , String string){
    if(string.matches("[0-9]")|| string.isEmpty()){
     super.replaceText(i,il, string);
    }
    }
    
    @Override
    public void replaceSelection(String string){
    super.replaceSelection(string);//To change body of generated methods, choose Tools | Templates
    }
        
   
    
}
