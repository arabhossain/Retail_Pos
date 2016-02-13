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
import BusniessObjects.Branches;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Loser
 */
public class BranchesDAL extends CommonDAL{
        //SQL VARIABLES
    private Connection conn=null;
    private ResultSet rs=null;
    private PreparedStatement pst=null;
    
    Branches bnch=new Branches();
    
    /**
     *
     * @return
     */
    public boolean insert(){
        String sql="INSERT INTO `branches`(`bName`, `bAdressLine1`, `bAdressLine2`, `bHeadBranch`) VALUES ('"
                + bnch.getBName()
                + "','"
                + bnch.getBAdressLine1()
                + "','"
                +bnch.getBAdressLine2()
                + "',"
                + bnch.getBHeadBranch()
                + ")";
        return execute_query(sql);
    }

    /**
     *
     * @param OldName
     * @return
     */
    public boolean update(String OldName){
       String sql="UPDATE `branches` SET "
               + "`bName`='"+bnch.getBName()
               + "',`bAdressLine1`='"+bnch.getBAdressLine1()
               + "',`bAdressLine2`='"+bnch.getBAdressLine2()
               + "',`bHeadBranch`="+bnch.getBHeadBranch()
               + " WHERE `bName`='"+OldName+"'";
       return execute_query(sql);
    }

    /**
     *
     * @param OldName
     * @return
     */
    public boolean deleteByName(String OldName){
        return DeleteById("branches", "bName", OldName);
    }

    /**
     *
     * @param OldName
     * @param ID
     * @return
     */
    public boolean getBranchByName(String OldName,int ID){
        String sql="SELECT * FROM `branches` WHERE ";
        if(!OldName.equals("") && ID==0){
            sql+="`bName`='"+OldName+"'";
        }else if(ID!=0 && OldName.equals("")){
             sql+="`bID`="+ID;
        }
         try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
     
            if(rs.next()){
                   new Branches(rs.getInt("bID"),rs.getString("bName"),rs.getString("bAdressLine1"),rs.getString("bAdressLine2"),rs.getInt("bHeadBranch"));
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
            }catch(java.sql.SQLException s){
                s.printStackTrace();
            }
        }    
    }
    
    /**
     *
     * @return
     */
    public boolean getBranchNames(){
        String sql="SELECT bName FROM branches";
         try{
            conn=DB.LocalConnection(); 
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            int i=0;
            Branches.bNames=new String[getRowSize("branches","bID")];
            while(rs.next()){
                   Branches.bNames[i]=rs.getString("bName");
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
}
