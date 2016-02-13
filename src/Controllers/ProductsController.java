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
package Controllers;

import AppConfig.Chooser;
import AppConfig.Notify;
import AppConfig.vars;
import BusniessObjects.Login;
import BusniessObjects.Pricechangelog;
import BusniessObjects.Productcategories;
import BusniessObjects.ProductsList;
import BusniessObjects.Productunits;
import BusniessObjects.Taxes;
import DataAccessLayer.PricechangelogDAL;
import DataAccessLayer.ProductcategoriesDAL;
import DataAccessLayer.ProductsListDAL;
import DataAccessLayer.ProductunitsDAL;
import DataAccessLayer.TaxesDAL;
import FileIOService.Delete;
import FileIOService.LoadImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Loser
 */
public class ProductsController implements Initializable {
    @FXML private TextField txtSearchByName,txt_pID,txtBarcode,txtName,txtSalePrice;
    @FXML private ComboBox comboSearchByCat;
    @FXML private ChoiceBox comboCat,comboTax,comboUnit;
    @FXML private Label lblTotalPrice,lblMoneySymble;
    @FXML private CheckBox checkVisible;
    @FXML  private ImageView photoProduct;
    @FXML private ListView listView;
    @FXML private ProgressBar progsFindbyBarcode;
    
    
    ProductsList pList=new ProductsList();
    ProductsListDAL pListDAL=new ProductsListDAL();
    ProductcategoriesDAL pCatDAL =new ProductcategoriesDAL();
    TaxesDAL taxDAL=new TaxesDAL();
    ProductunitsDAL pUnitDAL=new ProductunitsDAL();
    Login login=new Login();
    
