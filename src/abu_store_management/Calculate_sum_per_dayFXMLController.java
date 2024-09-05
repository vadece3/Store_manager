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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author KAMDEM VADECE
 */
public class Calculate_sum_per_dayFXMLController implements Initializable {

    @FXML
    private TableView<table_financial_details> table_product_financial_details;
    @FXML
    private TableColumn<table_financial_details, String> product_id;
    @FXML
    private TableColumn<table_financial_details, String> product_name;
    @FXML
    private TableColumn<table_financial_details, String> price_per_product;
    @FXML
    private TableColumn<table_financial_details, String> entry_date;
    @FXML
    private TableColumn<table_financial_details, String> entry_quantity;
    @FXML
    private TableColumn<table_financial_details, String> sold_date;
    @FXML
    private TableColumn<table_financial_details, String> sold_quantity;
    @FXML
    private TableColumn<table_financial_details, String> sold_price;
    @FXML
    private TableColumn<table_financial_details, String> remaining_quantity;
    @FXML
    private Button home;
    ObservableList<table_financial_details> fpdlist = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> select_date;
    @FXML
    private Button calculate_total_amount;
    @FXML
    private Label total_amount;
  
    ObservableList<String> date_listt = FXCollections.observableArrayList();
    private AutoCompletionBinding<String> autocompletebonding;
    Collections collections;
    static int totalnumber;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         select_date.setEditable(true); 
        try {
            // TODO
                
                DataAccessLayer dal = new DataAccessLayer();
                ResultSet rss = dal.dbreadfinancialproductdetails();
                while(rss.next()){
                    
                    String a = rss.getString("product_id");
                    String aa = rss.getString("product_name");
                    String b = rss.getString("entry_date");
                    String c = rss.getString("sold_quantity");
                    String d = rss.getString("sold_price");
                    String ee = rss.getString("sold_date");
                    String cc = rss.getString("price_per_product");
                    String dd = rss.getString("entry_quantity");
                    String eee = rss.getString("remaining_quantity");
                    
                    
                    fpdlist.add(new table_financial_details(a,aa,b,c,d,ee,cc,dd,eee));
                    
                }
                table_product_financial_details.setItems(fpdlist);
                product_id.setCellValueFactory(new PropertyValueFactory<>("product_id"));
                product_name.setCellValueFactory(new PropertyValueFactory<>("product_name"));
                entry_date.setCellValueFactory(new PropertyValueFactory<>("entry_date"));
                sold_quantity.setCellValueFactory(new PropertyValueFactory<>("sold_quantity"));
                sold_price.setCellValueFactory(new PropertyValueFactory<>("sold_price"));
                sold_date.setCellValueFactory(new PropertyValueFactory<>("sold_date"));
                price_per_product.setCellValueFactory(new PropertyValueFactory<>("price_per_product"));
                entry_quantity.setCellValueFactory(new PropertyValueFactory<>("entry_quantity"));
                remaining_quantity.setCellValueFactory(new PropertyValueFactory<>("remaining_quantity"));
         
            
    //load date into combobox
            ResultSet rs = dal.dbreadsolddatenotime();
            while(rs.next()){
              
                String a = rs.getString("sold_datenotime");
                
                
                date_listt.add(a);
                
            }
            collections.sort(date_listt);
            //sujestions = new HashSet<>(slist);
            TextFields.bindAutoCompletion(select_date.getEditor(), date_listt).setOnAutoCompleted(e -> {
                
            });
            
            select_date.setItems(date_listt);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Calculate_sum_per_dayFXMLController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void btnselect_date(ActionEvent event) {
        
        table_product_financial_details.getItems().clear();
        
          try {
            // TODO
                
                String solddate = select_date.getValue();
                DataAccessLayer dal = new DataAccessLayer();
                ResultSet rss = dal.dbreadfinancialproductdetailsnotime(solddate);
                while(rss.next()){
                    
                    String a = rss.getString("product_id");
                    String aa = rss.getString("product_name");
                    String b = rss.getString("entry_date");
                    String c = rss.getString("sold_quantity");
                    String d = rss.getString("sold_price");
                    String ee = rss.getString("sold_date");
                    String cc = rss.getString("price_per_product");
                    String dd = rss.getString("entry_quantity");
                    String eee = rss.getString("remaining_quantity");
                    
                    
                    fpdlist.add(new table_financial_details(a,aa,b,c,d,ee,cc,dd,eee));
                    
                }
                table_product_financial_details.setItems(fpdlist);
                product_id.setCellValueFactory(new PropertyValueFactory<>("product_id"));
                product_name.setCellValueFactory(new PropertyValueFactory<>("product_name"));
                entry_date.setCellValueFactory(new PropertyValueFactory<>("entry_date"));
                sold_quantity.setCellValueFactory(new PropertyValueFactory<>("sold_quantity"));
                sold_price.setCellValueFactory(new PropertyValueFactory<>("sold_price"));
                sold_date.setCellValueFactory(new PropertyValueFactory<>("sold_date"));
                price_per_product.setCellValueFactory(new PropertyValueFactory<>("price_per_product"));
                entry_quantity.setCellValueFactory(new PropertyValueFactory<>("entry_quantity"));
                remaining_quantity.setCellValueFactory(new PropertyValueFactory<>("remaining_quantity"));
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Calculate_sum_per_dayFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
                      
        
        
    }

    @FXML
    private void btncalculate_total_amount(ActionEvent event) throws SQLException {
            
        totalnumber = 0;  
   if(select_date.getValue()==null){
      
       DataAccessLayer dal = new DataAccessLayer();
                ResultSet rss = dal.dbreadallsold_price();
                while(rss.next()){
                    
                    String a = rss.getString("sold_price");
                    
             int number_a =  Integer.parseInt (a);
             totalnumber = totalnumber+number_a ;
             
                } 
                
             String result_totalnumber = String.valueOf(totalnumber);
             total_amount.setText(result_totalnumber+" FCFA");
         
   
   }else{
       String solddate = select_date.getValue();
       DataAccessLayer dal = new DataAccessLayer();
                ResultSet rss = dal.dbreaduniquesold_price(solddate);
                while(rss.next()){
                    
                    String a = rss.getString("sold_price");
               int number_a =  Integer.parseInt (a);
             totalnumber = totalnumber+number_a ;
             
                } 
                
             String result_totalnumber = String.valueOf(totalnumber);
             total_amount.setText(result_totalnumber+" FCFA");
       
   }
        
    }
    
}
