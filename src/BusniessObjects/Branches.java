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

/**
 *
 * @author Loser
 */

public class Branches implements Serializable {

    private static final long serialVersionUID = 1L;

    private static Integer bID;
    private static String bName;
    private static String bAdressLine1;
    private static String bAdressLine2;
    private static int bHeadBranch;

    /**
     *
     */
    public static String[] bNames;

    /**
     *
     */
    public Branches() {
    }

    /**
     *
     * @param bID
     */
    public Branches(Integer bID) {
        this.bID = bID;
    }

    /**
     *
     * @param bID
     * @param bName
     * @param bAdressLine1
     * @param bAdressLine2
     * @param bHeadBranch
     */
    public Branches(Integer bID, String bName, String bAdressLine1, String bAdressLine2, int bHeadBranch) {
        this.bID = bID;
        this.bName = bName;
        this.bAdressLine1 = bAdressLine1;
        this.bAdressLine2 = bAdressLine2;
        this.bHeadBranch = bHeadBranch;
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
    public String getBAdressLine1() {
        return bAdressLine1;
    }

    /**
     *
     * @param bAdressLine1
     */
    public void setBAdressLine1(String bAdressLine1) {
        this.bAdressLine1 = bAdressLine1;
    }

    /**
     *
     * @return
     */
    public String getBAdressLine2() {
        return bAdressLine2;
    }

    /**
     *
     * @param bAdressLine2
     */
    public void setBAdressLine2(String bAdressLine2) {
        this.bAdressLine2 = bAdressLine2;
    }

    /**
     *
     * @return
     */
    public int getBHeadBranch() {
        return bHeadBranch;
    }

    /**
     *
     * @param bHeadBranch
     */
    public void setBHeadBranch(int bHeadBranch) {
        this.bHeadBranch = bHeadBranch;
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
        if (!(object instanceof Branches)) {
            return false;
        }
        Branches other = (Branches) object;
        if ((this.bID == null && other.bID != null) || (this.bID != null && !this.bID.equals(other.bID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusniessObjects.Branches[ bID=" + bID + " ]";
    }
    
}
