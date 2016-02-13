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

import AppConfig.Config;
import AppConfig.Notify;
import AppConfig.vars;
import BusniessObjects.Customerslist;
import BusniessObjects.Productcategories;
import BusniessObjects.ProductsList;
import BusniessObjects.DataFactoryForPOS;
import BusniessObjects.QuantityDialog;
import BusniessObjects.ViewProductslist;
import DataAccessLayer.CustomersListDAL;
import DataAccessLayer.POSDAL;
import DataAccessLayer.ProductsListDAL;
import FileIOService.LoadImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static retail_pos_loader.start.stage;



/**
 * FXML Controller class
 *
 * @author Loser
 */
public class POSController implements Initializable {
    @FXML private VBox vBoxCat;
    @FXML private GridPane gPaneProducts;
    @FXML private TableView<DataFactoryForPOS> listTable=new TableView<DataFactoryForPOS>();
    @FXML private TableColumn colpID,colName,colQnty,colPrice,colTax,colAmount;
    @FXML private ImageView sortViewImage,imgAddProduct;
    @FXML private Label sortViewpName,shortViewCartName,shortViewPrice,lblItemCounts;
    @FXML private Label lblHidepID,lblSubTotal,lblTotalTax,lblGTotal,lblcusBalance,lblDueBalance,lblChange,lblDiscount;
    @FXML private Button btnRemoveCell;
    @FXML private TextField txtPay,txtAdd;
    @FXML private ChoiceBox comboCustomerType;
    @FXML private TextField txtCusID,txtCusName,txtCusMobile,txtCusFax;
    @FXML private TextArea txtCusAddress;
    @FXML private Button btnCusSearch;
    @FXML private Slider sliderDiscount;
    
    ObservableList<DataFactoryForPOS> tableRow = FXCollections.observableArrayList();
    int listCount=1;
    
