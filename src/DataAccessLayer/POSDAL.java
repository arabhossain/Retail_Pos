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
import BusniessObjects.ProductsList;
import BusniessObjects.ViewProductslist;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Loser
 */
public class POSDAL extends CommonDAL{
     //SQL VARIABLES
    private Connection conn=null;
    private ResultSet rs=null;
    private PreparedStatement pst=null;
    
    /**
     *
     * @return
     */
    public boolean SelectCatNames(){
        String sql = "SELECT * FROM `productcategories` WHERE catVisibile=1";
        int temp=getCatRowSize();
        try{
            Productcategories.pCatNames=new String[temp];
            Productcategories.pCatIDs=new int[temp];
            Productcategories.pCatPhotoURLs=new String[temp];
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            int i=0;
            while(rs.next()){
                    Productcategories.pCatIDs[i]=rs.getInt("catID");
                    Productcategories.pCatNames[i]=rs.getString("catName");
                    Productcategories.pCatPhotoURLs[i]=rs.getString("catPhotoURL");
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
     * @param CatID
     * @return
     */
    public boolean getFilterProductsByCat(int CatID){
        String sql="SELECT pID,pName,pPhotoURL,pSalePrice FROM `productslist` WHERE pVisible=1 AND pCatID="+CatID;
       
         int tempsize=getProductsRowSize(CatID);
        try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            int i=0;
           
            ProductsList.pLists=new String[tempsize];
            ProductsList.pIDs=new String[tempsize];
            ProductsList.pIconList=new String[tempsize];
            ProductsList.pPrice=new String[tempsize];
            while(rs.next()){
                   ProductsList.pIDs[i]=rs.getString("pID");
                   ProductsList.pLists[i]=rs.getString("pName");
                   ProductsList.pIconList[i]=rs.getString("pPhotoURL");
                   ProductsList.pPrice[i]=rs.getString("pSalePrice");
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

    
    private int getCatRowSize(){
        String sql="SELECT count(`catID`) FROM `productcategories` WHERE catVisibile=1";
        try{
            conn=DB.LocalConnection();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    /**
     *
     * @param CatID
     * @return
     */
    public int getProductsRowSize(int CatID){
        String sql="SELECT count(`pListID`) FROM `productslist` WHERE pVisible=1 AND pCatID="+CatID;
        try{
            conn=DB.LocalConnection();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    /**
     *
     * @param pID
     * @param Barcode
     * @param PName
     * @return
     */
    public ArrayList<ViewProductslist> viewProduct(String pID,String Barcode,String PName){
        String sql="SELECT * FROM `view_productslist` WHERE ";
        if(pID!=null && Barcode==null && PName==null){
            sql+="`pID`='"+pID+"'";
        }else if(Barcode!=null && pID==null && PName==null){
             sql+="`pBarcode`='"+Barcode+"'";
        }
        else if(PName!= null && Barcode==null && pID==null){
             sql+="`pName`='"+PName+"'";
        }
        ArrayList<ViewProductslist> list= new ArrayList<ViewProductslist>();
        ViewProductslist objVP;
         try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
     
            if(rs.next()){
                  objVP=new ViewProductslist(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7),rs.getDouble(8),rs.getString(9),rs.getInt(10),rs.getDate(11));
                  list.add(objVP);
            }
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
    return list;
    }

}
