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
import BusniessObjects.Productunits;
import BusniessObjects.Taxes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Loser
 */
public class ProductunitsDAL extends CommonDAL{
    private Connection conn=null;
    private ResultSet rs=null;
    private PreparedStatement pst=null;
    
    Productunits pUnit=new Productunits();
    
    /**
     *
     * @return
     */
    public boolean insert(){
        String sql="INSERT INTO `productunits`(`pUniName`)VALUES ('"
                + pUnit.getPUniName()+"')";
        return execute_query(sql);
    }

    /**
     *
     * @param OldName
     * @return
     */
    public boolean update(String OldName){
       String sql="UPDATE `productunits` SET "
               + "`pUniName`='"+pUnit.getPUniName()
               + "'"
               + " WHERE `pUniName`='"+OldName+"'";
       return execute_query(sql);
    }

    /**
     *
     * @param OldName
     * @return
     */
    public boolean deleteByName(String OldName){
        return DeleteById("productunits", "pUniName", OldName);
    }

    /**
     *
     * @param Name
     * @return
     */
    public int getpUnitIdByName(String Name){
        return getIdByNames("pUniID","productunits","pUniName",Name);
    }

    /**
     *
     * @param ID
     * @return
     */
    public String getpUnitNameByID(int ID){
        return getNameByID("pUniName","productunits","pUniID",String.valueOf(ID));
    }

    /**
     *
     * @return
     */
    public boolean getUnitNames(){
        String sql="SELECT pUniName FROM productunits";
         try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            int i=0;
            Productunits.pUnitNames=new String[getRowSize("productunits","pUniID")];
            while(rs.next()){
                    Productunits.pUnitNames[i]=rs.getString("pUniName");
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
}
