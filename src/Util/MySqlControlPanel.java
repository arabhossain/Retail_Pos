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
package Util;

/**
 *
 * @author Loser
 */
public class MySqlControlPanel {
    //Controls

    /**
     *
     */
    public static void ApacheStart(){
            String code=XmappRootFolderURL+"/apache/bin/httpd.exe";
            String Message="Apache has started. Now you can browse throw desktop browser of local hosted web sites...";
            try{
                CMD.runAsCMD(code, Message);
                ApacheActive=true;
            }
            catch(Exception e){}    
        }

    /**
     *
     */
    public static void ApacheStop(){
            String code=XmappRootFolderURL+"/apache/bin/pv -f -k httpd.exe -q";
            String Message="Apache has stoped...";
             try{
                CMD.runAsCMD(code, Message);
                ApacheActive=false;
            }
            catch(Exception e){}
        }

    /**
     *
     */
    public static void MySqlStart(){
            String code=XmappRootFolderURL+"/mysql\\bin\\mysqld --defaults-file="+XmappRootFolderURL+"/mysql\\bin\\my.ini --standalone";
            String Message="MySql database has runed through apache web server...";
             try{
                CMD.runAsCMD(code, Message);
                MysqlActive=true;
            }
            catch(Exception e){} 
     }

    /**
     *
     */
    public static void MySqlStop(){
            String code=XmappRootFolderURL+"/apache//bin//pv -f -k mysqld.exe -q";
            String Message="MySql database service has stopped...";
            try{
                CMD.runAsCMD(code, Message);
                MysqlActive=false;
            }
            catch(Exception e){}
     }
    
    
    //Getter Setter methods...

    /**
     *
     * @return
     */
    public static String getXmappRootFolderURL() {
        return XmappRootFolderURL;
    }

    /**
     *
     * @param XmappRootFolderURL
     */
    public static void setXmappRootFolderURL(String XmappRootFolderURL) {
        MySqlControlPanel.XmappRootFolderURL = XmappRootFolderURL;
    }

    /**
     *
     * @return
     */
    public static boolean isMysqlActive() {
        return MysqlActive;
    }

    /**
     *
     * @return
     */
    public static boolean isApacheActive() {
        return ApacheActive;
    }
    
    //Variables
    private static String XmappRootFolderURL="D:/xampp";
    private static boolean MysqlActive=false;
    private static boolean ApacheActive=false;

}
