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
import BusniessObjects.UserRole;
import DataAccessLayer.UserRoleDAL;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 *
 * @author Loser
 */
public class UserRoleController implements Initializable {
    //FXML Controller variables
    @FXML private TextField txtRoleName;
    @FXML private CheckBox boxSales;
    @FXML private CheckBox boxEditSales;
    @FXML private CheckBox boxCustomerPayment;
    @FXML private CheckBox boxExpence;
    @FXML private CheckBox boxCashClose;
    
    @FXML private CheckBox boxCustomers;
    @FXML private CheckBox boxUsers;
    @FXML private CheckBox boxStoke;
    @FXML private CheckBox boxReports;
    @FXML private CheckBox boxPresenceMangae;
    @FXML private CheckBox boxUserRole;
    
    @FXML private CheckBox boxTools;
    @FXML private CheckBox boxConfig;
    @FXML private CheckBox boxTaxes;
    @FXML private ListView listview;
    
    private int RoleID=0;
    private String SelectedItem;
    private String ActionType="save";
    
    UserRole ur=new UserRole();
    UserRoleDAL urdal=new UserRoleDAL();
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         AppConfig.Config.setTitle("User Role");
        SynSettings();
    } 
    @FXML private void btn_delete(ActionEvent evt){
        if(RoleID!=0){
            if(Notify.toConfirmPane("Please Make sure you want to delete this user role. \n You may lose user previlous", "Are you sure to delete")){
                urdal.DeleteById(RoleID);
                AfterActions();
            }
        }else Notify.toAlartPane("Empty Selection! Please Select and try again");
        
    }
    @FXML private void btn_save(ActionEvent evt){
        if(this.txtRoleName.getText().equals("")){
            Notify.toErrorPane("You have not inputed a Role Name yet. \n Please try agin!");
            return;
        }
        if(ActionType.equals("save")){
            save_data();
        }else if(ActionType.equals("edit")){
            edit_data();
        }
        AfterActions();
    }
    @FXML private void btn_addnew(ActionEvent evt){
        ActionType="save";
         SynSettings();
    }
    @FXML private void Refresh(ActionEvent evt){
         getRoleSetting();
    }
    @FXML private void UncheckAll(ActionEvent evt){
        UnCheckToAll();
    }
    @FXML private void CheckAll(ActionEvent evt){
        CheckToAll();
    }
    @FXML private void listClick(MouseEvent e){
        SelectedItem=listview.getFocusModel().getFocusedItem().toString();
        if(urdal.SelectRoleBy(0, SelectedItem)){
            RoleID=urdal.getRoleIdByNames(SelectedItem);
            this.ActionType="edit";
            getRoleSetting();
        }
    }
    
    //Bussness Methods
    private void SynSettings(){
             listview.getItems().clear();
             urdal.SelectRoleNames();
             for(int i=0;i<UserRole.names.length;i++){
                 listview.getItems().add(UserRole.names[i]);
             }
             this.RoleID=0;
             SelectedItem=null;
              UnCheckToAll();
              this.txtRoleName.setText("");
              
       
     //   listview.getItems().addAll(urdal.SelectRoleNames().listIterator(1).next());
    }
    private void save_data(){
        SynValueFromInterface();
        
        if(urdal.AddNewRole()){
            Notify.setMessage("Data Saved!");
        }else Notify.setMessage("Save Error!");
        
    }
    private void edit_data(){
        SynValueFromInterface();
        
        if(urdal.UpdateById(RoleID)){
            Notify.setMessage("Data Edited!");
        }else Notify.setMessage("Edit Error!");
    }
    private void SynValueFromInterface(){
        ur.setTxtRoleName(txtRoleName.getText());
        ur.setSales(getCheckBoxValue(boxSales));
        ur.setEditSales(getCheckBoxValue(boxEditSales));
        ur.setCustomerPayment(getCheckBoxValue(boxCustomerPayment));
        ur.setExpence(getCheckBoxValue(boxExpence));
        ur.setCashClose(getCheckBoxValue(boxCashClose));
        
        ur.setCustomers(getCheckBoxValue(boxCustomers));
        ur.setUsers(getCheckBoxValue(boxUsers));
        ur.setStoke(getCheckBoxValue(boxStoke));
        ur.setReports(getCheckBoxValue(boxReports));
        ur.setPresenceMangae(getCheckBoxValue(boxPresenceMangae));
        ur.setUserRole(getCheckBoxValue(boxUserRole));
        
        ur.setTools(getCheckBoxValue(boxTools));
        ur.setConfig(getCheckBoxValue(boxConfig));
        ur.setTaxes(getCheckBoxValue(boxTaxes));
    }
    //Get boxes checked for select item from the list view
    private void getRoleSetting(){
        this.txtRoleName.setText(SelectedItem);
        setCheckBoxValue(this.boxSales,ur.getSales());
        setCheckBoxValue(this.boxEditSales,ur.getEditSales());
        setCheckBoxValue(this.boxCustomerPayment,ur.getCustomerPayment());
        setCheckBoxValue(this.boxExpence,ur.getExpence());
        setCheckBoxValue(this.boxCashClose,ur.getCashClose());
        
        setCheckBoxValue(this.boxCustomers,ur.getCustomers());
        setCheckBoxValue(this.boxUsers,ur.getUsers());
        setCheckBoxValue(this.boxStoke,ur.getStoke());
        setCheckBoxValue(this.boxReports,ur.getReports());
        setCheckBoxValue(this.boxPresenceMangae,ur.getPresenceMangae());
        setCheckBoxValue(this.boxUserRole,ur.getUserRole());
        
        setCheckBoxValue(this.boxTools,ur.getTools());
        setCheckBoxValue(this.boxConfig,ur.getConfig());
        setCheckBoxValue(this.boxTaxes,ur.getTaxes());
    }
    private int getCheckBoxValue(CheckBox ch){
        if(ch.isSelected()){
            return 1;
        }else return 0;
    }
    private void setCheckBoxValue(CheckBox ch, int value){
        if(value==0){
            ch.setSelected(false);
        }else if(value==1){
            ch.setSelected(true);
        }
    }
    private void AfterActions(){
        this.txtRoleName.setText("");
        UnCheckToAll();
        SynSettings();
    }
    private void CheckToAll(){
        boxSales.setSelected(true);
        boxSales.setSelected(true);
        boxEditSales.setSelected(true);
        boxCustomerPayment.setSelected(true);
        boxExpence.setSelected(true);
        boxCashClose.setSelected(true);

        boxCustomers.setSelected(true);
        boxUsers.setSelected(true);
        boxStoke.setSelected(true);
        boxReports.setSelected(true);
        boxPresenceMangae.setSelected(true);
        boxUserRole.setSelected(true);

        boxTools.setSelected(true);
        boxConfig.setSelected(true);
        boxTaxes.setSelected(true);
    }
    private void UnCheckToAll(){
        boxSales.setSelected(false);
        boxSales.setSelected(false);
        boxEditSales.setSelected(false);
        boxCustomerPayment.setSelected(false);
        boxExpence.setSelected(false);
        boxCashClose.setSelected(false);

        boxCustomers.setSelected(false);
        boxUsers.setSelected(false);
        boxStoke.setSelected(false);
        boxReports.setSelected(false);
        boxPresenceMangae.setSelected(false);
        boxUserRole.setSelected(false);

        boxTools.setSelected(false);
        boxConfig.setSelected(false);
        boxTaxes.setSelected(false);
    }
    
}
