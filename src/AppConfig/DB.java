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
package AppConfig;



import Util.MySqlControlPanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Loser
 */
public class DB {

    /**
     *
     * @return
     */
   public synchronized static Connection LocalConnection(){
        Connection conn=null;
            try{
                Class.forName(vars.getJDBC_DRIVER());
                conn=DriverManager.getConnection(vars.getDB_Url()+vars.getDbName(), vars.getDbUser(),vars.getDbPass());
                return conn;
            }catch(ClassNotFoundException | SQLException e){ 
                System.out.println(e.getMessage());
                if(e.getMessage().equals("Communications link failure\n" +
                                            "\n" +
                                            "The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.")){
                   if(conn==null){
                        try{
                             MySqlControlPanel.MySqlStart();
                        }catch(Exception ef){
                            ef.printStackTrace();
                        }finally{
                            conn=DB.LocalConnection();
                        }
                     }
                }
            }
        
     return conn;   
    }

    /**
     *
     * @return
     */
    public synchronized static Connection CloudConnection(){
        Connection conn=null;
       
            try{
                 Class.forName("com.mysql.jdbc.Driver");
                 conn=DriverManager.getConnection("jdbc:mysql://"+vars.getCloudIP()+":"+vars.getCloudPort()+"/"+vars.getCloudDatabaseName(), vars.getCloudUser(),vars.getCloudPass());
                 return conn;
            }catch(ClassNotFoundException | SQLException e){
                Notify.setMessage("Internet connection may lose!");
                e.printStackTrace();
            }
        
     return conn;   
    }
    
    /**
     *
     * @return
     */
    public static Connection LocalRootConnection(){
        Connection conn=null;
       
            try{
                Class.forName(vars.getJDBC_DRIVER());
                conn=DriverManager.getConnection(vars.getDB_Url(), vars.getDbUser(),vars.getDbPass());
                return conn;
            }catch(ClassNotFoundException | SQLException e){  
             e.printStackTrace();
            }
        
     return conn;   
    }
}
