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
import BusniessObjects.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Loser
 */
public class UserDAL extends DB{
    //SQL VARIABLES
    private Connection conn=null;
    private ResultSet rs=null;
    private PreparedStatement pst=null;
    
 
    Users ObjUsers=new Users();
    CommonDAL commonDAL=new CommonDAL();
    
    /**
     *
     * @return
     */
    public boolean insert(){
        String sql= "INSERT INTO `users`(`FullName`, `UserName`, `Mobile`, `Address`, `RoleId`,`BranchID`, `Password`, `PhotoURL`, `LastAcivity`, `AccountStatus`, `IsOnline`)"
                  + "VALUES ('"+ObjUsers.getFullName()+"','"+ObjUsers.getUserName()+"','"+ObjUsers.getMobile()+"',"
                + "'"+ObjUsers.getAddress()+"',"+ObjUsers.getRoled()+","+ObjUsers.getBranchID()+",'"+Arab.Arab3SH.En_Code(ObjUsers.getPassword())+"','"+ObjUsers.getPhotoURL()+"',"
                +/*ObjUsers.getLastActivity()+*/"now(),"+ObjUsers.isAccoutStatus()+","+ObjUsers.isIsOnline()+")";
                    
        return commonDAL.execute_query(sql);
    }

    /**
     *
     * @param Name
     * @return
     */
    public int getUserIdByNames(String Name){
        return commonDAL.getIdByNames("UserId", "users", "UserName", Name);
    }

    /**
     *
     * @param ID
     * @return
     */
    public boolean update(int ID){
        String sql="UPDATE `users` SET "
                + "`FullName`='"+ObjUsers.getFullName()+"'"
                + ",`UserName`='"+ObjUsers.getUserName()+"'"
                + ",`Mobile`='"+ObjUsers.getMobile()+"'"
                + ",`Address`='"+ObjUsers.getAddress()+"'"
                + ",`RoleId`='"+ObjUsers.getRoled()+"'"
                + ",`BranchID`="+ObjUsers.getBranchID() 
                + ",`Password`='"+Arab.Arab3SH.En_Code(ObjUsers.getPassword())+"'"
                + ",`PhotoURL`='"+ObjUsers.getPhotoURL()+"'"
                + ",`AccountStatus`="+ObjUsers.isAccoutStatus()
                + " WHERE UserId="+ID;
        return commonDAL.execute_query(sql);
    }

    /**
     *
     * @param UserName
     * @return
     */
    public boolean DeleteByUserName(String UserName){
        return commonDAL.DeleteById("users", "UserName", UserName);
    }

    /**
     *
     * @return
     */
    public boolean SelectUsersNames(){
        String sql = "SELECT `UserName` FROM `users`";
        try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            int i=0;
            Users.usernames=new String[getRowSize()];
            while(rs.next()){
                    Users.usernames[i]=rs.getString("UserName");
                    i++;
            }
             return true;
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
        return false;
    }

    /**
     *
     * @return
     */
    public int getRowSize(){
        return commonDAL.getRowSize("users", "UserId");
    }

    /**
     *
     * @param typeID
     * @param Name
     * @return
     */
    public boolean SelectUserBy(int typeID, String Name){
        String sql = "SELECT * FROM `users` WHERE ";
        if(typeID!=0 && Name.equals("")){
            sql+="`UserId`="+typeID;
        }
        if(!Name.equals("") && typeID==0){
            sql+="`UserName`='"+Name+"'";
        }
        if(typeID!=0 && !Name.equals("")){
            sql+="`UserId`="+typeID+" AND `UserName`='"+Name+"'";
        }
        try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                ObjUsers.setFullName(rs.getString("FullName"));
                ObjUsers.setUserName(rs.getString("UserName"));
                ObjUsers.setMobile(rs.getString("Mobile"));
                ObjUsers.setAddress(rs.getString("Address"));
                ObjUsers.setRoled(rs.getInt("RoleId"));
                ObjUsers.setBranchID(rs.getInt("BranchID"));
                ObjUsers.setPhotoURL(rs.getString("PhotoURL"));
                ObjUsers.setPassword(Arab.Arab3SH.De_Code(rs.getString("Password")));
                ObjUsers.setAccoutStatus(rs.getInt("AccountStatus"));
                ObjUsers.setIsOnline(rs.getInt("IsOnline"));
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
}
