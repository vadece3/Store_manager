/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abu_store_management;

import dataaccesslayer.DataAccessLayer;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class Add_new_product_functionFXMLController implements Initializable {

    @FXML
    private TextField product_name;
    @FXML
    private TextField price_per_product;
    @FXML
    private TextField product_quantity;
    @FXML
    private Button save;
    @FXML
    private Label alert;
    @FXML
    private Button home;
    @FXML
    private Button save_and_home;
    @FXML
    private Label good_notif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnsave(ActionEvent event) throws IOException, SQLException {
        
        alert.setText("");
        good_notif.setText("");
        
         if(product_name.getText().equals("")){
         alert.setText("PLEASE ENTER PRODUCT NAME");
         }else{ if(price_per_product.getText().equals("")){
             alert.setText("PLEASE ENTER PRICE PER PRODUCT");
         }else{ if(product_quantity.getText().equals("")){
             alert.setText("PLEASE ENTER PRODUCT QUANTITY");
         }else{
             
         DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         Date date = new Date();
         String solddate = format.format(date);
         String solddatenotime = format.format(date).substring(0, 10);;
         String pn=product_name.getText();
         String ppp=price_per_product.getText();
         String pq=product_quantity.getText();
        
         DataAccessLayer dal = new DataAccessLayer();
         dal.dbaddproduct(pn,ppp,pq,solddate,solddatenotime);
         
          alert.setText("");
         good_notif.setText("ADDED SUCCESSFULLY");
         product_name.clear();
         price_per_product.clear();
         product_quantity.clear();
        
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

    @FXML
    private void btnsave_and_home(ActionEvent event) throws SQLException, IOException {
        
        alert.setText("");
        good_notif.setText("");
        
         if(product_name.getText().equals("")){
         alert.setText("PLEASE ENTER PRODUCT NAME");
         }else{ if(price_per_product.getText().equals("")){
             alert.setText("PLEASE ENTER PRICE PER PRODUCT");
         }else{ if(product_quantity.getText().equals("")){
             alert.setText("PLEASE ENTER PRODUCT QUANTITY");
         }else{
             
         DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         Date date = new Date();
         String solddate = format.format(date); 
         String solddatenotime = format.format(date).substring(0, 10);
         String pn=product_name.getText();
         String ppp=price_per_product.getText();
         String pq=product_quantity.getText();
        
         DataAccessLayer dal = new DataAccessLayer();
         dal.dbaddproduct(pn,ppp,pq,solddate,solddatenotime);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("homeFXML.fxml"));
        Parent homepage = loader.load();
        
        Scene homepagescene = new Scene(homepage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homepagescene);
        stage.setTitle("HOME");
        stage.show(); 
         }
    }
    } 
        
        
    }
}
