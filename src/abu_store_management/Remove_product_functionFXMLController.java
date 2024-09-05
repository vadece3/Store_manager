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
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author KAMDEM VADECE
 */
public class Remove_product_functionFXMLController implements Initializable {

    @FXML
    private ComboBox<String> combo_date;
    @FXML
    private ComboBox<String> combo_product_name;
    @FXML
    private Button home;
    @FXML
    private Button delete;
    @FXML
    private Button delete_plus_home;
    @FXML
    private Label bad_alert;
    @FXML
    private Label good_alert;
    ObservableList<String> product_list = FXCollections.observableArrayList();
    ObservableList<String> date_listt = FXCollections.observableArrayList();
    private AutoCompletionBinding<String> autocompletebonding;
    Collections collections;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
          combo_date.setEditable(true); 
          combo_product_name.setEditable(true);
        try {
            // TODO
            DataAccessLayer dal = new DataAccessLayer();
            ResultSet rs = dal.dbreadentrydate();
            while(rs.next()){
              
                String a = rs.getString("date_of_entry");
                
                
                date_listt.add(a);
                
            }
            collections.sort(date_listt);
            //sujestions = new HashSet<>(slist);
            TextFields.bindAutoCompletion(combo_date.getEditor(), date_listt).setOnAutoCompleted(e -> {
            
             });
           
            combo_date.setItems(date_listt);
               
        } catch (SQLException ex) {
           
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
    private void btndelete(ActionEvent event) throws SQLException {
        bad_alert.setText("");
        good_alert.setText("");
     
         if(combo_date.getValue()==null){
         bad_alert.setText("PLEASE SELECT DATE");
         }else{ if(combo_product_name.getValue()==null){
         bad_alert.setText("PLEASE SELECT PRODUCT");
         }else{
             String pd=combo_date.getValue().toString();
             String pn=combo_product_name.getValue().toString();
         DataAccessLayer dal = new DataAccessLayer();
         dal.dbdeleteproduct(pn,pd);
             bad_alert.setText("");
             good_alert.setText("DELETED SECCESSFULLY");
             
             
            combo_date.setItems(null);
            combo_product_name.setItems(null);
            date_listt.clear();
            product_list.clear();
            ResultSet rs = dal.dbreadentrydate();
            while(rs.next()){
              
                String a = rs.getString("date_of_entry");
                
                
                date_listt.add(a);
                
            }
            collections.sort(date_listt);
            //sujestions = new HashSet<>(slist);
            TextFields.bindAutoCompletion(combo_date.getEditor(), date_listt).setOnAutoCompleted(e -> {
            
             });
           
            combo_date.setItems(date_listt);
               
            
         }
         
         }
        
        
    }

    @FXML
    private void btndelete_plus_home(ActionEvent event) throws IOException, SQLException {
        
        bad_alert.setText("");
        good_alert.setText("");
        
         if(combo_date.getValue()==null){
         bad_alert.setText("PLEASE SELECT DATE");
         }else{ if(combo_product_name.getValue()==null){
         bad_alert.setText("PLEASE SELECT PRODUCT");
         }else{
             String pd=combo_date.getValue().toString();
             String pn=combo_product_name.getValue().toString();
         DataAccessLayer dal = new DataAccessLayer();
         dal.dbdeleteproduct(pn,pd);
            
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

 
    @FXML
    private void btncombo_date(ActionEvent event) throws SQLException {
       
          product_list.clear();
        if(combo_date.getValue()!=null){
            String sn = combo_date.getValue();
        
         DataAccessLayer dal = new DataAccessLayer();
         ResultSet rs = dal.dbreadproduct_name(sn);
         while(rs.next()){
              
                String a = rs.getString("product_name");
                
                
                product_list.add(a);
                
            }
            collections.sort(product_list);
            
            TextFields.bindAutoCompletion(combo_product_name.getEditor(), product_list).setOnAutoCompleted(e -> {
                
            });
            
            combo_product_name.setItems(product_list); 
            }
        
        
        
    }
    
}
