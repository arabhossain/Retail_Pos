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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Loser
 */
public class LoginDAL {
    //SQL VARIABLES
    private Connection conn=null;
    private ResultSet rs=null;
    private PreparedStatement pst=null;
    
    CommonDAL commDAL=new CommonDAL();
    Login login=new Login();

    /**
     *
     */
    public LoginDAL(){
       
    }

    /**
     *
     * @param UserName
     * @param UserPassword
     * @return
     */
    public boolean verifyUser(String UserName,String UserPassword){
       String sql = "SELECT * FROM `users` WHERE `UserName`='"+UserName+"' AND `Password`='"+Arab.Arab3SH.En_Code(UserPassword)+"'";
        try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                login.setUserId(rs.getInt("UserId"));
                login.setUserName(UserName);
                login.setUserType(rs.getInt("RoleId"));
                login.setUserBranch(rs.getInt("BranchID"));
                login.setPhotoURL(rs.getString("PhotoURL"));
                login.setAccountStatus(rs.getInt("AccountStatus"));
                return true;
            }
            return false;
        }catch(Exception e){
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
     */
    public void setUserAsOnline(){
        String sql="UPDATE `users` SET IsOnline =1, `LastAcivity`=now()  WHERE `UserId`="+login.getUserId();
        commDAL.execute_query(sql);
    }

    /**
     *
     */
    public void setUserAsOffilne(){
        String sql="UPDATE `users` SET IsOnline =0,`LastAcivity`=now() WHERE `UserId`="+login.getUserId();
        commDAL.execute_query(sql);
    }

    /**
     *
     * @return
     */
    public String getPassword(){
         String sql = "SELECT Password FROM `users` WHERE `UserId`="+login.getUserId();
        try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
               return Arab.Arab3SH.De_Code(rs.getString("Password"));
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
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

    /**
     *
     * @param NewPassword
     * @return
     */
    public boolean setUserPassword(String NewPassword){
        String sql="UPDATE `users` SET Password ='"+Arab.Arab3SH.En_Code(NewPassword)+"' WHERE `UserId`="+login.getUserId();
        return commDAL.execute_query(sql);
    }
}
