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
import java.math.BigInteger;
import java.util.Date;


/**
 *
 * @author Arab_Aka
 */

public class ViewProductslist implements Serializable {

    private static final long serialVersionUID = 1L;

   
    private int pListID;
    private String pID;
    private String pBarcode;
    private String pName;
    private String catName;
    private Double taxValue;
    private String pUniName;
    private double pSalePrice;
    private String pPhotoURL;
    private int pVisible;
    private Date pAddedDate;

    public ViewProductslist() {
    }
    public ViewProductslist(int pListID, String pID, String pBarcode, String pName, String catName, double taxValue, String pUniName, double pSalePrice, String pPhotoURL, int pVisible, Date pAddedDate) {
        this.pListID = pListID;
        this.pID = pID;
        this.pBarcode = pBarcode;
        this.pName = pName;
        this.catName = catName;
        this.taxValue = taxValue;
        this.pUniName = pUniName;
        this.pSalePrice = pSalePrice;
        this.pPhotoURL = pPhotoURL;
        this.pVisible = pVisible;
        this.pAddedDate = pAddedDate;
    }
   

    public int getPListID() {
        return pListID;
    }

    public void setPListID(int pListID) {
        this.pListID = pListID;
    }

    public String getPID() {
        return pID;
    }

    public void setPID(String pID) {
        this.pID = pID;
    }

    public String getPBarcode() {
        return pBarcode;
    }

    public void setPBarcode(String pBarcode) {
        this.pBarcode = pBarcode;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public double getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(double taxValue) {
        this.taxValue = taxValue;
    }

    public String getPUniName() {
        return pUniName;
    }

    public void setPUniName(String pUniName) {
        this.pUniName = pUniName;
    }

    public double getPSalePrice() {
        return pSalePrice;
    }

    public void setPSalePrice(double pSalePrice) {
        this.pSalePrice = pSalePrice;
    }

    public String getPPhotoURL() {
        return pPhotoURL;
    }

    public void setPPhotoURL(String pPhotoURL) {
        this.pPhotoURL = pPhotoURL;
    }

    public int getPVisible() {
        return pVisible;
    }

    public void setPVisible(int pVisible) {
        this.pVisible = pVisible;
    }

    public Date getPAddedDate() {
        return pAddedDate;
    }

    public void setPAddedDate(Date pAddedDate) {
        this.pAddedDate = pAddedDate;
    }
    
}
