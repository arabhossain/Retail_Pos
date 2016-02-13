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
import BusniessObjects.Taxes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author Loser
 */
public class TaxesDAL {
    private Connection conn=null;
    private ResultSet rs=null;
    private PreparedStatement pst=null;
    
    BusniessObjects.Taxes tax=new BusniessObjects.Taxes();
    CommonDAL comm=new CommonDAL();

    /**
     *
     * @return
     */
    public boolean insert(){
        String sql="INSERT INTO `taxes`(`taxName`, `taxValue`) VALUES ('"
                + tax.getTaxName()+"',"+tax.getTaxValue()+")";
        return comm.execute_query(sql);
    }

    /**
     *
     * @param OldName
     * @return
     */
    public boolean update(String OldName){
       String sql="UPDATE `taxes` SET "
               + "`taxName`='"+tax.getTaxName()
               + "',`taxValue`="+tax.getTaxValue()
               + " WHERE `taxName`='"+OldName+"'";
       return comm.execute_query(sql);
    }

    /**
     *
     * @param OldName
     * @return
     */
    public boolean deleteByName(String OldName){
        return comm.DeleteById("taxes", "taxName", OldName);
    }

    /**
     *
     * @param Name
     * @return
     */
    public boolean selectByNames(String Name){
        String sql="SELECT * FROM taxes WHERE `taxName`='"+Name+"'";
         try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
             tax.setTaxName(rs.getString("taxName"));
             tax.setTaxValue(rs.getInt("taxValue"));
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
    public boolean getTaxNames(){
        String sql="SELECT * FROM taxes";
         try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            int i=0;
            Taxes.taxNames=new String[getRowSize()];
            while(rs.next()){
                    Taxes.taxNames[i]=rs.getString("taxName");
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
    public int getRowSize(){
        return comm.getRowSize("taxes", "taxID");
    }

    /**
     *
     * @param Name
     * @return
     */
    public int getpTaxIdByName(String Name){
        return comm.getIdByNames("taxID","taxes","taxName",Name);
    }

    /**
     *
     * @param ID
     * @return
     */
    public String getpUnitNameByID(int ID){
        return comm.getNameByID("taxName","taxes","taxID",String.valueOf(ID));
    }

    /**
     *
     * @param Name
     * @return
     */
    public int getpTaxValueByName(String Name){
        return comm.getIdByNames("taxValue","taxes","taxName",Name);
    }
}
