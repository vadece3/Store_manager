/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abu_store_management;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author KAMDEM VADECE
 */
public class HomeFXMLController implements Initializable {

    @FXML
    private Button add_new_product;
    @FXML
    private Button remove_product;
    @FXML
    private Button add_daily_sales;
    @FXML
    private Button view_product_details;
    @FXML
    private Button view_financial_details;
    @FXML
    private Button calculate_sum_per_day;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void add_new_product_function(ActionEvent event) throws IOException {
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("login_form_addproductFXML.fxml"));
        Parent homepage = loader.load();
        
        Scene homepagescene = new Scene(homepage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homepagescene);
        stage.setTitle("LOGIN FORM");
        stage.show(); 
        
    }

    @FXML
    private void remove_product_function(ActionEvent event) throws IOException {
        
      FXMLLoader loader = new FXMLLoader(getClass().getResource("login_form_removeproductFXML.fxml"));
        Parent homepage = loader.load();
        
        Scene homepagescene = new Scene(homepage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homepagescene);
        stage.setTitle("REMOVE PRODUCT");
        stage.show();    
        
    }

    @FXML
    private void btnadd_daily_sales(ActionEvent event) throws IOException {
        
       FXMLLoader loader = new FXMLLoader(getClass().getResource("add_daily_salesFXML.fxml"));
        Parent homepage = loader.load();
        
        Scene homepagescene = new Scene(homepage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homepagescene);
        stage.setTitle("ADD DAILY SALES");
        stage.show();    
        
    }

    @FXML
    private void btnview_product_details(ActionEvent event) throws IOException {
        
      FXMLLoader loader = new FXMLLoader(getClass().getResource("view_product_detailsFXML.fxml"));
        Parent homepage = loader.load();
        
        Scene homepagescene = new Scene(homepage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homepagescene);
        stage.setTitle("PRODUCT DETAILS");
        stage.show();      
        
    }

    @FXML
    private void btnview_financial_details(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("view_financial_detailsFXML.fxml"));
        Parent homepage = loader.load();
        
        Scene homepagescene = new Scene(homepage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homepagescene);
        stage.setTitle("FINANCIAL DETAILS");
        stage.show(); 
        
        
    }

    @FXML
    private void btncalculation_sum_per_day(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("calculate_sum_per_dayFXML.fxml"));
        Parent homepage = loader.load();
        
        Scene homepagescene = new Scene(homepage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homepagescene);
        stage.setTitle("TOTAL SUM PER DAY");
        stage.show(); 
    }
    
}