    private String imgSourceURL=null;
    private String imgSaveURL=null;
    private String tempImgURL=null;
    private String SelectedItem;
    private String tempPID;
    private String ActionType="save";
    private String photoActionType="old";
    private Double tempPrice;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         AppConfig.Config.setTitle("Product");
            Sync();
            this.comboSearchByCat.getItems().clear();
            comboSearchByCat.getItems().add("All View");
            for(int i=0;i<Productcategories.pCatNames.length;i++){
                    comboSearchByCat.getItems().add(Productcategories.pCatNames[i]);
            }
    }
    @FXML private void btnFindByBarcode(ActionEvent e){
        this.progsFindbyBarcode.setVisible(true);
    }
    @FXML private void SearchByName(KeyEvent e){
        if(!this.txtSearchByName.getText().equals("")){
            pListDAL.getFilterProducts(0, this.txtSearchByName.getText());
        }else if(this.txtSearchByName.getText().equals("")){
            pListDAL.getProductsNames();
        }
        listView.getItems().clear();
        for(int i=0;i<ProductsList.pLists.length;i++){
            listView.getItems().add(ProductsList.pLists[i]);
        }
    }
    
    @FXML private void SearchByPCat(MouseEvent e){
        comboSearchByCat.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> observable,String  
                oldValue,String newValue) 
                {
                     if(newValue==null){
                return;
                }
                if(newValue!=null && !newValue.equals("All View")){
                   pListDAL.getFilterProducts(pCatDAL.getpCatIdByName(newValue),null);
               }else if(newValue.equals("All View")){
                   pListDAL.getProductsNames();
               }
               listView.getItems().clear();
               for(int i=0;i<ProductsList.pLists.length;i++){
                   listView.getItems().add(ProductsList.pLists[i]);
               }
            }   
        });
       
    }
    @FXML private void btnRreadCode(ActionEvent e){
        this.txtBarcode.setText("testBarcode");
    }
    @FXML private void btnAddNewProduct(ActionEvent e){
         setNull();
    }
    @FXML private void btnDeleteProduct(ActionEvent e){
       
       if(Notify.toConfirmPane("Please Make sure you want to delete this user.", "Are you sure to delete")){
           //Do if pressed YES option from the confirm dilog box
           if(pListDAL.deleteBypID(tempPID) && SelectedItem!=null){
               if(!tempImgURL.equals("/images/productes.png")) {
                new Delete(tempImgURL,"","");   
               }
                AfterAction();
                return;
           }else Notify.toAlartPane("Please Select a name from the list and try again!");
       }else{
           // Do what if user pressed the cencel button
           return;
       }
    }
    @FXML private void btnAddPhoto(ActionEvent e){
         imgSourceURL=null;
        imgSourceURL=Chooser.getImageFile("Select Product Image");
        
        imgSaveURL="./img/products/"+this.txtName.getText()+"_"+new File(imgSourceURL).getName();
        this.photoProduct.setImage(LoadImage.getImage(imgSourceURL));
        if(imgSourceURL!=null){
             photoActionType="new";
        }else if(imgSourceURL==null){
            photoActionType="old";
        }
    }
    @FXML private void btnSaveInfo(ActionEvent e){
         if(ActionType.equals("save")){
            save_data();
        }else if(ActionType.equals("edit")){
            edit_data();
        }
    }
    @FXML private void listClicked(MouseEvent e){
         setNull();
         SelectedItem=listView.getFocusModel().getFocusedItem().toString();
         if(pListDAL.getProductBy(null,null,SelectedItem)){
             setData();
             ActionType="edit";
         }
    }
    @FXML private void getTotalPrice(KeyEvent e){
        double UperTemp=0;
        try{
            UperTemp=Double.parseDouble(this.txtSalePrice.getText());
        }catch(NumberFormatException ev){
            this.lblTotalPrice.setText("");
            return;
        }
        double tax=taxDAL.getpTaxValueByName(this.comboTax.getValue().toString());
        this.lblTotalPrice.setText(String.valueOf(UperTemp+((tax*UperTemp)/100))+" "+vars.getMoneySymble());
    }
    
    

    //Do whatever you want... :p 
    private void Sync(){
        lblMoneySymble.setText(vars.getMoneySymble());
         if(pListDAL.getProductsNames()){
            listView.getItems().clear();
            for(int i=0;i<ProductsList.pLists.length;i++){
                    listView.getItems().add(ProductsList.pLists[i]);
                  } 
        }
        if(pCatDAL.SelectCatNames()){
            this.comboCat.getItems().clear();
            
            for(int i=0;i<Productcategories.pCatNames.length;i++){
                    comboCat.getItems().add(Productcategories.pCatNames[i]);
                  } 
        }
        if(taxDAL.getTaxNames()){
            this.comboTax.getItems().clear();
            for(int i=0;i< Taxes.taxNames.length;i++){
                    comboTax.getItems().add( Taxes.taxNames[i]);
                  } 
        }
        if(pUnitDAL.getUnitNames()){
            this.comboUnit.getItems().clear();
            for(int i=0;i< Productunits.pUnitNames.length;i++){
                    comboUnit.getItems().add( Productunits.pUnitNames[i]);
                  } 
        }
       progsFindbyBarcode.setVisible(false);
      this.txt_pID.setText(genarateProductID());
      this.txt_pID.setEditable(false);
    }
    
    private String genarateProductID(){
        return "PD"+String.valueOf(pListDAL.getLastProductID()+1)+""+String.valueOf(login.getUserId())+""+vars.getBranchID();
    }
     private void save_data(){
        getData();
        if(pListDAL.insert()){
            if(photoActionType.equals("new")){
                    if(LoadImage.SavedImage(imgSourceURL, this.imgSaveURL)){
                         JOptionPane.showMessageDialog(null, "Data saved");
                          AfterAction();
                    }
                }else if(photoActionType.equals("old")){
                    JOptionPane.showMessageDialog(null, "Data saved with default image");
                    AfterAction();
                }
        }else  JOptionPane.showMessageDialog(null,"Not done");
    }
        Pricechangelog pLog=new Pricechangelog();
        PricechangelogDAL pLogDAL=new PricechangelogDAL();
    private void edit_data(){
         getData();
        if(pListDAL.update(tempPID)){
            if(tempPrice!=Double.parseDouble(this.txtSalePrice.getText())){
                pLog.setPPID(tempPID);
                pLog.setPChagedPrice(Double.parseDouble(this.txtSalePrice.getText()));
                pLog.setPPreviousPrice(tempPrice);
                 if(pLogDAL.insert()){
                     System.out.println("Log: new price Added!");
                 }
             }
           if(photoActionType.equals("old")){
                 JOptionPane.showMessageDialog(null, "Data Edited without photo");
                  AfterAction();
            }else if(photoActionType.equals("new")){
                if(LoadImage.SavedImage(this.imgSourceURL, this.imgSaveURL)){
                    JOptionPane.showMessageDialog(null, "Data Edited with new photo");
                    if(!tempImgURL.equals("/images/productes.png")){
                        new Delete(tempImgURL,"","");
                    }
                    
                     AfterAction();
                }else{
                    JOptionPane.showMessageDialog(null, "Data Can't Edit with new photo");
                }
            }else if(photoActionType.equals("RemovePhoto")){
                if(!tempImgURL.equals("/images/productes.png")){
                    new Delete(tempImgURL,"",""); 
                }
            }
        }else  JOptionPane.showMessageDialog(null,"Not done edit");
    }

    private void AfterAction(){
        setNull();
        Sync();
    }
    
    private void setNull(){
        tempPrice=-1.0;
        txt_pID.setText(genarateProductID());
        pList.setnull();
        tempPID=null;
         imgSourceURL=null;
         imgSaveURL=null;
         tempImgURL=null;
         SelectedItem=null;
         ActionType="save";
         photoActionType="old";
         this.SelectedItem=null;
        txtBarcode.setText("");
        txtName.setText("");
        comboCat.setValue(null);
        comboTax.setValue(null);
        comboUnit.setValue(null);
        txtSalePrice.setText("");
        lblTotalPrice.setText("");
        this.checkVisible.setSelected(false);
        this.photoProduct.setImage(new Image("/images/productes.png"));
        
        progsFindbyBarcode.setVisible(false);
    }
    private void getData(){
        
        pList.setpID(this.txt_pID.getText());
        pList.setPBarcode(this.txtBarcode.getText());
        pList.setPName(this.txtName.getText());
        pList.setPCatID(pCatDAL.getpCatIdByName(this.comboCat.getValue().toString()));
        pList.setPTaxID(taxDAL.getpTaxIdByName(this.comboTax.getValue().toString()));
        pList.setPUnitID(pUnitDAL.getpUnitIdByName(this.comboUnit.getValue().toString()));
        pList.setPSalePrice(Double.parseDouble(this.txtSalePrice.getText()));
        pList.setPVisible(getCheckBoxValue(checkVisible));
         if(photoActionType.equals("new")){
                 pList.setPPhotoURL("./img/products/"+new File(imgSaveURL).getName());
        }else if(ActionType.equals("save") && photoActionType.equals("old")){
                pList.setPPhotoURL("/images/productes.png");
        }
        
    }
    private void setData(){
        tempPrice=pList.getPSalePrice();
        tempPID=pList.getpID();
        this.txt_pID.setText(pList.getpID());
        txtBarcode.setText(pList.getPBarcode());
        txtName.setText(pList.getPName());
        comboCat.setValue(pCatDAL.getpCatNameByID(pList.getPCatID()));
        String tempTax=taxDAL.getpUnitNameByID(pList.getPTaxID());
        comboTax.setValue(tempTax);
        comboUnit.setValue(pUnitDAL.getpUnitNameByID(pList.getPUnitID()));
        txtSalePrice.setText(String.valueOf(pList.getPSalePrice()));
        lblTotalPrice.setText(String.valueOf(pList.getPSalePrice()+(pList.getPSalePrice()*taxDAL.getpTaxValueByName(tempTax))/100)+" "+vars.getMoneySymble());
        checkVisible.setSelected(setCheckBoxValue(pList.getPVisible()));
        tempImgURL=pList.getPPhotoURL();
        
        if(tempImgURL.equals("/images/productes.png")){
             this.photoProduct.setImage(new Image("/images/productes.png"));
        }else this.photoProduct.setImage(LoadImage.getImage(tempImgURL));
    }
    private int getCheckBoxValue(CheckBox checkVisible){
        if(checkVisible.isSelected()){
            return 1;
        }else if(!checkVisible.isSelected()){
            return 0;
        }
        return 0;
    }
    private boolean setCheckBoxValue(int Value){
        if(Value==1){
            return true;
        }else if(Value==0){
            return false;
        }return false;
    }
}
