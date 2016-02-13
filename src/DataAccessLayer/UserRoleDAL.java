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
import Util.MySqlControlPanel;
import BusniessObjects.UserRole;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Loser
 */
public class UserRoleDAL {
    private Connection conn=null;
    private ResultSet rs=null;
    private PreparedStatement pst=null;
    
    UserRole ur=new UserRole();
    CommonDAL commDAL=new CommonDAL();

    /**
     *
     */
    public UserRoleDAL(){
    }
    
    /**
     *
     * @return
     */
    public boolean AddNewRole(){
        String sql="INSERT INTO `UserRole`(`Sales`, `EditSales`, `CustomerPayment`, `Expence`, `CashClose`, `Customers`, `Users`, `Stoke`, `Reports`, `PresenceManage`, `Tools`, `Config`, `Taxes`, `UsersRole`,`RoleName`) VALUES ("
                +ur.getSales()+","+ur.getEditSales()+","+ur.getCustomerPayment()+","+ur.getExpence()+","+ur.getCashClose()+","+ur.getCustomers()+","+ur.getUsers()+","+ur.getStoke()+","+ur.getReports()+","+ur.getPresenceMangae()+","+ur.getTools()+","+ur.getConfig()+","+ur.getTaxes()+","+ur.getUserRole()+",'"+ur.getTxtRoleName()+"')";
        return commDAL.execute_query(sql);
    }

    /**
     *
     * @param value
     * @return
     */
    public boolean UpdateById(int value){
        String sql="UPDATE `userrole` SET "
                + "`Sales`="+ur.getSales()
                + ",`EditSales`="+ur.getEditSales()
                + ",`CustomerPayment`="+ur.getCustomerPayment()
                + ",`Expence`="+ur.getExpence()
                + ",`CashClose`="+ur.getCashClose()
                + ",`Customers`="+ur.getCustomers()
                + ",`Users`="+ur.getUsers()
                + ",`Stoke`="+ur.getStoke()
                + ",`Reports`="+ur.getReports()
                + ",`PresenceManage`="+ur.getPresenceMangae()
                + ",`Tools`="+ur.getTools()
                + ",`Config`="+ur.getConfig()
                + ",`Taxes`="+ur.getTaxes()
                + ",`UsersRole`="+ur.getUserRole()
                + ",`RoleName`='"+ur.getTxtRoleName()+"'"
                + " WHERE RoleID="+value;
        return commDAL.execute_query(sql);
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean DeleteById(int id){
        return commDAL.DeleteById("userrole", "RoleID", String.valueOf(id));
    }
    
    /**
     *
     * @param typeID
     * @param Name
     * @return
     */
    public boolean SelectRoleBy(int typeID, String Name){
        String sql = "SELECT * FROM `userrole` WHERE ";
        if(typeID!=0 && Name.equals("")){
            sql+="`RoleID`="+typeID;
        }
        if(!Name.equals("") && typeID==0){
            sql+="`RoleName`='"+Name+"'";
        }
        if(typeID!=0 && !Name.equals("")){
            sql+="`RoleID`="+typeID+" AND `RoleName`='"+Name+"'";
        }
        try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
               ur.setSales(rs.getInt("Sales"));
               ur.setEditSales(rs.getInt("EditSales"));
               ur.setCustomerPayment(rs.getInt("CustomerPayment"));
               ur.setExpence(rs.getInt("Expence"));
               ur.setCashClose(rs.getInt("CashClose"));
               
               ur.setCustomers(rs.getInt("Customers"));
               ur.setUsers(rs.getInt("Users"));//
               
               ur.setStoke(rs.getInt("Stoke"));
               ur.setReports(rs.getInt("Reports"));
               ur.setPresenceMangae(rs.getInt("PresenceManage"));
               
               ur.setTools(rs.getInt("Tools"));
               ur.setConfig(rs.getInt("Config"));
               ur.setTaxes(rs.getInt("Taxes"));//
               ur.setUserRoleID(rs.getInt("UsersRole"));//
               ur.setUserRole(ur.getUserRoleID());
               ur.setTxtRoleName(rs.getString("RoleName"));
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
     * @return
     */
    public boolean SelectRoleNames(){
        String sql = "SELECT `RoleName` FROM `userrole`";
        try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            int i=0;
            UserRole.names=new String[getRowSize()];
            while(rs.next()){
                    UserRole.names[i]=rs.getString("RoleName");
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
        return commDAL.getRowSize("userrole", "RoleID");
    }

    /**
     *
     * @param Name
     * @return
     */
    public int getRoleIdByNames(String Name){
        return commDAL.getIdByNames("RoleID", "userrole", "RoleName", Name);
    }
}
