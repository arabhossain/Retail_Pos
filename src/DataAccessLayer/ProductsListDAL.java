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
import BusniessObjects.ProductsList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Loser
 */
public class ProductsListDAL extends CommonDAL {
           //SQL VARIABLES
    private Connection conn=null;
    private ResultSet rs=null;
    private PreparedStatement pst=null;
    
    ProductsList pList=new ProductsList();
    
    /**
     *
     * @return
     */
    public boolean insert(){
        String sql="INSERT INTO `productslist`(`pID`, `pBarcode`, `pName`, `pCatID`, `pTaxID`, `pUnitID`, `pSalePrice`, `pPhotoURL`, `pVisible`, `pAddedDate`, `pAdminViewed`) VALUES ('"
                +pList.getpID()   + "','"
                +pList.getPBarcode()  + "','"
                +pList.getPName()     + "',"
                +pList.getPCatID()    + ","
                +pList.getPTaxID()    + ","
                +pList.getPUnitID()   + ","
                +pList.getPSalePrice()+",'"
                +pList.getPPhotoURL() +"',"
                +pList.getPVisible()  +","
                +"now()"              +","
                +pList.getPAdminViewed()
                +")";
        return execute_query(sql);
    }

    /**
     *
     * @param ProductID
     * @return
     */
    public boolean update(String ProductID){
       String sql="UPDATE `productslist` SET  "
               + "`pBarcode`='"+pList.getPBarcode()
               + "',`pName`='"+pList.getPName()
               + "',`pCatID`="+pList.getPCatID()
               + ",`pTaxID`="+pList.getPTaxID()
               + ",`pUnitID`="+pList.getPUnitID()
               + ",`pSalePrice`="+pList.getPSalePrice()
               + ",`pPhotoURL`='"+pList.getPPhotoURL()
               + "',`pVisible`="+pList.getPVisible()
               + " WHERE pID='"+ProductID+"'";
       return execute_query(sql);
    }

    /**
     *
     * @param ProductID
     * @return
     */
    public boolean updateVisibility(String ProductID){
         String sql="UPDATE `productslist` SET  "
                 +"`pVisible`="+pList.getPVisible()
               + " WHERE pID='"+ProductID+"'";
         return execute_query(sql);
     }

    /**
     *
     * @param ProductID
     * @return
     */
    public boolean deleteBypID(String ProductID){
        return DeleteById("productslist", "pID", ProductID);
    }
    
    /**
     *
     * @param pID
     * @param Barcode
     * @param PName
     * @return
     */
    public boolean getProductBy(String pID,String Barcode,String PName){
        String sql="SELECT * FROM `productslist` WHERE ";
        if(pID!=null && Barcode==null && PName==null){
            sql+="`pID`='"+pID+"'";
        }else if(Barcode!=null && pID==null && PName==null){
             sql+="`pBarcode`='"+Barcode+"'";
        }
        else if(PName!= null && Barcode==null && pID==null){
             sql+="`pName`='"+PName+"'";
        }
         try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
     
            if(rs.next()){
                   new ProductsList(rs.getInt("pListID"),rs.getString("pID"),rs.getString("pBarcode"),rs.getString("pName"),
                           rs.getInt("pCatID"),rs.getInt("pTaxID"),rs.getInt("pUnitID"),rs.getDouble("pSalePrice"),rs.getString("pPhotoURL"),
                   rs.getInt("pVisible"),rs.getInt("pAdminViewed"));
                   return true;
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
    return false;
    }

    /**
     *
     * @return
     */
    public boolean getProductsNames(){
        String sql="SELECT pID,pName FROM productslist";
        int tempsize=getRowSize("productslist","pListID");
         try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            int i=0;
            ProductsList.pLists=new String[tempsize];
            ProductsList.pIDs=new String[tempsize];
            while(rs.next()){
                   ProductsList.pIDs[i]=rs.getString("pID");
                   ProductsList.pLists[i]=rs.getString("pName");
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
            }catch(java.sql.SQLException s){
                s.printStackTrace();
            }
        }    
    }
    //Search DAL
     
    /**
     *
     * @param CatID
     * @param PName
     * @return
     */
    public boolean getFilterProducts(int CatID,String PName){
        String sql="SELECT pID,pName FROM `productslist` WHERE ";
        if(CatID!=0 &&  PName==null){
            sql+="pCatID="+CatID;
        }
        else if(PName!= null && CatID==0){
             sql+="`pName` LIKE  '%"+PName+"%'";
        }
         int tempsize=getFilteredRowSize(PName,CatID);
        try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            int i=0;
           
             ProductsList.pLists=new String[tempsize];
            ProductsList.pIDs=new String[tempsize];
            while(rs.next()){
                   ProductsList.pIDs[i]=rs.getString("pID");
                   ProductsList.pLists[i]=rs.getString("pName");
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
     * @param CatID
     * @return
     */
    public int getFilteredRowSize(String ByName,int CatID){
        String sql="SELECT COUNT(pListID) FROM  `productslist` WHERE ";
        if(ByName!=null && CatID==0){
            sql+="`pName` LIKE  '%"+ByName+"%'";
        }else if(CatID!=0 &&ByName==null){
            sql+="pCatID="+CatID;
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
    }
    
    /**
     *
     * @param AIstatus
     * @return
     */
    public boolean getFilterProducts(String AIstatus){
              int id=-1;
              if(AIstatus.equals("Active")){
                  id=1;
              }else if(AIstatus.equals("Invactive")){
                  id=0;
              }
        String sql="SELECT pID,pName FROM `productslist` WHERE pVisible="+id;

         int tempsize=getFilteredRowSizeForAI(id);
        try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            int i=0;
           
             ProductsList.pLists=new String[tempsize];
            ProductsList.pIDs=new String[tempsize];
            while(rs.next()){
                   ProductsList.pIDs[i]=rs.getString("pID");
                   ProductsList.pLists[i]=rs.getString("pName");
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
     * @param AI
     * @return
     */
    public int getFilteredRowSizeForAI(int AI){
        String sql="SELECT COUNT(pListID) FROM  `productslist` WHERE pVisible="+AI;
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







////

    /**
     *
     * @return
     */
    public int getLastProductID(){
        String sql="SELECT  `pListID` FROM  `productslist` ORDER BY  `pListID` DESC LIMIT 0 , 1";

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
