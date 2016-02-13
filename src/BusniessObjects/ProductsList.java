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

public class ProductsList implements Serializable {

    private static final long serialVersionUID = 1L;

    private static Integer pListID;
    private static String pID;
    private static String pBarcode;
    private static String pName;
    private static int pCatID;
    private static int pTaxID;
    private static int pUnitID;
    private static double pSalePrice;
    private static String pPhotoURL;
    private static int pVisible;
    private static int pAdminViewed;
    
    /**
     *
     */
    public static String[] pLists;

    /**
     *
     */
    public static String[] pIDs;

    /**
     *
     */
    public static String[] pIconList;
    public static String[] pPrice;
    /**
     *
     */
    public ProductsList() {
    }

    /**
     *
     * @param pListID
     */
    public ProductsList(Integer pListID) {
        this.pListID = pListID;
    }

    /**
     *
     * @param pListID
     * @param pID
     * @param pBarcode
     * @param pName
     * @param pCatID
     * @param pTaxID
     * @param pUnitID
     * @param pSalePrice
     * @param pPhotoURL
     * @param pVisible
     * @param pAdminViewed
     */
    public ProductsList(Integer pListID,String pID, String pBarcode, String pName, int pCatID, int pTaxID, int pUnitID, double pSalePrice, String pPhotoURL, int pVisible,  int pAdminViewed) {
        
        this.pListID = pListID;
        this.pID=pID;
        this.pBarcode = pBarcode;
        this.pName = pName;
        this.pCatID = pCatID;
        this.pTaxID = pTaxID;
        this.pUnitID = pUnitID;
        this.pSalePrice = pSalePrice;
        this.pPhotoURL = pPhotoURL;
        this.pVisible = pVisible;
        this.pAdminViewed = pAdminViewed;
    }

    /**
     *
     */
    public void setnull(){
         this.pListID = null;
        this.pID=null;
        this.pBarcode = null;
        this.pName = null;
        this.pCatID = 0;
        this.pTaxID = 0;
        this.pUnitID = 0;
        this.pSalePrice = 0;

    }

    /**
     *
     * @return
     */
    public Integer getPListID() {
        return pListID;
    }

    /**
     *
     * @param pListID
     */
    public void setPListID(Integer pListID) {
        this.pListID = pListID;
    }

    /**
     *
     * @return
     */
    public String getpID() {
        return pID;
    }

    /**
     *
     * @param pID
     */
    public void setpID(String pID) {
        this.pID = pID;
    }

    /**
     *
     * @return
     */
    public String getPBarcode() {
        return pBarcode;
    }

    /**
     *
     * @param pBarcode
     */
    public void setPBarcode(String pBarcode) {
        this.pBarcode = pBarcode;
    }

    /**
     *
     * @return
     */
    public String getPName() {
        return pName;
    }

    /**
     *
     * @param pName
     */
    public void setPName(String pName) {
        this.pName = pName;
    }

    /**
     *
     * @return
     */
    public int getPCatID() {
        return pCatID;
    }

    /**
     *
     * @param pCatID
     */
    public void setPCatID(int pCatID) {
        this.pCatID = pCatID;
    }

    /**
     *
     * @return
     */
    public int getPTaxID() {
        return pTaxID;
    }

    /**
     *
     * @param pTaxID
     */
    public void setPTaxID(int pTaxID) {
        this.pTaxID = pTaxID;
    }

    /**
     *
     * @return
     */
    public int getPUnitID() {
        return pUnitID;
    }

    /**
     *
     * @param pUnitID
     */
    public void setPUnitID(int pUnitID) {
        this.pUnitID = pUnitID;
    }

    /**
     *
     * @return
     */
    public double getPSalePrice() {
        return pSalePrice;
    }

    /**
     *
     * @param pSalePrice
     */
    public void setPSalePrice(double pSalePrice) {
        this.pSalePrice = pSalePrice;
    }

    /**
     *
     * @return
     */
    public String getPPhotoURL() {
        return pPhotoURL;
    }

    /**
     *
     * @param pPhotoURL
     */
    public void setPPhotoURL(String pPhotoURL) {
        this.pPhotoURL = pPhotoURL;
    }

    /**
     *
     * @return
     */
    public int getPVisible() {
        return pVisible;
    }

    /**
     *
     * @param pVisible
     */
    public void setPVisible(int pVisible) {
        this.pVisible = pVisible;
    }

    /**
     *
     * @return
     */
    public int getPAdminViewed() {
        return pAdminViewed;
    }

    /**
     *
     * @param pAdminViewed
     */
    public void setPAdminViewed(int pAdminViewed) {
        this.pAdminViewed = pAdminViewed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pListID != null ? pListID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductsList)) {
            return false;
        }
        ProductsList other = (ProductsList) object;
        if ((this.pListID == null && other.pListID != null) || (this.pListID != null && !this.pListID.equals(other.pListID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusniessObjects.Productslist[ pListID=" + pListID + " ]";
    }
    
}
