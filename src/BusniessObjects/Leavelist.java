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

public class Leavelist implements Serializable {


    private static Integer lID;
    private static int lStuffID;
    private static String lReasion;
    private static Date lStartDate;
    private static Date lEndDate;
    private static int lRequestStuffID;
    private static int lApproved;
    private static Date lRequestSeenAt;
    private static Date lRequestTime;
    
    /**
     *
     */
    public static String[] StartEnds;

    /**
     *
     */
    public static int[] LIDs;
   
    /**
     *
     */
    public Leavelist() {
    }

    /**
     *
     * @param lID
     */
    public Leavelist(Integer lID) {
        this.lID = lID;
    }

    /**
     *
     * @param lID
     * @param lStuffID
     * @param lReasion
     * @param lStartDate
     * @param lEndDate
     * @param lRequestStuffID
     * @param lApproved
     * @param lRequestSeenAt
     * @param lRequestTime
     */
    public Leavelist(Integer lID, int lStuffID, String lReasion, Date lStartDate, Date lEndDate, int lRequestStuffID, int lApproved, Date lRequestSeenAt,Date lRequestTime) {
        this.lID = lID;
        this.lStuffID = lStuffID;
        this.lReasion = lReasion;
        this.lStartDate = lStartDate;
        this.lEndDate = lEndDate;
        this.lRequestStuffID = lRequestStuffID;
        this.lApproved = lApproved;
        this.lRequestSeenAt = lRequestSeenAt;
        this.lRequestTime=lRequestTime;
    }

    /**
     *
     * @return
     */
    public Integer getLID() {
        return lID;
    }

    /**
     *
     * @param lID
     */
    public void setLID(Integer lID) {
        this.lID = lID;
    }

    /**
     *
     * @return
     */
    public int getLStuffID() {
        return lStuffID;
    }

    /**
     *
     * @param lStuffID
     */
    public void setLStuffID(int lStuffID) {
        this.lStuffID = lStuffID;
    }

    /**
     *
     * @return
     */
    public String getLReasion() {
        return lReasion;
    }

    /**
     *
     * @param lReasion
     */
    public void setLReasion(String lReasion) {
        this.lReasion = lReasion;
    }

    /**
     *
     * @return
     */
    public Date getLStartDate() {
        return lStartDate;
    }

    /**
     *
     * @param lStartDate
     */
    public void setLStartDate(Date lStartDate) {
        this.lStartDate = lStartDate;
    }

    /**
     *
     * @return
     */
    public Date getLEndDate() {
        return lEndDate;
    }

    /**
     *
     * @param lEndDate
     */
    public void setLEndDate(Date lEndDate) {
        this.lEndDate = lEndDate;
    }

    /**
     *
     * @return
     */
    public int getLRequestStuffID() {
        return lRequestStuffID;
    }

    /**
     *
     * @param lRequestStuffID
     */
    public void setLRequestStuffID(int lRequestStuffID) {
        this.lRequestStuffID = lRequestStuffID;
    }

    /**
     *
     * @return
     */
    public int getLApproved() {
        return lApproved;
    }

    /**
     *
     * @param lApproved
     */
    public void setLApproved(int lApproved) {
        this.lApproved = lApproved;
    }

    /**
     *
     * @return
     */
    public Date getLRequestSeenAt() {
        return lRequestSeenAt;
    }

    /**
     *
     * @param lRequestSeenAt
     */
    public void setLRequestSeenAt(Date lRequestSeenAt) {
        this.lRequestSeenAt = lRequestSeenAt;
    }

    /**
     *
     * @return
     */
    public Date getlRequestTime() {
        return lRequestTime;
    }

    /**
     *
     * @param lRequestTime
     */
    public void setlRequestTime(Date lRequestTime) {
        this.lRequestTime = lRequestTime;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lID != null ? lID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Leavelist)) {
            return false;
        }
        Leavelist other = (Leavelist) object;
        if ((this.lID == null && other.lID != null) || (this.lID != null && !this.lID.equals(other.lID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusniessObjects.Leavelist[ lID=" + lID + " ]";
    }
    
}
