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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author KAMDEM VADECE
 */
public class View_product_detailsFXMLController implements Initializable {

    @FXML
    private TableView<table_product_details> table_view_details;
    @FXML
    private TableColumn<table_product_details, String> product_id;
    @FXML
    private TableColumn<table_product_details, String> product_name;
    @FXML
    private TableColumn<table_product_details, String> entry_date;
    @FXML
    private TableColumn<table_product_details, String> entry_quantity;
    @FXML
    private TableColumn<table_product_details, String> remaining_quantity;
    @FXML
    private TableColumn<table_product_details, String> price_per_product;
    @FXML
    private Button home;
    ObservableList<table_product_details> pdlist = FXCollections.observableArrayList();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            DataAccessLayer dal = new DataAccessLayer();
            ResultSet rss = dal.dbreadproductdetails();
            while(rss.next()){
                
                String a = rss.getString("product_id");
                String aa = rss.getString("product_name");
                String b = rss.getString("entry_date");
                String c = rss.getString("entry_quantity");
                String d = rss.getString("remaining_quantity");
                String ee = rss.getString("price_per_product");
                
                
                pdlist.add(new table_product_details(a,aa,b,c,d,ee));
                
            }
            table_view_details.setItems(pdlist);
            product_id.setCellValueFactory(new PropertyValueFactory<>("product_id"));
            product_name.setCellValueFactory(new PropertyValueFactory<>("product_name"));
            entry_date.setCellValueFactory(new PropertyValueFactory<>("entry_date"));
            entry_quantity.setCellValueFactory(new PropertyValueFactory<>("entry_quantity"));
            remaining_quantity.setCellValueFactory(new PropertyValueFactory<>("remaining_quantity"));
            price_per_product.setCellValueFactory(new PropertyValueFactory<>("price_per_product"));
        } catch (SQLException ex) {
            Logger.getLogger(View_product_detailsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
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
