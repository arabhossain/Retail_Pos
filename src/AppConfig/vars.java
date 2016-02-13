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

/**
 *
 * @author Loser
 */
public class vars {

    /**
     *
     */
    public final static String APP_VERSION="RETAIL v1.01";
    //Local Database Controlar variables 
     private static String DRIVER_Type;
     private static String JDBC_DRIVER;
     private static String DB_Url;
     private static String DbName;
     private static String DbUser;
     private static String DbPass;

   

    //Online Database Controller Variable
    private static String CloudIP;
    private static String CloudPort;
    private static String CloudDatabaseName;
    private static String CloudUser;
    private static String CloudPass;
    
    //Get Shop Information
    private static String ShopName;
    private static int BranchID;
    private static String MoneySymble;

    /**
     *
     * @return
     */
    public static String getShopName() {
        return ShopName;
    }

    /**
     *
     * @param ShopName
     */
    public static void setShopName(String ShopName) {
        vars.ShopName = ShopName;
    }

    /**
     *
     * @return
     */
    public static int getBranchID() {
        return BranchID;
    }

    /**
     *
     * @param BranchID
     */
    public static void setBranchID(int BranchID) {
        vars.BranchID = BranchID;
    }

    /**
     *
     * @return
     */
    public static String getMoneySymble() {
        return MoneySymble;
    }

    /**
     *
     * @param MoneySymble
     */
    public static void setMoneySymble(String MoneySymble) {
        vars.MoneySymble = MoneySymble;
    }

    
    //Getter Setter for Local Database Variables
    
    /**
     *
     * @return
     */
    public static String getDRIVER_Type() {
        return DRIVER_Type;
    }

    /**
     *
     * @param DRIVER_Type
     */
    public static void setDRIVER_Type(String DRIVER_Type) {
        vars.DRIVER_Type = DRIVER_Type;
    }
     
    /**
     *
     * @return
     */
    public static String getJDBC_DRIVER() {
        return JDBC_DRIVER;
    }

    /**
     *
     * @param JDBC_DRIVER
     */
    public static void setJDBC_DRIVER(String JDBC_DRIVER) {
        vars.JDBC_DRIVER = JDBC_DRIVER;
    }

    /**
     *
     * @return
     */
    public static String getDB_Url() {
        return DB_Url;
    }

    /**
     *
     * @param DB_Url
     */
    public static void setDB_Url(String DB_Url) {
        vars.DB_Url = DB_Url;
    } 
    
    /**
     *
     * @return
     */
    public static String getDbName() {
        return DbName;
    }

    /**
     *
     * @param DbName
     */
    public static void setDbName(String DbName) {
        vars.DbName = DbName;
    }

    /**
     *
     * @return
     */
    public static String getDbUser() {
        return DbUser;
    }

    /**
     *
     * @param DbUser
     */
    public static void setDbUser(String DbUser) {
        vars.DbUser = DbUser;
    }

    /**
     *
     * @return
     */
    public static String getDbPass() {
        return DbPass;
    }

    /**
     *
     * @param DbPass
     */
    public static void setDbPass(String DbPass) {
        vars.DbPass = DbPass;
    }
 
    //Getter Setter for Cloud Vairables

    /**
     *
     * @return
     */
     public static String getCloudIP() {
        return CloudIP;
    }

    /**
     *
     * @param CloudIP
     */
    public static void setCloudIP(String CloudIP) {
        vars.CloudIP = CloudIP;
    }

    /**
     *
     * @return
     */
    public static String getCloudPort() {
        return CloudPort;
    }

    /**
     *
     * @param CloudPort
     */
    public static void setCloudPort(String CloudPort) {
        vars.CloudPort = CloudPort;
    }

    /**
     *
     * @return
     */
    public static String getCloudDatabaseName() {
        return CloudDatabaseName;
    }

    /**
     *
     * @param CloudDatabaseName
     */
    public static void setCloudDatabaseName(String CloudDatabaseName) {
        vars.CloudDatabaseName = CloudDatabaseName;
    }

    /**
     *
     * @return
     */
    public static String getCloudUser() {
        return CloudUser;
    }

    /**
     *
     * @param CloudUser
     */
    public static void setCloudUser(String CloudUser) {
        vars.CloudUser = CloudUser;
    }

    /**
     *
     * @return
     */
    public static String getCloudPass() {
        return CloudPass;
    }

    /**
     *
     * @param CloudPass
     */
    public static void setCloudPass(String CloudPass) {
        vars.CloudPass = CloudPass;
    }

    /**
     *
     */
    public final static javafx.scene.image.Image noImage=FileIOService.LoadImage.from_images("nophoto.png");
    //File IO Service packages variables
    private static String Content;
    private static String fileName;
    private static String DIR_URL="./Data/";

    /**
     *
     * @return
     */
    public static String getDIR_URL() {
        return DIR_URL;
    }

    /**
     *
     * @param DIR_URL
     */
    public static void setDIR_URL(String DIR_URL) {
        vars.DIR_URL = DIR_URL;
    }

    /**
     *
     * @return
     */
    public static String getContent() {
        return Content;
    }

    /**
     *
     * @param Content
     */
    public static void setContent(String Content) {
        vars.Content = Content;
    }

    /**
     *
     * @return
     */
    public static String getFileName() {
        return fileName;
    }

    /**
     *
     * @param fileName
     */
    public static void setFileName(String fileName) {
        vars.fileName = fileName;
    }

}
