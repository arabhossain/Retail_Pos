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
package DataAccessLayer;

import AppConfig.DB;
import BusniessObjects.Login;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Loser
 */
public class CommonDAL {
        //SQL VARIABLES
    private Connection conn=null;
    private ResultSet rs=null;
    private PreparedStatement pst=null;
    Login login=new Login();

    /**
     *
     */
    public CommonDAL(){
        
    }

    /**
     *
     * @param sql
     * @return
     */
    public boolean execute_query(String sql){
                   
        try{
              conn=DB.LocalConnection();
              pst=conn.prepareStatement(sql);
              pst.execute();
              return true;
           
         }catch(MySQLIntegrityConstraintViolationException e){
             e.printStackTrace();
         } catch (SQLException ex) {
             ex.printStackTrace();
             if(ex.getErrorCode()==1062){
                JOptionPane.showMessageDialog(null,"You had tried to insert! Seems duplicate value!\n Please try with different name. Thank you!", "Operation failed",JOptionPane.ERROR_MESSAGE);
             }
            
           
        }finally {
                try{
                   if(conn!=null)
                      conn.close();
                }catch(SQLException se){
                   se.printStackTrace();
                }
        }
         return false;
    }

    /**
     *
     * @param tabileName
     * @param CollumnName
     * @param ID
     * @return
     */
    public boolean DeleteById(String tabileName,String CollumnName,String ID){
        String sql = "DELETE FROM `"+tabileName+"` WHERE `"+CollumnName+"` = '"+ID+"'";
         try{
            conn=DB.LocalConnection();
            pst=conn.prepareStatement(sql);
            pst.execute();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }finally{
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException s){
                s.printStackTrace();
            }
        }
    }

    /**
     *
     * @param tableName
     * @param CollumnName
     * @return
     */
    public int getRowSize(String tableName,String CollumnName){
        String sql="SELECT count(`"+CollumnName+"`) FROM `"+tableName+"` ";
        try{
            conn=DB.LocalConnection();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException s){
                s.printStackTrace();
            }
        }
        return 0;
    }
     
    /**
     *
     * @param IdCollmnName
     * @param TableName
     * @param CollmnName
     * @param Value
     * @return
     */
    public int getIdByNames(String IdCollmnName, String TableName,String CollmnName,String Value){
        String sql = "SELECT `"+IdCollmnName+"` FROM `"+TableName+"` WHERE `"+CollmnName+"`='"+Value+"'";
        
        try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                 return rs.getInt(IdCollmnName);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException s){
                s.printStackTrace();
            }
        }
        return 0;
    }

    /**
     *
     * @param IdCollmnName
     * @param TableName
     * @param CollmnName
     * @param Value
     * @return
     */
    public String getNameByID(String IdCollmnName, String TableName,String CollmnName,String Value){
        String sql = "SELECT `"+IdCollmnName+"` FROM `"+TableName+"` WHERE `"+CollmnName+"`='"+Value+"'";
        
        try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                 return rs.getString(IdCollmnName);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException s){
                s.printStackTrace();
            }
        }
        return null;
    }
}
