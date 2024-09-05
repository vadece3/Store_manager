/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;


import com.sun.rowset.internal.Row;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Cell;
import org.shaded.apache.poi.hssf.usermodel.HSSFCell;
import org.shaded.apache.poi.hssf.usermodel.HSSFRow;
import org.shaded.apache.poi.hssf.usermodel.HSSFSheet;
import org.shaded.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.shaded.apache.poi.ss.usermodel.DataFormatter;

/**
 *
 * @author KAMDEM VADECE
 */
public class DataAccessLayer {
     Connection con;
     DBconnect dbcon = new DBconnect();
     static int size;
     static String cnames ="";
     static String lectname="";
      
   public DataAccessLayer(){
     
    }
  
     public void dbaddproduct(String a,String b,String c,String d,String e) throws SQLException {
   
       con = dbcon.getConnection(); 
       String sql1 = "insert into product (product_name,price_per_product,quantity,date_of_entry,date_of_entry_notime) values (?,?,?,?,?)";
       PreparedStatement addproduct = con.prepareStatement(sql1);
       addproduct.setString(1,a);
       addproduct.setString(2,b);
       addproduct.setString(3,c);
       addproduct.setString(4,d);
       addproduct.setString(5,e);
       addproduct.execute();
       
       String sql2 = "insert into product_details (product_name,entry_date,entry_quantity,remaining_quantity,price_per_product) values (?,?,?,?,?)";
       PreparedStatement addproductdetails = con.prepareStatement(sql2);
       addproductdetails.setString(1,a);
       addproductdetails.setString(2,d);
       addproductdetails.setString(3,c);
       addproductdetails.setString(4,c);
       addproductdetails.setString(5,b);
       addproductdetails.execute();
    
   }
   
   public void dbdeleteproduct(String product,String solddate) throws SQLException{
       con = dbcon.getConnection(); 
       
       String sql = "delete from product where product_name=? AND date_of_entry=?";
       PreparedStatement deleteproduct = con.prepareStatement(sql);
       deleteproduct.setString(1,product);
       deleteproduct.setString(2,solddate);
       deleteproduct.execute();
       
       String sql2 = "delete from product_details where product_name=? AND entry_date=?";
       PreparedStatement deleteproductdetails = con.prepareStatement(sql2);
       deleteproductdetails.setString(1,product);
       deleteproductdetails.setString(2,solddate);
       deleteproductdetails.execute();
   }
   
   public ResultSet dbreadentrydate() throws SQLException{
       con = dbcon.getConnection();
       ResultSet date = con.createStatement().executeQuery("select date_of_entry from product");
        return date;
   
   }  
         
   public ResultSet dbreadproduct_name(String date) throws SQLException{
       con = dbcon.getConnection();
       ResultSet entrydate = con.createStatement().executeQuery("select product_name from product where date_of_entry=\""+date+"\"");
      
        return entrydate;
   
   } 
   
   public ResultSet dbreadentrydatenotime() throws SQLException{
       con = dbcon.getConnection();
       ResultSet date = con.createStatement().executeQuery("select date_of_entry_notime from product");
        return date;
   
   } 
   
   public ResultSet dbreadproduct_namenotime(String date) throws SQLException{
       con = dbcon.getConnection();
       ResultSet entrydate = con.createStatement().executeQuery("select product_name from product where date_of_entry_notime=\""+date+"\"");
      
        return entrydate;
   
   } 
   
   public void dbaddsoldproduct(String a,String b,String c,String d,String e,String f) throws SQLException {
   
       con = dbcon.getConnection(); 
       
        ResultSet rs1 = con.createStatement().executeQuery("SELECT date_of_entry FROM product where date_of_entry_notime=\""+b+"\" AND product_name=\""+a+"\"");
              rs1.next();
             String entrydate = rs1.getString("date_of_entry");
             
       ResultSet rs2 = con.createStatement().executeQuery("SELECT remaining_quantity FROM product_details where entry_date=\""+entrydate+"\"");
              rs2.next();
             String remainingquantity = rs2.getString("remaining_quantity");
             
             int number_rq =  Integer.parseInt (remainingquantity);
             int number_soldquantity = Integer.parseInt (c);
             int result = number_rq - number_soldquantity ;
             
             String result_rq = String.valueOf(result);
             
             ResultSet rs3 = con.createStatement().executeQuery("SELECT price_per_product FROM product_details where entry_date=\""+entrydate+"\"");
              rs3.next();
             String priceperproduct = rs3.getString("price_per_product");
             ResultSet rs4 = con.createStatement().executeQuery("SELECT entry_quantity FROM product_details where entry_date=\""+entrydate+"\"");
              rs4.next();
             String entry_quantity = rs4.getString("entry_quantity");
            
              
       
       
       String sql1 = "insert into daily_sales (product_name,entry_date,sold_quantity,sold_price,sold_date,sold_datenotime,price_per_product,entry_quantity,remaining_quantity) values (?,?,?,?,?,?,?,?,?)";
       PreparedStatement addproduct = con.prepareStatement(sql1);
       addproduct.setString(1,a);
       addproduct.setString(2,b);
       addproduct.setString(3,c);
       addproduct.setString(4,d);
       addproduct.setString(5,e);
       addproduct.setString(6,f);
       addproduct.setString(7,priceperproduct);
       addproduct.setString(8,entry_quantity);
       addproduct.setString(9,result_rq);
       addproduct.execute();
       
       
        String sqlfinal = "UPDATE product_details SET remaining_quantity=\""+result_rq+"\" WHERE entry_date=\""+entrydate+"\"";
        PreparedStatement adduniqueid= con.prepareStatement(sqlfinal); 
       
       adduniqueid.execute(); 
    
   }
   
     public ResultSet dbreadproductdetails() throws SQLException{
       con = dbcon.getConnection();
       ResultSet product_details_data = con.createStatement().executeQuery("select * from product_details ");
        return product_details_data;
   
   }  
     
     public ResultSet dbreadfinancialproductdetails() throws SQLException{
       con = dbcon.getConnection();
       ResultSet product_details_data = con.createStatement().executeQuery("select * from daily_sales ");
        return product_details_data;
   
   }     
   
    public ResultSet dbreadsolddatenotime() throws SQLException{
       con = dbcon.getConnection();
       ResultSet date = con.createStatement().executeQuery("select sold_datenotime from daily_sales");
        return date;
   
   } 
   
   public ResultSet dbreadfinancialproductdetailsnotime(String a) throws SQLException{
       con = dbcon.getConnection();
       ResultSet product_details_data = con.createStatement().executeQuery("select * from daily_sales where sold_datenotime=\""+a+"\" ");
        return product_details_data;
   
   }     
   
    public ResultSet dbreadallsold_price() throws SQLException{
       con = dbcon.getConnection();
       ResultSet sold_price = con.createStatement().executeQuery("select sold_price from daily_sales ");
        return sold_price;
   
   }    
   
   public ResultSet dbreaduniquesold_price(String a) throws SQLException{
       con = dbcon.getConnection();
       ResultSet sold_price = con.createStatement().executeQuery("select sold_price from daily_sales where sold_datenotime=\""+a+"\" ");
        return sold_price;
   
   }    
   
   
    public ResultSet dbgetuserlogin() throws SQLException{
       con = dbcon.getConnection();
       ResultSet userlogin = con.createStatement().executeQuery("select * from userlogin");
        return userlogin;
   
   }     
 
}