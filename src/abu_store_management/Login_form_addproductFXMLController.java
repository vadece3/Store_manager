/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abu_store_management;

import dataaccesslayer.DataAccessLayer;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author KAMDEM VADECE
 */
public class Login_form_addproductFXMLController implements Initializable {

    @FXML
    private TextField user;
    @FXML
    private TextField password;
    @FXML
    private Button login;
    @FXML
    private Label notif;
    @FXML
    private Button home;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnlogin(ActionEvent event) throws SQLException, IOException {
        
        if(user.getText().equals("")){
         notif.setText("PLEASE ENTER USER NAME");
         }else{ if(password.getText().equals("")){
         notif.setText("PLEASE ENTER PASSWORD");
         }else{
         
          DataAccessLayer dal = new DataAccessLayer();
            ResultSet rs = dal.dbgetuserlogin();
            while(rs.next()){
              
                String a = rs.getString("username");
                String b = rs.getString("password");
                String username= user.getText();
                String pass= password.getText();
                if(!a.equals(username) & !b.equals(pass)){
                
                notif.setText("INCORRECT USERNAME OR PASSWORD");    
                    
                }else{
                        
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("add_new_product_functionFXML.fxml"));
                        Parent homepage = loader.load();

                        Scene homepagescene = new Scene(homepage);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(homepagescene);
                        stage.setTitle("ADD NEW PRODUCT");
                        stage.show(); 
          
                        
                        }
                 
            }
         
         }
        
        }
        
        
    }

    @FXML
    private void btnhome(ActionEvent event) throws IOException {
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("homeFXML.fxml"));
        Parent homepage = loader.load();
        
        Scene homepagescene = new Scene(homepage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homepagescene);
        stage.setTitle("HOME");
        stage.show();     
    }
    
}
