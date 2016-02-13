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

public class Productcategories implements Serializable {

    private static final long serialVersionUID = 1L;

    private static Integer catID;
    private static String catName;
    private static String catPhotoURL;
    private static int catVisibile;

    /**
     *
     */
    public static String[] pCatNames;

    /**
     *
     */
    public static int[] pCatIDs;

    /**
     *
     */
    public static String[] pCatPhotoURLs;

    /**
     *
     */
    public Productcategories() {
    }

    /**
     *
     * @param catID
     */
    public Productcategories(Integer catID) {
        this.catID = catID;
    }

    /**
     *
     * @param catID
     * @param catName
     * @param catPhotoURL
     * @param catVisibile
     */
    public Productcategories(Integer catID, String catName, String catPhotoURL, int catVisibile) {
        this.catID = catID;
        this.catName = catName;
        this.catPhotoURL = catPhotoURL;
        this.catVisibile = catVisibile;
    }

    /**
     *
     * @return
     */
    public Integer getCatID() {
        return catID;
    }

    /**
     *
     * @param catID
     */
    public void setCatID(Integer catID) {
        this.catID = catID;
    }

    /**
     *
     * @return
     */
    public String getCatName() {
        return catName;
    }

    /**
     *
     * @param catName
     */
    public void setCatName(String catName) {
        this.catName = catName;
    }

    /**
     *
     * @return
     */
    public String getCatPhotoURL() {
        return catPhotoURL;
    }

    /**
     *
     * @param catPhotoURL
     */
    public void setCatPhotoURL(String catPhotoURL) {
        this.catPhotoURL = catPhotoURL;
    }

    /**
     *
     * @return
     */
    public int getCatVisibile() {
        return catVisibile;
    }

    /**
     *
     * @param catVisibile
     */
    public void setCatVisibile(int catVisibile) {
        this.catVisibile = catVisibile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catID != null ? catID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productcategories)) {
            return false;
        }
        Productcategories other = (Productcategories) object;
        if ((this.catID == null && other.catID != null) || (this.catID != null && !this.catID.equals(other.catID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusniessObjects.Productcategories[ catID=" + catID + " ]";
    }
    
}
