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
import BusniessObjects.Breaks;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Loser
 */
public class BreaksDAL extends CommonDAL {
    private Connection conn=null;
    private ResultSet rs=null;
    private PreparedStatement pst=null;
    
    Breaks brk=new Breaks();
    
    /**
     *
     * @return
     */
    public boolean insert(){
        String sql="INSERT INTO `breaks`( `bName`, `bVisibility`,`bTime`, `bNote`, `bCreatedDate`) VALUES ('"
                +brk.getBName()+ "',"
                +brk.getBVisibility()+",'"
                +brk.getBTime()+"','"
                +brk.getBNote()+"',"
                +"now())";
        return execute_query(sql);
    }

    /**
     *
     * @param bID
     * @return
     */
    public boolean update(int bID){
       String sql="UPDATE `breaks` SET "
               + "`bName`='"+brk.getBName()
               + "',`bVisibility`="+brk.getBVisibility()
               +",`bTime`='"+brk.getBTime()
               + "',`bNote`='"+brk.getBNote()
               + "' WHERE `bID`="+bID;
       return execute_query(sql);
    }

    /**
     *
     * @param bID
     * @return
     */
    public boolean deleteByID(int bID){
        return DeleteById("breaks", "bID", String.valueOf(bID));
    }

    /**
     *
     * @param Name
     * @return
     */
    public int getBreaksIdByName(String Name){
        return getIdByNames("bID","breaks","bName",Name);
    }

    /**
     *
     * @param bID
     * @return
     */
    public String getBreaksNameByID(int bID){
        return getNameByID("bName","breaks","bID",String.valueOf(bID));
    }

    /**
     *
     * @param bID
     * @return
     */
    public boolean SelectBreakByID(int bID){
        String sql = "SELECT * FROM `breaks` WHERE `bID`="+bID;
        try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                new Breaks(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getDate(6));
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
    public boolean getBreaksNames(){
        String sql="SELECT `bID`, `bName` FROM `breaks`";
        int temp=getRowSize("breaks","bID");
         try{
            Breaks.bNames=new String[temp];
            Breaks.bIDs=new int[temp];
            
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            int i=0;
            while(rs.next()){
                    Breaks.bIDs[i]=rs.getInt("bID");
                    Breaks.bNames[i]=rs.getString("bName");
                    i++;
            }
            return true;
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
    public boolean getBreaksIfVisible(){
        String sql="SELECT `bID`, `bName` FROM `breaks` WHERE bVisibility=1";
        int temp=getRowSizeIfVisible();
         try{
            Breaks.bNames=new String[temp];
            Breaks.bIDs=new int[temp];
            
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            int i=0;
            while(rs.next()){
                    Breaks.bIDs[i]=rs.getInt("bID");
                    Breaks.bNames[i]=rs.getString("bName");
                    i++;
            }
            return true;
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
    public int getRowSizeIfVisible(){
        String sql="SELECT count(`bID`) FROM `breaks` WHERE bVisibility=1 ";
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
