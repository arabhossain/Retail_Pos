/*
    Software Engineer
    ---------------------------------------
    Md. Arab Hossain
    Email: arabhossain317@diu.edu.bd
           green.arab1995@gmail.com
    Mobile: +8801827-464330
            +8801737-331037
    Daffodil International University(Student)
 */
package Scripte;

import AppConfig.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Loser
 */
public class DatabaseCreation {

    /**
     *
     * @param getDBName
     */
    public void DatabaseCreate(String getDBName) {
   Connection conn = null;
   Statement stmt = null;
   try{
       conn=DB.LocalRootConnection();
       
       // Execute a query
      System.out.println("Creating database...");
      stmt = conn.createStatement();
      
      String sql = "CREATE DATABASE IF NOT EXISTS "+getDBName+";";
      stmt.executeUpdate(sql);

      String tab_products = "CREATE TABLE IF NOT EXISTS "+getDBName+".products(id INT(12) NOT NULL AUTO_INCREMENT, name varchar(40) not null, description varchar(200) not null, unit varchar(10) not null, PRIMARY KEY(id));";
      stmt.executeUpdate(tab_products);
      
      String tab_users = "CREATE TABLE IF NOT EXISTS "+getDBName+".users(id INT(12) NOT NULL AUTO_INCREMENT, fullname varchar(40) not null, username varchar(40) not null, password varchar(60) not null, address varchar(100) not null, usertype varchar(10) not null, PRIMARY KEY(id));";
      stmt.executeUpdate(tab_users);
      String ins_user="INSERT INTO `"+getDBName+"`.`users` (`id`, `fullname`, `username`, `password`, `address`, `usertype`) VALUES (NULL, 'Arab', 'admin', 'admin', 'Dhaka', 'a')";
      stmt.execute(ins_user);
      
      String tab_p_info = "CREATE TABLE IF NOT EXISTS "+getDBName+".p_info(id INT(12) NOT NULL AUTO_INCREMENT, productid int(12) not null, pprice float(10, 2) not null, pqty float(6, 2) not null, pdate datetime not null, p_rem_qty float(6, 2) not null, userid int(12) not null, PRIMARY KEY(id), foreign key(productid) references products(id), foreign key(userid) references users(id));";
      stmt.executeUpdate(tab_p_info);
      
      String tab_sales_info = "CREATE TABLE IF NOT EXISTS "+getDBName+".sales(id INT(12) NOT NULL AUTO_INCREMENT, sproductid int(12) not null, sprice float(10, 2) not null, sdate datetime not null, sqty float(6, 2) not null, cmobile varchar(16), rem_qty float(6, 2) not null, userid int(12) not null, PRIMARY KEY(id), foreign key(sproductid) references products(id), foreign key(userid) references users(id));";
      stmt.executeUpdate(tab_sales_info);
   }catch(java.sql.SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      return;
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(java.sql.SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample