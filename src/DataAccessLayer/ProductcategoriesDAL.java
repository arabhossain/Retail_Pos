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
import BusniessObjects.Productcategories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Loser
 */
public class ProductcategoriesDAL {
        //SQL VARIABLES
    private Connection conn=null;
    private ResultSet rs=null;
    private PreparedStatement pst=null;
    
    CommonDAL comm=new CommonDAL();
    Productcategories pCat=new Productcategories();
    
    /**
     *
     * @return
     */
    public boolean insert(){
        String sql="INSERT INTO `productcategories`(`catName`, `catPhotoURL`, `catVisibile`) VALUES ('"
                + pCat.getCatName()
                + "','"
                + pCat.getCatPhotoURL()
                + "',"
                + pCat.getCatVisibile()+")";
        return comm.execute_query(sql);
    }

    /**
     *
     * @param OldName
     * @return
     */
    public boolean delete(String OldName){
        return comm.DeleteById("productcategories", "catName", OldName);
    }

    /**
     *
     * @param OldName
     * @return
     */
    public boolean update(String OldName){
        String sql="UPDATE `productcategories` SET "
                + "`catName`='"+pCat.getCatName()
                + "',`catPhotoURL`='"+pCat.getCatPhotoURL()
                + "',`catVisibile`="+pCat.getCatVisibile()
                + " WHERE `catName`='"+OldName+"'";
        return comm.execute_query(sql);
    }

    /**
     *
     * @param Name
     * @return
     */
    public boolean SelectCatByNames(String Name){
        String sql = "SELECT * FROM `productcategories` WHERE `catName`='"+Name+"'";
        try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                pCat.setCatName(rs.getString("catName"));
                pCat.setCatPhotoURL(rs.getString("catPhotoURL"));
                pCat.setCatVisibile(rs.getInt("catVisibile"));
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
    public boolean SelectCatNames(){
        String sql = "SELECT catName FROM `productcategories`";
        try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            int i=0;
            Productcategories.pCatNames=new String[comm.getRowSize("productcategories","catID")];
            while(rs.next()){
                    Productcategories.pCatNames[i]=rs.getString("catName");
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
     * @param Name
     * @return
     */
    public int getpCatIdByName(String Name){
        return comm.getIdByNames("catID","productcategories","catName",Name);
    }

    /**
     *
     * @param ID
     * @return
     */
    public String getpCatNameByID(int ID){
        return comm.getNameByID("catName","productcategories","catID",String.valueOf(ID));
    }
}
