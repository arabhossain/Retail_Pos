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

public class Breaks implements Serializable {

   
    private static Integer bID;
    private static String bName;
    private static int bVisibility;
    private static String bNote;
    private static Date bCreatedDate;
    private static String bTime;

    public String getBTime() {
        return bTime;
    }

    public void setBTime(String bTime) {
        Breaks.bTime = bTime;
    }
    
    /**
     *
     */
    public static int[] bIDs;

    /**
     *
     */
    public static String[] bNames;
    
    /**
     *
     */
    public Breaks() {
    }

    /**
     *
     * @param bID
     */
    public Breaks(Integer bID) {
        this.bID = bID;
    }

    /**
     *
     * @param bID
     * @param bName
     * @param bVisibility
     * @param bNote
     * @param bCreatedDate
     */
    public Breaks(Integer bID, String bName, int bVisibility,String bTime, String bNote, Date bCreatedDate) {
        this.bID = bID;
        this.bName = bName;
        this.bVisibility = bVisibility;
        this.bTime=bTime;
        this.bNote = bNote;
        this.bCreatedDate = bCreatedDate;
    }

    /**
     *
     * @return
     */
    public Integer getBID() {
        return bID;
    }

    /**
     *
     * @param bID
     */
    public void setBID(Integer bID) {
        this.bID = bID;
    }

    /**
     *
     * @return
     */
    public String getBName() {
        return bName;
    }

    /**
     *
     * @param bName
     */
    public void setBName(String bName) {
        this.bName = bName;
    }

    /**
     *
     * @return
     */
    public int getBVisibility() {
        return bVisibility;
    }

    /**
     *
     * @param bVisibility
     */
    public void setBVisibility(int bVisibility) {
        this.bVisibility = bVisibility;
    }

    /**
     *
     * @return
     */
    public String getBNote() {
        return bNote;
    }

    /**
     *
     * @param bNote
     */
    public void setBNote(String bNote) {
        this.bNote = bNote;
    }

    /**
     *
     * @return
     */
    public Date getBCreatedDate() {
        return bCreatedDate;
    }

    /**
     *
     * @param bCreatedDate
     */
    public void setBCreatedDate(Date bCreatedDate) {
        this.bCreatedDate = bCreatedDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bID != null ? bID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Breaks)) {
            return false;
        }
        Breaks other = (Breaks) object;
        if ((this.bID == null && other.bID != null) || (this.bID != null && !this.bID.equals(other.bID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusniessObjects.Breaks[ bID=" + bID + " ]";
    }
    
}
