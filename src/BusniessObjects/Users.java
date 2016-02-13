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

import java.util.Date;

/**
 *
 * @author Loser
 */
public class Users {

    /**
     *
     * @return
     */
    public String getFullName() {
        return FullName;
    }

    /**
     *
     * @param FullName
     */
    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    /**
     *
     * @return
     */
    public String getUserName() {
        return UserName;
    }

    /**
     *
     * @param UserName
     */
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    /**
     *
     * @return
     */
    public String getMobile() {
        return Mobile;
    }

    /**
     *
     * @param Mobile
     */
    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return Address;
    }

    /**
     *
     * @param Address
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     *
     * @return
     */
    public int getRoled() {
        return Roled;
    }

    /**
     *
     * @param Roled
     */
    public void setRoled(int Roled) {
        this.Roled = Roled;
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
        this.PhotoURL = PhotoURL;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return Password;
    }

    /**
     *
     * @param Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     *
     * @return
     */
    public Date getLastActivity() {
        return LastActivity;
    }

    /**
     *
     * @param LastActivity
     */
    public void setLastActivity(Date LastActivity) {
        this.LastActivity = LastActivity;
    }

    /**
     *
     * @return
     */
    public int isAccoutStatus() {
        return AccoutStatus;
    }

    /**
     *
     * @param AccoutStatus
     */
    public void setAccoutStatus(int AccoutStatus) {
        this.AccoutStatus = AccoutStatus;
    }

    /**
     *
     * @return
     */
    public int isIsOnline() {
        return IsOnline;
    }

    /**
     *
     * @param IsOnline
     */
    public void setIsOnline(int IsOnline) {
        this.IsOnline = IsOnline;
    }
    
    /**
     *
     * @return
     */
    public int getBranchID() {
        return BranchID;
    }

    /**
     *
     * @param BranchID
     */
    public void setBranchID(int BranchID) {
        this.BranchID = BranchID;
    }
    
    
    private static String FullName;
    private static String UserName;
    private static String Mobile;
    private static String Address;
    private static int Roled;
    private static String PhotoURL=null;
    private static String Password;
    private static Date LastActivity;
    private static int AccoutStatus;
    private static int IsOnline;
    private static int BranchID;

    /**
     *
     */
    public static String[] usernames;

  
}
