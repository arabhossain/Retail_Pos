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
 * 
 */

public class Taxes implements Serializable {

    private static final long serialVersionUID = 1L;
    private static int taxID;
    private static String taxName;
    private static int taxValue;

    /**
     *
     */
    public static String[] taxNames;

    /**
     *
     */
    public Taxes() {
    }

    /**
     *
     * @param taxID
     */
    public Taxes(Integer taxID) {
        this.taxID = taxID;
    }

    /**
     *
     * @param taxID
     * @param taxName
     * @param taxValue
     */
    public Taxes(Integer taxID, String taxName, int taxValue) {
        this.taxID = taxID;
        this.taxName = taxName;
        this.taxValue = taxValue;
    }

    /**
     *
     * @return
     */
    public Integer getTaxID() {
        return taxID;
    }

    /**
     *
     * @param taxID
     */
    public void setTaxID(Integer taxID) {
        this.taxID = taxID;
    }

    /**
     *
     * @return
     */
    public String getTaxName() {
        return taxName;
    }

    /**
     *
     * @param taxName
     */
    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    /**
     *
     * @return
     */
    public int getTaxValue() {
        return taxValue;
    }

    /**
     *
     * @param taxValue
     */
    public void setTaxValue(int taxValue) {
        this.taxValue = taxValue;
    }
    
}
