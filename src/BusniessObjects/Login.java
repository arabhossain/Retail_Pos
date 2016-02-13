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
package BusniessObjects;

import DataAccessLayer.LoginDAL;

/**
 *
 * @author Loser
 */
public class Login {

    /**
     *
     * @return
     */
    public int getUserType() {
        return userType;
    }

    /**
     *
     * @param userType
     */
    public void setUserType(int userType) {
        this.userType = userType;
    }

    /**
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password =password;
    }

    /**
     *
     * @return
     */
    public String getPhotoURL() {
        return PhotoURL;
    }

    /**
     *
     * @param PhotoURL
     */
    public void setPhotoURL(String PhotoURL) {
        Login.PhotoURL = PhotoURL;
    }

    /**
     *
     * @return
     */
    public int getAccountStatus() {
        return accountStatus;
    }

    /**
     *
     * @param accountStatus
     */
    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }    

    /**
     *
     * @return
     */
    public int getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     *
     */
    public static void sessionOut(){
             LoginDAL loin=new LoginDAL();
             loin.setUserAsOffilne();
        
             userType = 0;
             userId=0;

             userName=null;
             password=null;
             PhotoURL=null;
             accountStatus=0;
             UserBranch=0;

    }
    private static int userType = 0;
    private static int userId;

    private static String userName;
    private static String password;
    private static String PhotoURL;
    private static int accountStatus;
    private static int UserBranch;

    /**
     *
     * @return
     */
    public int getUserBranch() {
        return UserBranch;
    }

    /**
     *
     * @param UserBranch
     */
    public void setUserBranch(int UserBranch) {
        this.UserBranch = UserBranch;
    }

}
