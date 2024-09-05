/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import java.sql.*;

/**
 *
 * @author KAMDEM VADECE
 */
public class DBconnect {
     Connection con;
   public DBconnect(){
   try{
   Class.forName("com.mysql.jdbc.Driver");
   System.out.print("Search for Connection class...");
    }
   catch(ClassNotFoundException cnf){
   System.out.println("Class not Found and unable to connect ..."+cnf.getLocalizedMessage());
   }
   try{
   String url = "jdbc:mysql://localhost:3306/abustore";//enter remote sever here e.g jdbc:mysql://Localhost:3306/databasename
   String user = "root";
   String pass = "";
   con = DriverManager.getConnection(url,user,pass);
   }
   catch(SQLException e2){
   e2.printStackTrace();
   }
   }
public Connection getConnection(){
return con;
}

}

