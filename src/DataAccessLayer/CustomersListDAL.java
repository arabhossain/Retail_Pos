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
import AppConfig.vars;
import BusniessObjects.Customerslist;
import BusniessObjects.Login;
import BusniessObjects.Productcategories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Loser
 */
public class CustomersListDAL extends CommonDAL{
    //SQL VARIABLES
    private Connection conn=null;
    private ResultSet rs=null;
    private PreparedStatement pst=null;
    
    Customerslist cList=new Customerslist();
    Login login=new Login();
    
    /**
     *
     * @return
     */
    public boolean insert(){
        String sql="INSERT INTO `customerslist`(`cID`, `cName`, `cMobile`, `cEmail`, `cFax`, `cHouse`, `cRoad`, `cBlock`, "
                + "`cSection`, `cArea`, `cCity`, `cVillageAddress`, `cPhotoURL`, `cJoinDate`, `cAddUserID`, `cBrancID`) VALUES ('"
                + cList.getCID()+"','"
                + cList.getCName()+"','"
                + cList.getCMobile()+"','"
                + cList.getCEmail()+"','"
                + cList.getCFax()+"','"
                + cList.getCHouse()+"','"
                + cList.getCRoad()+"','"
                + cList.getCBlock()+"','"
                + cList.getCSection()+"','"
                + cList.getCArea()+"','"
                + cList.getCCity()+"','"
                + cList.getCVillageAddress()+"','"
                + cList.getCPhotoURL()+"',"
                + "now(),"
                + login.getUserId()
                +","+vars.getBranchID()+")";
        return execute_query(sql);
    }

    /**
     *
     * @param cID
     * @return
     */
    public boolean delete(String cID){
        return DeleteById("customerslist", "cID", cID);
    }

    /**
     *
     * @param cID
     * @return
     */
    public boolean update(String cID){
        String sql="UPDATE `customerslist` SET "
                + "`cName`='"+cList.getCName()
                + "',`cMobile`='"+cList.getCMobile()
                + "',`cEmail`='"+cList.getCEmail()
                + "',`cFax`='"+cList.getCFax()
                + "',`cHouse`='"+cList.getCHouse()
                + "',`cRoad`='"+cList.getCRoad()
                + "',`cBlock`='"+cList.getCBlock()
                + "',`cSection`='"+cList.getCSection()
                + "',`cArea`='"+cList.getCArea()
                + "',`cCity`='"+cList.getCCity()
                + "',`cVillageAddress`='"+cList.getCVillageAddress()
                + "',`cPhotoURL`='"+cList.getCPhotoURL()
                + "' WHERE `cID`='"+cID+"'";
        return execute_query(sql);
    }

    /**
     *
     * @param cID
     * @return
     */
    public boolean SelectCustomerByCID(String cID){
        String sql = "SELECT * FROM `customerslist` WHERE `cID`='"+cID+"'";
        try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
               new Customerslist(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
               rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),
               rs.getString(14),rs.getDate(15),rs.getInt(16),rs.getInt(17));
                return true;
            }
             return false;
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
    public boolean SelectCustomerNames(){
        String sql = "SELECT cID,cName FROM `customerslist`";
        try{
            int tempSize=getRowSize("customerslist","cSerial");
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            int i=0;
            Customerslist.cNames=new String[tempSize];
            Customerslist.cIDs=new String[tempSize];
            while(rs.next()){
                    Customerslist.cIDs[i]=rs.getString("cID");
                    Customerslist.cNames[i]=rs.getString("cName");
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
    
     //Search DAL

    /**
     *
     * @param cName
     * @return
     */
     
      public boolean getFilterCustomers(String cName){
        String sql="SELECT cID,cName FROM `customerslist` WHERE ";

        if(cName!= null){
             sql+="`cName` LIKE  '%"+cName+"%'";
        }
            
            int tempSize=getFilteredRowSize(cName);
            Customerslist.cNames=new String[tempSize];
            Customerslist.cIDs=new String[tempSize];
        try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            int i=0;
            while(rs.next()){
                    Customerslist.cIDs[i]=rs.getString("cID");
                    Customerslist.cNames[i]=rs.getString("cName");
                    i++;
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
 
        }finally{
            try{
                if(conn!=null)
                    conn.close();
            }catch(java.sql.SQLException s){
                s.printStackTrace();
            }
        }
    return false;
    }

    /**
     *
     * @param ByName
     * @return
     */
    public int getFilteredRowSize(String ByName){
        String sql="SELECT COUNT(cSerial) FROM  `customerslist` WHERE ";
        if(ByName!=null){
            sql+="`cName` LIKE  '%"+ByName+"%'";
        }
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
            }catch(java.sql.SQLException s){
                s.printStackTrace();
            }
        }
        return 0;
    }////

    /**
     *
     * @return
     */
    public int getLastProductID(){
        String sql="SELECT  `cSerial` FROM  `customerslist` ORDER BY  `cSerial` DESC LIMIT 0 , 1";

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
            }catch(java.sql.SQLException s){
                s.printStackTrace();
            }
        }
        return 0;
    }
}
