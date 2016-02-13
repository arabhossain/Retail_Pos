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

import AppConfig.Notify;
import AppConfig.vars;
import BusniessObjects.Branches;
import DataAccessLayer.BranchesDAL;
import FileIOService.Cloud_DB_ConfigCreate;
import FileIOService.Local_DB_ConfigCreate;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import static retail_pos_loader.start.root;
import static retail_pos_loader.start.scene;
import static retail_pos_loader.start.stage;



/**
 * FXML Controller class
 *
 * @author Loser
 */
public class ConfigurationController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         AppConfig.Config.setTitle("Configuration");
        Sny_Setting_General_Tab();
        Sny_Setting_Branch_Tab();
        Sny_Setting_Local_Tab();
        Sny_Setting_Cloud_Tab();
    }
    
    private void Sny_Setting_General_Tab(){
        
         if(brnchDAL.getBranchNames()){
             comboBranchName.getItems().clear();
             comboBranchName.getItems().addAll(Branches.bNames);
         }
        this.txtShopName.setText(vars.getShopName());
        brnchDAL.getBranchByName("",vars.getBranchID());
        this.comboBranchName.setValue(brnch.getBName());
        this.txtMoney.setText(vars.getMoneySymble());
    }
 
    private void Sny_Setting_Local_Tab(){
        LocalDBType.getItems().addAll("MySql","Derby");
        this.LocalDBType.setValue(vars.getDRIVER_Type());
        this.LocalDriverClassName.setText(vars.getJDBC_DRIVER());
        this.LocalDatabaseName.setText(vars.getDbName());
        this.LocaldatabaseURL.setText(vars.getDB_Url());
        this.LocalUserName.setText(vars.getDbUser());
        this.LocalUserPassword.setText(vars.getDbPass());
    }
    private void Sny_Setting_Cloud_Tab(){
        this.txlCloudDatabaseName.setText(vars.getCloudDatabaseName());
        this.txtCloudIP.setText(vars.getCloudIP());
        this.txtCloudPassword.setText(vars.getCloudPass());
        this.txtCloudUserName.setText(vars.getCloudUser());
        this.txtServerPort.setText(vars.getCloudPort());
    }
    
    
    //=================================== Local Config Tab ======================================\\
    //=============START LOCAL DATABASE CONTROLERS================
    @FXML private ComboBox LocalDBType;
    @FXML private TextField LocalDriverClassName;
    @FXML private TextField LocaldatabaseURL;
    @FXML private TextField LocalDatabaseName;
    @FXML private TextField LocalUserName;
    @FXML private PasswordField LocalUserPassword;
    @FXML private ImageView LocalTestConnImage;
   
    
    //Test Connection for local database

    /**
     *
     * @param evt
     */
    @FXML
    public void btn_LocalTest(ActionEvent evt){
            Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                Connection conn=null;
            try{
                Class.forName(LocalDriverClassName.getText());
                conn=DriverManager.getConnection(LocaldatabaseURL.getText()+LocalDatabaseName.getText(), LocalUserName.getText(),LocalUserPassword.getText());
                LocalTestConnImage.setImage(new Image("/images/accept.png"));
            }catch(Exception e){  
                  LocalTestConnImage.setImage(new Image("/images/error.png"));
                  e.printStackTrace();
            }
                 Notify.progressHide();
                 }
         });
           
    }  
    //Save button for local database xml file

    /**
     *
     * @param evt
     */
    @FXML
    public void btn_LocalSave(ActionEvent evt){
        vars.setDRIVER_Type(this.LocalDBType.getValue().toString());
        vars.setJDBC_DRIVER(this.LocalDriverClassName.getText());
        vars.setDB_Url(this.LocaldatabaseURL.getText());
        vars.setDbName(this.LocalDatabaseName.getText());
        vars.setDbUser(this.LocalUserName.getText());
        vars.setDbPass(this.LocalUserPassword.getText());
        new Local_DB_ConfigCreate().db_data();
    }
    @FXML
    private void DBTypeClickd(MouseEvent evt){
        LocalDBType.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> observable,String oldValue,String newValue){
                 if(newValue.equals("Derby")){
                        derbyConfig();
                    }else if(newValue.equals("MySql")){
                        mySqlConfig();
                    }
            }
        });
    }
    //Auto complete field aid methods
    private void derbyConfig(){
        this.LocalDriverClassName.setText("org.apache.derby.jdbc.ClientDriver");
        this.LocaldatabaseURL.setText("jdbc:derby://localhost:1527/");
        this.LocalDatabaseName.setText("");
        this.LocalUserName.setText("");
        this.LocalUserPassword.setText("");
    }
    private void mySqlConfig(){
        this.LocalDriverClassName.setText("com.mysql.jdbc.Driver");
        this.LocaldatabaseURL.setText("jdbc:mysql://localhost/");
        this.LocalDatabaseName.setText("");
        this.LocalUserName.setText("");
        this.LocalUserPassword.setText("");
    }
 
    
    
    //========================================= Cloud Setup==============================\\
     //=============START CLOUD DATABASE CONTROLERS================
    @FXML private TextField txtCloudIP;
    @FXML private TextField txtServerPort;
    @FXML private TextField txlCloudDatabaseName;
    @FXML private TextField txtCloudPassword;
    @FXML private TextField txtCloudUserName;
    @FXML private ImageView imgCloudConnTest;
    
        //Save Button for Cluoud database xml file

    /**
     *
     * @param evt
     */
    @FXML
    public void btn_CloudSave(ActionEvent evt){
        vars.setCloudIP(this.txtCloudIP.getText());
        vars.setCloudPort(this.txtServerPort.getText());
        vars.setCloudDatabaseName(this.txlCloudDatabaseName.getText());
        vars.setCloudUser(this.txtCloudUserName.getText());
        vars.setCloudPass(this.txtCloudPassword.getText());
       
         Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                 new Cloud_DB_ConfigCreate().db_data();
                 Notify.progressHide();
                 }
         });
      
    }
        //Test Connection for online database

    /**
     *
     * @param evt
     */
    @FXML
    public void btn_CloudTest(ActionEvent evt){
         Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                  Connection conn=null;
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    conn=DriverManager.getConnection("jdbc:mysql://"+txtCloudIP.getText()+":"+txtServerPort.getText()+"/"+txlCloudDatabaseName.getText(), txtCloudUserName.getText(),txtCloudPassword.getText());
                    imgCloudConnTest.setImage(new Image("/images/accept.png"));
                }catch(Exception e){  
                      imgCloudConnTest.setImage(new Image("/images/error.png"));
                      e.printStackTrace();
                }
                 Notify.progressHide();
                 }
         });
       
    }
    
    //==================GENERAL Setup====================================\\
    
    //=============START GENERAL TAB CONTROLERS================
    @FXML private TextField txtShopName;
    @FXML private ComboBox comboBranchName;
    @FXML private TextField txtMoney;
    @FXML private ColorPicker choserColor;
    
    @FXML private void btnSave(ActionEvent e){
        vars.setShopName(txtShopName.getText());
        if(brnchDAL.getBranchByName(comboBranchName.getValue().toString(),0)){
           vars.setBranchID(brnch.getBID()); 
        }
        
        vars.setMoneySymble(txtMoney.getText());
        new Local_DB_ConfigCreate().db_data();
    }
    @FXML private void colorPick(MouseEvent e){
       
    }
    
    
    //==================Branch Setup====================================\\
    
    //=============START Branch TAB CONTROLERS================
    
    @FXML private TextField txtBranchName,txtAddressLine1,txtAddressLine2;
    @FXML private CheckBox CheckHeadBrach;
    @FXML private ListView listView;
    
    private String ActionType="save";
    private String SelectedItem=null;
    Branches brnch=new Branches();
    BranchesDAL brnchDAL=new BranchesDAL();
    
    @FXML private void listClicked(MouseEvent e){
         SelectedItem=null;
         SelectedItem=listView.getFocusModel().getFocusedItem().toString();
         
             Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                 if(brnchDAL.getBranchByName(SelectedItem,0)){
                setData();
                ActionType="edit";
            }
                 Notify.progressHide();
                 }
         });
        
    }
    @FXML private void btnAddNew(ActionEvent e){
        setNull();
        ActionType="save";
    }
    @FXML private void btnDelete(ActionEvent e){
         Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
            @Override
            public void run() {
                 if(SelectedItem!=null){
                    if(Notify.toConfirmPane("The branch name is going to be deleted", "Deleting Confirmation")){
                        if(brnchDAL.deleteByName(SelectedItem)){
                            AfterAction();
                        }
                    }
                }else Notify.toAlartPane("Blank Selection! \nPlease select from list and try again");
                 Notify.progressHide();
            }
         });
        
    }
    @FXML private void btnBSave(ActionEvent e){
            Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                 getData();
                if(ActionType.equals("save")){

                    if(brnchDAL.insert()){
                        AfterAction();
                    }
                }else if(ActionType.equals("edit")){
                    if(brnchDAL.update(SelectedItem)){
                        AfterAction();
                    }
                }
                 Notify.progressHide();
                 }
         });
        
    }
    private void getData(){
        brnch.setBName(this.txtBranchName.getText());
        brnch.setBAdressLine1(this.txtAddressLine1.getText());
        brnch.setBAdressLine2(this.txtAddressLine2.getText());
        brnch.setBHeadBranch(getCheckValue(CheckHeadBrach));
    }
    private int getCheckValue(CheckBox checkbox){
        if(checkbox.isSelected()){
            return 1;
        }else return 0;
    }
    private void setData(){
        this.txtBranchName.setText(brnch.getBName());
        this.txtAddressLine1.setText(brnch.getBAdressLine1());
        this.txtAddressLine2.setText(brnch.getBAdressLine2());
        this.CheckHeadBrach.setSelected(setCheckValue(brnch.getBHeadBranch()));
    }
    private boolean setCheckValue(int value){
        if(value==1){
            return true;
        }else return false;
    }
    private void AfterAction(){
        setNull();
        Sny_Setting_Branch_Tab();
        Sny_Setting_General_Tab();
    }
    private void setNull(){
        ActionType="save";
        this.txtBranchName.setText("");
        this.txtAddressLine1.setText("");
        this.txtAddressLine2.setText("");
        this.CheckHeadBrach.setSelected(false);
    }
       private void Sny_Setting_Branch_Tab(){
         if(brnchDAL.getBranchNames()){
            listView.getItems().clear();
            for(int i=0;i<Branches.bNames.length;i++){
                    listView.getItems().add(Branches.bNames[i]);
                  } 
        }
    }
}
