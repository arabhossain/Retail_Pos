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

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author Loser
 */

public class Customerslist implements Serializable {

    private static final long serialVersionUID = 1L;

    private static Integer cSerial;
    private static String cID;
    private static String cName;
    private static String cMobile;
    private static String cEmail;
    private static String cFax;
    private static String cHouse;
    private static String cRoad;
    private static String cBlock;
    private static String cSection;
    private static String cArea;
    private static String cCity;
    private static String cVillageAddress;
    private static String cPhotoURL;
    private static Date cJoinDate;
    private static int cAddUserID;
    private static int cBrancID;
    
    /**
     *
     */
    public static String[] cNames;

    /**
     *
     */
    public static String[] cIDs;

    /**
     *
     */
    public Customerslist() {
    }

    /**
     *
     * @param cSerial
     */
    public Customerslist(Integer cSerial) {
        this.cSerial = cSerial;
    }

    /**
     *
     * @param cSerial
     * @param cID
     * @param cName
     * @param cMobile
     * @param cEmail
     * @param cFax
     * @param cHouse
     * @param cRoad
     * @param cBlock
     * @param cSection
     * @param cArea
     * @param cCity
     * @param cVillageAddress
     * @param cPhotoURL
     * @param cJoinDate
     * @param cAddUserID
     * @param cBrancID
     */
    public Customerslist(Integer cSerial, String cID, String cName, String cMobile, String cEmail, String cFax, String cHouse, String cRoad, String cBlock, String cSection, String cArea, String cCity, String cVillageAddress, String cPhotoURL, Date cJoinDate, int cAddUserID, int cBrancID) {
        this.cSerial = cSerial;
        this.cID = cID;
        this.cName = cName;
        this.cMobile = cMobile;
        this.cEmail = cEmail;
        this.cFax = cFax;
        this.cHouse = cHouse;
        this.cRoad = cRoad;
        this.cBlock = cBlock;
        this.cSection = cSection;
        this.cArea = cArea;
        this.cCity = cCity;
        this.cVillageAddress = cVillageAddress;
        this.cPhotoURL = cPhotoURL;
        this.cJoinDate = cJoinDate;
        this.cAddUserID = cAddUserID;
        this.cBrancID = cBrancID;
    }

    /**
     *
     * @return
     */
    public Integer getCSerial() {
        return cSerial;
    }

    /**
     *
     * @param cSerial
     */
    public void setCSerial(Integer cSerial) {
        this.cSerial = cSerial;
    }

    /**
     *
     * @return
     */
    public String getCID() {
        return cID;
    }

    /**
     *
     * @param cID
     */
    public void setCID(String cID) {
        this.cID = cID;
    }

    /**
     *
     * @return
     */
    public String getCName() {
        return cName;
    }

    /**
     *
     * @param cName
     */
    public void setCName(String cName) {
        this.cName = cName;
    }

    /**
     *
     * @return
     */
    public String getCMobile() {
        return cMobile;
    }

    /**
     *
     * @param cMobile
     */
    public void setCMobile(String cMobile) {
        this.cMobile = cMobile;
    }

    /**
     *
     * @return
     */
    public String getCEmail() {
        return cEmail;
    }

    /**
     *
     * @param cEmail
     */
    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    /**
     *
     * @return
     */
    public String getCFax() {
        return cFax;
    }

    /**
     *
     * @param cFax
     */
    public void setCFax(String cFax) {
        this.cFax = cFax;
    }

    /**
     *
     * @return
     */
    public String getCHouse() {
        return cHouse;
    }

    /**
     *
     * @param cHouse
     */
    public void setCHouse(String cHouse) {
        this.cHouse = cHouse;
    }

    /**
     *
     * @return
     */
    public String getCRoad() {
        return cRoad;
    }

    /**
     *
     * @param cRoad
     */
    public void setCRoad(String cRoad) {
        this.cRoad = cRoad;
    }

    /**
     *
     * @return
     */
    public String getCBlock() {
        return cBlock;
    }

    /**
     *
     * @param cBlock
     */
    public void setCBlock(String cBlock) {
        this.cBlock = cBlock;
    }

    /**
     *
     * @return
     */
    public String getCSection() {
        return cSection;
    }

    /**
     *
     * @param cSection
     */
    public void setCSection(String cSection) {
        this.cSection = cSection;
    }

    /**
     *
     * @return
     */
    public String getCArea() {
        return cArea;
    }

    /**
     *
     * @param cArea
     */
    public void setCArea(String cArea) {
        this.cArea = cArea;
    }

    /**
     *
     * @return
     */
    public String getCCity() {
        return cCity;
    }

    /**
     *
     * @param cCity
     */
    public void setCCity(String cCity) {
        this.cCity = cCity;
    }

    /**
     *
     * @return
     */
    public String getCVillageAddress() {
        return cVillageAddress;
    }

    /**
     *
     * @param cVillageAddress
     */
    public void setCVillageAddress(String cVillageAddress) {
        this.cVillageAddress = cVillageAddress;
    }

    /**
     *
     * @return
     */
    public String getCPhotoURL() {
        return cPhotoURL;
    }

    /**
     *
     * @param cPhotoURL
     */
    public void setCPhotoURL(String cPhotoURL) {
        this.cPhotoURL = cPhotoURL;
    }

    /**
     *
     * @return
     */
    public Date getCJoinDate() {
        return cJoinDate;
    }

    /**
     *
     * @param cJoinDate
     */
    public void setCJoinDate(Date cJoinDate) {
        this.cJoinDate = cJoinDate;
    }

    /**
     *
     * @return
     */
    public int getCAddUserID() {
        return cAddUserID;
    }

    /**
     *
     * @param cAddUserID
     */
    public void setCAddUserID(int cAddUserID) {
        this.cAddUserID = cAddUserID;
    }

    /**
     *
     * @return
     */
    public int getCBrancID() {
        return cBrancID;
    }

    /**
     *
     * @param cBrancID
     */
    public void setCBrancID(int cBrancID) {
        this.cBrancID = cBrancID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cSerial != null ? cSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customerslist)) {
            return false;
        }
        Customerslist other = (Customerslist) object;
        if ((this.cSerial == null && other.cSerial != null) || (this.cSerial != null && !this.cSerial.equals(other.cSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusniessObjects.Customerslist[ cSerial=" + cSerial + " ]";
    }
    
}
