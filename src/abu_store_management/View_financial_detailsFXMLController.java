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
public class View_financial_detailsFXMLController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        } catch (SQLException ex) {
            Logger.getLogger(View_financial_detailsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
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
