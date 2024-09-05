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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author KAMDEM VADECE
 */
public class Add_daily_salesFXMLController implements Initializable {

    @FXML
    private ComboBox<String> product_name;
    @FXML
    private TextField product_quantity;
    @FXML
    private TextField sold_price;
    @FXML
    private Button save;
    @FXML
    private Button save_plus_home;
    @FXML
    private Button home;
    @FXML
    private Label bad_notif;
    @FXML
    private Label good_notif;
    @FXML
    private ComboBox<String> entry_date;
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
        
        entry_date.setEditable(true); 
          product_name.setEditable(true);
        try {
            // TODO
            DataAccessLayer dal = new DataAccessLayer();
            ResultSet rs = dal.dbreadentrydatenotime();
            while(rs.next()){
              
                String a = rs.getString("date_of_entry_notime");
                
                
                date_listt.add(a);
                
            }
            collections.sort(date_listt);
            //sujestions = new HashSet<>(slist);
            TextFields.bindAutoCompletion(entry_date.getEditor(), date_listt).setOnAutoCompleted(e -> {
            
             });
           
            entry_date.setItems(date_listt);
               
        } catch (SQLException ex) {
           
        }
        
    }    


    @FXML
    private void btnsave(ActionEvent event) throws SQLException {
        
        bad_notif.setText("");
        good_notif.setText("");
     
         if(entry_date.getValue()==null){
         bad_notif.setText("PLEASE SELECT DATE OF ENTRY");
         }else{ if(product_name.getValue()==null){
         bad_notif.setText("PLEASE SELECT PRODUCT");
         }else{ if(product_quantity.getText().equals("")){
         bad_notif.setText("PLEASE ENTER SOLD QUANTITY");
         }else{ if(sold_price.getText().equals("")){
         bad_notif.setText("PLEASE ENTER SOLD AMOUNT");
         }else{
             String pd=entry_date.getValue().toString();
             String pn=product_name.getValue().toString();
             String pq=product_quantity.getText();
             String psp=sold_price.getText();
         DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         Date date = new Date();
             String psd = format.format(date); 
             String solddatenotime = format.format(date).substring(0, 10);
         DataAccessLayer dal = new DataAccessLayer();
         dal.dbaddsoldproduct(pn,pd,pq,psp,psd,solddatenotime);
             bad_notif.setText("");
             good_notif.setText("SOLD DETAIL ADDED");
             
             
            entry_date.setItems(null);
            product_name.setItems(null);
            //date_listt.clear();
            product_list.clear();
            product_quantity.clear();
            sold_price.clear();
            ResultSet rs = dal.dbreadentrydatenotime();
            while(rs.next()){
              
                String a = rs.getString("date_of_entry_notime");
                
                
                date_listt.add(a);
                
            }
            collections.sort(date_listt);
            //sujestions = new HashSet<>(slist);
            TextFields.bindAutoCompletion(entry_date.getEditor(), date_listt).setOnAutoCompleted(e -> {
            
             });
           
            entry_date.setItems(date_listt);
               
            
         }
         
         }
         }
         }
        
    }

    @FXML
    private void btnsave_plus_home(ActionEvent event) throws SQLException, IOException {
        
        bad_notif.setText("");
        good_notif.setText("");
     
         if(entry_date.getValue()==null){
         bad_notif.setText("PLEASE SELECT DATE");
         }else{ if(product_name.getValue()==null){
         bad_notif.setText("PLEASE SELECT PRODUCT");
         }else{ if(product_quantity.getText().equals("")){
         bad_notif.setText("PLEASE ENTER SOLD QUANTITY");
         }else{ if(sold_price.getText().equals("")){
         bad_notif.setText("PLEASE ENTER SOLD AMOUNT");
         }else{
             String pd=entry_date.getValue().toString();
             String pn=product_name.getValue().toString();
             String pq=product_quantity.getText();
             String psp=sold_price.getText();
         DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         Date date = new Date();
             String psd = format.format(date); 
             String solddatenotime = format.format(date).substring(0, 10);
         DataAccessLayer dal = new DataAccessLayer();
         dal.dbaddsoldproduct(pn,pd,pq,psp,psd,solddatenotime);
            
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
    private void btnentry_date(ActionEvent event) throws SQLException {
        product_list.clear();
         if(entry_date.getValue()!=null){
            String sn = entry_date.getValue();
        
         DataAccessLayer dal = new DataAccessLayer();
         ResultSet rs = dal.dbreadproduct_namenotime(sn);
         while(rs.next()){
              
                String a = rs.getString("product_name");
                
                
                product_list.add(a);
                
            }
            collections.sort(product_list);
            
            TextFields.bindAutoCompletion(product_name.getEditor(), product_list).setOnAutoCompleted(e -> {
                
            });
            
            product_name.setItems(product_list); 
            }
        
        
        
    }
    
        
    
}
