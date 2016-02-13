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

public class Pricechangelog implements Serializable {

    private static Integer pCLID;
    private static String pPID;
    private static double pPreviousPrice;
    private static double pChagedPrice;
    private static int pUserID;
    private static Date pChangedDate;

    /**
     *
     */
    public Pricechangelog() {
    }

    /**
     *
     * @param pCLID
     */
    public Pricechangelog(Integer pCLID) {
        this.pCLID = pCLID;
    }

    /**
     *
     * @param pCLID
     * @param pPID
     * @param pPreviousPrice
     * @param pChagedPrice
     * @param pUserID
     * @param pChangedDate
     */
    public Pricechangelog(Integer pCLID, String pPID, double pPreviousPrice, double pChagedPrice, int pUserID, Date pChangedDate) {
        this.pCLID = pCLID;
        this.pPID = pPID;
        this.pPreviousPrice = pPreviousPrice;
        this.pChagedPrice = pChagedPrice;
        this.pUserID = pUserID;
        this.pChangedDate = pChangedDate;
    }

    /**
     *
     * @return
     */
    public Integer getPCLID() {
        return pCLID;
    }

    /**
     *
     * @param pCLID
     */
    public void setPCLID(Integer pCLID) {
        this.pCLID = pCLID;
    }

    /**
     *
     * @return
     */
    public String getPPID() {
        return pPID;
    }

    /**
     *
     * @param pPID
     */
    public void setPPID(String pPID) {
        this.pPID = pPID;
    }

    /**
     *
     * @return
     */
    public double getPPreviousPrice() {
        return pPreviousPrice;
    }

    /**
     *
     * @param pPreviousPrice
     */
    public void setPPreviousPrice(double pPreviousPrice) {
        this.pPreviousPrice = pPreviousPrice;
    }

    /**
     *
     * @return
     */
    public double getPChagedPrice() {
        return pChagedPrice;
    }

    /**
     *
     * @param pChagedPrice
     */
    public void setPChagedPrice(double pChagedPrice) {
        this.pChagedPrice = pChagedPrice;
    }

    /**
     *
     * @return
     */
    public int getPUserID() {
        return pUserID;
    }

    /**
     *
     * @param pUserID
     */
    public void setPUserID(int pUserID) {
        this.pUserID = pUserID;
    }

    /**
     *
     * @return
     */
    public Date getPChangedDate() {
        return pChangedDate;
    }

    /**
     *
     * @param pChangedDate
     */
    public void setPChangedDate(Date pChangedDate) {
        this.pChangedDate = pChangedDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pCLID != null ? pCLID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pricechangelog)) {
            return false;
        }
        Pricechangelog other = (Pricechangelog) object;
        if ((this.pCLID == null && other.pCLID != null) || (this.pCLID != null && !this.pCLID.equals(other.pCLID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusniessObjects.Pricechangelog[ pCLID=" + pCLID + " ]";
    }
    
}
