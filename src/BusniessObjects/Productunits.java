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

public class Productunits implements Serializable {

    private static final long serialVersionUID = 1L;

    private static Integer pUniID;
    private static String pUniName;
    
    /**
     *
     */
    public static String[] pUnitNames;

    /**
     *
     */
    public Productunits() {
    }

    /**
     *
     * @param pUniID
     */
    public Productunits(Integer pUniID) {
        this.pUniID = pUniID;
    }

    /**
     *
     * @param pUniID
     * @param pUniName
     */
    public Productunits(Integer pUniID, String pUniName) {
        this.pUniID = pUniID;
        this.pUniName = pUniName;
    }

    /**
     *
     * @return
     */
    public Integer getPUniID() {
        return pUniID;
    }

    /**
     *
     * @param pUniID
     */
    public void setPUniID(Integer pUniID) {
        this.pUniID = pUniID;
    }

    /**
     *
     * @return
     */
    public String getPUniName() {
        return pUniName;
    }

    /**
     *
     * @param pUniName
     */
    public void setPUniName(String pUniName) {
        this.pUniName = pUniName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pUniID != null ? pUniID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productunits)) {
            return false;
        }
        Productunits other = (Productunits) object;
        if ((this.pUniID == null && other.pUniID != null) || (this.pUniID != null && !this.pUniID.equals(other.pUniID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusniessObjects.Productunits[ pUniID=" + pUniID + " ]";
    }
    
}
