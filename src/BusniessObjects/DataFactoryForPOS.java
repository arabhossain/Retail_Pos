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

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Arab_Aka
 */
public class DataFactoryForPOS {
    private final SimpleIntegerProperty colNum;
    private final SimpleStringProperty colpID;
    private final SimpleStringProperty colName;
    private final SimpleDoubleProperty colQnty;
    private final SimpleDoubleProperty colTex;
    private final SimpleDoubleProperty colPrice;
    private final SimpleDoubleProperty colAmount;
    
    public DataFactoryForPOS(Integer colNum,String colpID,String colName,Double colQnty,Double colPrice,Double colTex,Double colAmount){
        this.colNum = new SimpleIntegerProperty(colNum); 
        this.colpID=new SimpleStringProperty(colpID);
        this.colName = new SimpleStringProperty(colName);
        this.colQnty = new SimpleDoubleProperty(colQnty);
        this.colTex = new SimpleDoubleProperty(colTex);
        this.colPrice = new SimpleDoubleProperty(colPrice);
        this.colAmount = new SimpleDoubleProperty(colAmount);
    }
    public Integer getColNum() {
        return colNum.get();
    }

    public void setColNum(Integer colNum) {
        this.colNum.set(colNum);
    }
     public String getColName() {
        return colpID.get();
    }

    public void setColpID(String colpID) {
        this.colpID.set(colpID);
    }
    public String getColpID() {
        return colName.get();
    }

    public void setColName(String colName) {
        this.colName.set(colName);
    }

    public Double getColQnty() {
        return colQnty.get();
    }

    public void setColQnty(Double colQnty) {
        this.colQnty.set(colQnty);
    }

    public Double getColTex() {
        return colTex.get();
    }

    public void setColTex(Double colTex) {
        this.colTex.set(colTex);
    }

    public Double getColPrice() {
        return colPrice.get();
    }

    public void setColPrice(Double colPrice) {
        this.colPrice.set(colPrice);
    }

    public Double getColAmount() {
        return colAmount.get();
    }

    public void setColAmount(Double colAmount) {
        this.colAmount.set(colAmount);
    }
   
}
