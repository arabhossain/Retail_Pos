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
import BusniessObjects.Leavelist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Loser
 */
public class LeavelistDAL  extends CommonDAL{
            //SQL VARIABLES
    private Connection conn=null;
    private ResultSet rs=null;
    private PreparedStatement pst=null;
    Leavelist lList=new Leavelist();
    
    /**
     *
     * @return
     */
    public boolean insert(){
        String sql="INSERT INTO `leavelist`(`lStuffID`, `lReasion`, `lStartDate`, `lEndDate`, `lRequestStuffID`, "
                + "`lApproved`, `lRequestSeenAt`, `lRequestTime`) VALUES ("
                +lList.getLStuffID()+",'"
                +lList.getLReasion()+"',"
                +lList.getLStartDate()+","
                +lList.getLEndDate()+","
                +lList.getLRequestStuffID()+","
                +"0,0,now())";
        return execute_query(sql);
    }

    /**
     *
     * @param LeaveID
     * @return
     */
    public boolean deleteByID(String LeaveID){
        return DeleteById("leavelist", "lID", LeaveID);
    }

    /**
     *
     * @param LeaveID
     * @return
     */
    public boolean setSeen(int LeaveID){
        String sql="UPDATE `leavelist` SET `lRequestSeenAt`=now() WHERE `lID`="+LeaveID;
        return execute_query(sql);
    }

    /**
     *
     * @param LeaveID
     * @param status
     * @return
     */
    public boolean setLeaveStatus(int LeaveID,int status){
        String sql="UPDATE `leavelist` SET `lApproved`="+status+" WHERE `lID`="+LeaveID;
        return execute_query(sql);
    }

    /**
     *
     * @param LeaveID
     * @return
     */
    public boolean SelectByID(int LeaveID){
        String sql = "SELECT * FROM `leavelist` WHERE `lID`="+LeaveID;
        try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
               new Leavelist(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getDate(4),rs.getDate(5),rs.getInt(6),rs.getInt(7),
               rs.getDate(8),rs.getDate(9));
                return true;
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
        return false;
    }

    /**
     *
     * @return
     */
    public boolean LeaveLists(){
        String sql="SELECT `lID`, `lStartDate`, `lEndDate` FROM `leavelist` WHERE lStuffID="+login.getUserId();
        int temp=getRowSize();
        Leavelist.LIDs=new int[temp];
        Leavelist.StartEnds=new String[temp];
        try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            int i=0;
            while(rs.next()){
                    Leavelist.LIDs[i]=rs.getInt("lID");
                    Leavelist.StartEnds[i]="["+rs.getString("lStartDate")+"-"+rs.getString("lEndDate")+"]";
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
     * @return
     */
    public int getRowSize(){
        String sql="SELECT COUNT(`lID`) FROM `leavelist` WHERE `lStuffID`="+login.getUserId();
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
}
