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
import BusniessObjects.Pricechangelog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Loser
 */
public class PricechangelogDAL extends CommonDAL{
    private Connection conn=null;
    private ResultSet rs=null;
    private PreparedStatement pst=null;
    
    Pricechangelog pLog=new Pricechangelog();
    
    /**
     *
     * @return
     */
    public boolean insert(){
        String sql="INSERT INTO `pricechangelog`(`pPID`, `pPreviousPrice`, `pChagedPrice`, `pUserID`, `pChangedDate`) VALUES ('"
                + pLog.getPPID()+"',"
                + pLog.getPPreviousPrice()+","
                + pLog.getPChagedPrice()+","
                + login.getUserId()+","
                + "now())";
        return execute_query(sql);
    }

    /**
     *
     * @return
     */
    public ArrayList<Pricechangelog> viewAll(){
        ArrayList<Pricechangelog> list= new ArrayList<Pricechangelog>();
        Pricechangelog pLogObj;
         String sql="SELECT * FROM taxes";
         try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                 pLogObj = new Pricechangelog(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getDouble(4),rs.getInt(5),rs.getDate(6));
                 list.add(pLogObj);
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
         return list;
    }
}
