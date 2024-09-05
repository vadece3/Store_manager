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
public class TextTextField extends TextField {
    public TextTextField(){
    this.setPromptText("Enter Only Letters");
    }
    
    @Override
    public void replaceText(int i , int il , String string){
    if(string.matches("[a-zA-Z]")|| string.isEmpty()){
     super.replaceText(i,il, string);
    }
    }
    
    @Override
    public void replaceSelection(String string){
    super.replaceSelection(string);//To change body of generated methods, choose Tools | Templates
    }
        
    
}