    @FXML private void btnAdd(ActionEvent e){
        openSetQuantityDialog(this.txtAdd.getText());
        
    }
    CustomersListDAL cListDAL=new CustomersListDAL();
    Customerslist cList=new Customerslist();
    ProductsListDAL pListDAL= new ProductsListDAL();
    ProductsList pList= new ProductsList();
    POSDAL posDAL=new POSDAL();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AppConfig.Config.setTitle("Point Of Sale");
        imgAddProduct.setVisible(false);
        Notify.progresShow("Categoris are loading . . .");
        Platform.runLater(new Runnable() {
          @Override
          public void run() {
              addCatButtons(); 
              Notify.progressHide();
          }
        });
        listTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<DataFactoryForPOS>() {
            @Override
            public void changed(ObservableValue<? extends DataFactoryForPOS> observable, DataFactoryForPOS oldValue, DataFactoryForPOS newValue) {   
                 if(newValue==null)return;
                if(listTable.getItems().size()>0)
                   setDetails(newValue);
                else
                   setDetails(oldValue);
            }
        });
        
        
        //Combo box customer type initiial setting with seleted defualt action and get value from the box
        comboCustomerType.getItems().addAll("Guest","Registerted");
        comboCustomerType.setValue("Guest");
        getActionForNonRegistertedCustomer();
        
        //Customer Type change auto Action or text field change event
        comboCustomerType.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable,String  
                oldValue,String newValue){
                     if(newValue==null)return;
                     
                     if(newValue.equals("Guest")){
                        getActionForNonRegistertedCustomer();
                     }else{
                         getActionForRegistertedCustomer();
                         
                     }
                     
                }
                
        });
    }
    @FXML private void handleDiscountSlider(MouseEvent e){
        lblDiscount.setText(String.valueOf((int) this.sliderDiscount.getValue()));
        ERP_Process();
    }
    @FXML private void discountKeyEvent(KeyEvent e){
        lblDiscount.setText(String.valueOf((int) this.sliderDiscount.getValue()));
        ERP_Process();
    }
    @FXML private void btnHandeleSearch(ActionEvent e){
        if(this.txtCusID.getText().equals("")){
            return;
        }
        if(cListDAL.SelectCustomerByCID(this.txtCusID.getText())){
            this.txtCusID.setDisable(true);
            this.txtCusName.setDisable(false);
            this.txtCusMobile.setDisable(false);
            this.txtCusFax.setDisable(false);
            this.txtCusAddress.setDisable(false);
            
            this.txtCusName.setText(cList.getCName());
            this.txtCusMobile.setText(cList.getCMobile());
            this.txtCusFax.setText(cList.getCFax());
            this.txtCusAddress.setText("City:\n\tHouse-"+cList.getCHouse()+", Road-"+cList.getCRoad()+", Block-"+cList.getCBlock()+", Section-"+cList.getCSection()+", Area-"+cList.getCArea()+", City-"+cList.getCCity()+"\n\nVillage Address:\n\t"+cList.getCVillageAddress());
        }else{
            Notify.setMessage("No customer match with customer ID: "+this.txtCusID.getText());
            getActionForRegistertedCustomer();
        }
        
    }
    @FXML private void cusIDClick(MouseEvent e){
        if(txtCusID.isDisable()){
            this.comboCustomerType.setValue("Registerted");
            getActionForRegistertedCustomer();
        }
        
    }
    private void getActionForRegistertedCustomer(){
            btnCusSearch.setVisible(true);
            txtCusID.setText("");
            txtCusName.setText("");
            txtCusMobile.setText("");
            txtCusFax.setText("");
            txtCusAddress.setText("");
            
            txtCusID.setDisable(false);
            txtCusName.setDisable(true);
            txtCusMobile.setDisable(true);
            txtCusFax.setDisable(true);
            txtCusAddress.setDisable(true);
    }
        private void getActionForNonRegistertedCustomer(){
            btnCusSearch.setVisible(false);
           
            txtCusID.setText("---");
            txtCusName.setText("Guest");
            txtCusMobile.setText("None");
            txtCusFax.setText("None");
            txtCusAddress.setText("None");
            lblcusBalance.setText("0");
            lblDueBalance.setText("--");
            
            txtCusID.setDisable(true);
            txtCusName.setDisable(false);
            txtCusMobile.setDisable(false);
            txtCusFax.setDisable(false);
            txtCusAddress.setDisable(false);
    }
    private void setDetails(DataFactoryForPOS p){
        imgAddProduct.setVisible(false);
        lblHidepID.setText("");
        int i=0;
        ArrayList<ViewProductslist> product=posDAL.viewProduct(p.getColpID(), null, null);
        if(product!=null){
            if(!product.get(i).getPPhotoURL().equals("/images/productes.png")){
                 this.sortViewImage.setImage(LoadImage.getImage(product.get(i).getPPhotoURL()));
            }else{
                sortViewImage.setImage(LoadImage.from_images("productes.png"));
            }
            this.sortViewpName.setText(product.get(i).getPName());
            this.shortViewCartName.setText(product.get(i).getCatName());
            this.shortViewPrice.setText("Price: "+String.valueOf(product.get(i).getPSalePrice())+" "+vars.getMoneySymble()+" /"+product.get(i).getPUniName());
        }
            
    }
    private void addCatButtons(){
             if(posDAL.SelectCatNames()){
             vBoxCat.getChildren().clear();
             for(int i=0;i<Productcategories.pCatIDs.length;i++){
                 int temp=posDAL.getProductsRowSize(Productcategories.pCatIDs[i]);
                 if(temp>0)
                 vBoxCat.getChildren().add(addButton(Productcategories.pCatIDs[i],Productcategories.pCatNames[i],Productcategories.pCatPhotoURLs[i],temp));
             }
            }
         
    }
    private void addProductButton(int CatID){
        Notify.progresShow("Retiving Products List . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                if(posDAL.getFilterProductsByCat(CatID)){
                    gPaneProducts.getChildren().clear();
                        int temp=ProductsList.pIDs.length/3;
                        gPaneProducts.addColumn(temp);
                        int i=0;
                        while(true){
                            for(int col=0; col<=temp;col++){
                                for(int row=0; row<3;row++){
                                    gPaneProducts.add(addButtonForProducts(ProductsList.pIDs[i],ProductsList.pLists[i],ProductsList.pIconList[i],ProductsList.pPrice[i]), col, row);
                                    i++;
                                    if(i==ProductsList.pIDs.length){
                                        Notify.progressHide();
                                        return;
                                    }
                                }
                            }
                            break;
                        }
                }else {
                     gPaneProducts.getChildren().clear();
                     Notify.progressHide();
                }
                
            }
        });
    }
    private void FireEvent(String pID){
        int i=0;
        ArrayList<ViewProductslist> product=posDAL.viewProduct(pID, null, null);
        if(product!=null){
            if(!product.get(i).getPPhotoURL().equals("/images/productes.png")){
                 this.sortViewImage.setImage(LoadImage.getImage(product.get(i).getPPhotoURL()));
            }else{
                sortViewImage.setImage(LoadImage.from_images("productes.png"));
            }
            lblHidepID.setText(pID);
            this.sortViewpName.setText(product.get(i).getPName());
            this.shortViewCartName.setText(product.get(i).getCatName());
            this.shortViewPrice.setText("Price: "+String.valueOf(product.get(i).getPSalePrice())+" "+vars.getMoneySymble()+" /"+product.get(i).getPUniName());
            
            
            
            QuantityDialog.Name=product.get(i).getPName();
            QuantityDialog.Unit=product.get(i).getPUniName();
            QuantityDialog.tex=Config.getPercent(product.get(i).getTaxValue(), product.get(i).getPSalePrice());
            QuantityDialog.price=product.get(i).getPSalePrice();
            imgAddProduct.setVisible(true);
        }
    }
 
    @FXML private void handleimgAddProduct(MouseEvent e){
        if(!lblHidepID.getText().equals("")){
            openSetQuantityDialog(lblHidepID.getText());
        }
    }
    private void openSetQuantityDialog(String pID){
            double qunty=1.0;
            int i=0;
            ArrayList<ViewProductslist> product=posDAL.viewProduct(pID, null, null);
            if(product!=null){
            //Dialog d;
            try {
               // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(POSController.class.getResource("/View/InputProductQuntityDiolog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Quantity Manage Dialog");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.setResizable(false);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            Config.setOpacityForHome(0.20);
            dialogStage.showAndWait();
            } catch (IOException ex) {
                Logger.getLogger(POSController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Config.setOpacityForHome(1.0);
            qunty=QuantityDialog.qntity;
            if(QuantityDialog.isOk && qunty!=0)
                tableRowAdd(product.get(i).getPName(),product.get(i).getPID(),qunty,product.get(i).getPSalePrice(),Config.getPercent(product.get(i).getTaxValue(), product.get(i).getPSalePrice()),product.get(i).getTaxValue(),(product.get(i).getPSalePrice()*qunty)+(Config.getPercent(product.get(i).getTaxValue(), product.get(i).getPSalePrice())*qunty));
            else return;
            
        }
    }
    /**
 * Called when the user clicks on the delete button.
 */
    @FXML
    private void btnRemove() {
        int selectedIndex = listTable.getSelectionModel().getSelectedIndex();
        if(selectedIndex>=0)
        listTable.getItems().remove(selectedIndex);
        ERP_Process();
        lblItemCounts.setText(String.valueOf(listTable.getItems().size()));
        if(listTable.getItems().size()<1)
            btnRemoveCell.setDisable(true);
        
    }
    private void tableRowAdd(String pID, String Name, Double Qnty,Double Price,Double Tax,Double TaxValue,Double Amount){
            tableRow.add(new DataFactoryForPOS(listTable.getItems().size()+1,pID,Name,Qnty,Price,Tax,Amount));
            this.colpID.setCellValueFactory(new PropertyValueFactory<DataFactoryForPOS, String>("colpID"));
            this.colName.setCellValueFactory(new PropertyValueFactory<DataFactoryForPOS, String>("colName"));
            this.colQnty.setCellValueFactory(new PropertyValueFactory<DataFactoryForPOS, Double>("colQnty"));
            this.colPrice.setCellValueFactory(new PropertyValueFactory<DataFactoryForPOS, Double>("colPrice"));
            this.colTax.setCellValueFactory(new PropertyValueFactory<DataFactoryForPOS, Double>("colTex"));
            this.colAmount.setCellValueFactory(new PropertyValueFactory<DataFactoryForPOS, Double>("colAmount"));
            listTable.setItems(tableRow);
            lblItemCounts.setText(String.valueOf(listTable.getItems().size()));
            ERP_Process();
            if(listTable.getItems().size()>0)
                 btnRemoveCell.setDisable(false);
            
    }
      @FXML private void OnPayKeyRealize(KeyEvent e){
        Double pay=0.0;
        try{
            pay=Double.parseDouble(txtPay.getText());
        }catch(Exception er){
            if(txtPay.getText().equals("")){
                 lblChange.setText(String.valueOf((pay)));
                return;
            }
            Notify.setMessage("Currency Format Error! Enter Number");
            return;
        }
       // Double pay=Double.parseDouble(txtPay.getText());
        Double total=Double.parseDouble(lblGTotal.getText());
        lblChange.setText(String.valueOf((total-pay)*(-1)));
    }
    
     private void ERP_Process(){
        Double subTotal = null,TotalTax = null,GTotal = null,CusBalance = null,calculateTotal=0.0;
        if(!lblDueBalance.getText().equals("--")){
            try{
                subTotal=Double.parseDouble(this.lblSubTotal.getText());
                TotalTax=Double.parseDouble(this.lblTotalTax.getText());
              //  GTotal=Double.parseDouble(this.lblGTotal.getText());
                CusBalance=Double.parseDouble(this.lblcusBalance.getText());
            }catch(Exception e){
                e.printStackTrace();
            }
            if(lblDueBalance.getText().equals(" Due")){
                GTotal=subTotal+TotalTax;
                calculateTotal=GTotal+CusBalance;
            }
            else if(lblDueBalance.getText().equals(" Balance")){
                GTotal=subTotal+TotalTax;
                calculateTotal=GTotal-CusBalance;
            }
        }else{
            try{
                subTotal=Double.parseDouble(this.lblSubTotal.getText());
                TotalTax=Double.parseDouble(this.lblTotalTax.getText());
                CusBalance=Double.parseDouble(this.lblcusBalance.getText());
            }catch(Exception e){
                e.printStackTrace();
            }
                calculateTotal=subTotal+TotalTax;         
        }
        
        this.lblGTotal.setText(String.valueOf(Config.getDiscount(Double.parseDouble(this.lblDiscount.getText()), calculateTotal)));
    }
    private Pane addButton( int btnID, String btnText, String icon,int AvailableProduct) {
        Pane pane=new Pane();
        pane.setPrefSize(-1, 73);
        pane.setMaxSize(-1, 73);
        pane.setMinSize(-1, 73);
       
        ImageView logo=new ImageView();
        if(!icon.equals("/images/cat.png")){
            logo.setImage(LoadImage.getImage(icon));
        }else{
            logo.setImage(LoadImage.from_images("cat.png"));
        }
        logo.setFitHeight(40);
        logo.setFitWidth(45);
        logo.setLayoutX(14);
        logo.setLayoutY(15);
        logo.setCursor(Cursor.HAND);
        logo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                 try {                    
                   addProductButton(btnID);
                }catch (Exception e) {

                }
            }
        });
        
        Label CatName=new Label();
        if (btnText != null && !btnText.equals("")){
             CatName.setText(btnText);
        }else CatName.setText("NO NAME");
        CatName.setLayoutX(72);
        CatName.setLayoutY(28);
        CatName.setCursor(Cursor.HAND);
        CatName.setStyle("");
        CatName.ellipsisStringProperty().setValue("Available Products: "+String.valueOf(AvailableProduct));
        CatName.setEllipsisString("Available Products: "+String.valueOf(AvailableProduct));
        CatName.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                 try {                    
                   addProductButton(btnID);
                }catch (Exception e) {

                }
            }
        });
        pane.getChildren().addAll(logo,CatName);
        return pane;
    }         
   
    private Pane addButtonForProducts( String pID, String btnText, String icon,String tipTool) {
        VBox pane=new VBox();
        pane.setPrefSize(73, -1);
        pane.setMaxSize(73, -1);
        pane.setMinSize(73, -1);
        pane.setStyle("-fx-alignment: center; -fx-spacing: 4;-fx-padding: 7px 0px 0px 0px;");
        
        ImageView logo=new ImageView();
        if(!icon.equals("/images/productes.png")){
            logo.setImage(LoadImage.getImage(icon));
        }else{
            logo.setImage(LoadImage.from_images("productes.png"));
        }
        logo.setFitHeight(40);
        logo.setFitWidth(45);
        logo.setCursor(Cursor.HAND);
        logo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    if(event.getClickCount() == 2){
                        openSetQuantityDialog(pID);
                    }
                    if(event.getClickCount() == 1){
                        FireEvent(pID);
                     }
                }
               
            }
        });
        
        Label CatName=new Label();
        if (btnText != null && !btnText.equals("")){
             CatName.setText(btnText);
        }else CatName.setText("NO NAME");
        CatName.setCursor(Cursor.HAND);
        CatName.setStyle("");
        CatName.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    if(event.getClickCount() == 2){
                        openSetQuantityDialog(pID);
                    }
                    if(event.getClickCount() == 1){
                        FireEvent(pID);
                     }
                }
            }
        });
        pane.getChildren().addAll(logo,CatName);
        return pane;
    }         

}
