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
import BusniessObjects.Customerslist;
import BusniessObjects.Login;
import DataAccessLayer.CustomersListDAL;
import FileIOService.Delete;
import FileIOService.LoadImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
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
public class CustomersController implements Initializable {
    @FXML private ListView listView;
    @FXML private TextField txtSearchByName,txtName,txtMobile,txtEmail,txtFax,txtHome,txtRoad,txtBlock,txtSection,txtArea,txtCity;
    @FXML private TextArea txtVillageAddress;
    @FXML private ImageView imgCustomer;
    @FXML private Tab tabTransections;
    @FXML private TableView tblTransection;
    @FXML private Label lblCustomerID;
    
    private String imgSourceURL=null;
    private String imgSaveURL=null;
    private String tempImgURL=null;
    private String SelectedItem;
    private String SelectedCID;
    private String ActionType="save";
    private String photoActionType="old";

    
    Customerslist cList=new Customerslist();
    CustomersListDAL cListDAL=new CustomersListDAL();
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         AppConfig.Config.setTitle("Customers");
        tabTransections.setDisable(true);
        SnykSetting();
    }    
    
    @FXML private void btnAddNew(ActionEvent e){
        setNull();
    }
    @FXML private void btnDelete(ActionEvent e){
      //      int a;
      // a=JOptionPane.showConfirmDialog(null,"","",JOptionPane.OK_CANCEL_OPTION);
       if(Notify.toConfirmPane("Please Make sure you want to delete this user.", "Are you sure to delete")){
           //Do if pressed YES option from the confirm dilog box
           if(cListDAL.delete(SelectedCID) && SelectedItem!=null){
               if(!tempImgURL.equals("/images/Customers.png")) {
                new Delete(tempImgURL,"","");   
               }
                AfterAction();
                return;
           }else Notify.toAlartPane("Please Select a name from the list and try again!"); //JOptionPane.showMessageDialog(null, "");
       }else{
           // Do what if user pressed the cencel button
           return;
       }
    }
    @FXML private void btnSave(ActionEvent e){
        if(ActionType.equals("save")){
            save_data();
        }else if(ActionType.equals("edit")){
            edit_data();
        }
    }
    @FXML private void btnAddPhoto(ActionEvent e){
        imgSourceURL=null;
        imgSourceURL=Chooser.getImageFile("Select Customer Photo");
        
        imgSaveURL="./img/customers/"+this.txtName.getText()+"_"+new File(imgSourceURL).getName();
        this.imgCustomer.setImage(LoadImage.getImage(imgSourceURL));
        if(imgSourceURL!=null){
             photoActionType="new";
        }else if(imgSourceURL==null){
            photoActionType="old";
        }
    }
    @FXML private void btnRemovePhoto(ActionEvent e){
         this.imgCustomer.setImage(new Image("/images/Customers.png"));
           cList.setCPhotoURL("/images/Customers.png");
           
          photoActionType="RemovePhoto";
    }
    @FXML private void listClicked(MouseEvent e){
         setNull();
         SelectedItem=listView.getFocusModel().getFocusedItem().toString();
         SelectedCID=Customerslist.cIDs[listView.getFocusModel().getFocusedIndex()];
         if(cListDAL.SelectCustomerByCID(SelectedCID)){
             setData();
             ActionType="edit";
             tabTransections.setDisable(false);
         }
    }
    @FXML private void SearchByName(KeyEvent e){
        if(!this.txtSearchByName.getText().equals("")){
            cListDAL.getFilterCustomers(this.txtSearchByName.getText());
        }else if(this.txtSearchByName.getText().equals("")){
            cListDAL.SelectCustomerNames();
        }
        listView.getItems().clear();
        for(int i=0;i<Customerslist.cNames.length;i++){
            listView.getItems().add(Customerslist.cNames[i]);
        } 
        
    }
    
    
    
    
     private void save_data(){
        getData();
        if(cListDAL.insert()){
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
    private void edit_data(){
         getData();
        if(cListDAL.update(SelectedCID)){
           if(photoActionType.equals("old")){
                 JOptionPane.showMessageDialog(null, "Data Edited without photo");
                  AfterAction();
            }else if(photoActionType.equals("new")){
                if(LoadImage.SavedImage(this.imgSourceURL, this.imgSaveURL)){
                    JOptionPane.showMessageDialog(null, "Data Edited with new photo");
                    if(!tempImgURL.equals("/images/Customers.png")){
                        new Delete(tempImgURL,"","");
                    }
                    
                     AfterAction();
                }else{
                    JOptionPane.showMessageDialog(null, "Data Can't Edit with new photo");
                }
            }else if(photoActionType.equals("RemovePhoto")){
                if(!tempImgURL.equals("/images/Customers.png")){
                    new Delete(tempImgURL,"",""); 
                }
            }
        }else  JOptionPane.showMessageDialog(null,"Not done edit");
    }
    private void SnykSetting(){
        if(cListDAL.SelectCustomerNames()){
            listView.getItems().clear();
            for(int i=0;i<Customerslist.cNames.length;i++){
                    listView.getItems().add(Customerslist.cNames[i]);
                  } 
        }
        this.lblCustomerID.setText(genarateProductID());
    }
    private void AfterAction(){
        setNull();
        SnykSetting();
    }
    
    private void setNull(){
         imgSourceURL=null;
         imgSaveURL=null;
         tempImgURL=null;
         SelectedItem=null;
         ActionType="save";
         photoActionType="old";
         this.SelectedItem=null;
        SelectedCID=null;
        
        this.lblCustomerID.setText(genarateProductID());
        this.txtName.setText("");
        this.txtMobile.setText("");
        this.txtEmail.setText("");
        this.txtFax.setText("");
        this.txtHome.setText("");
        this.txtRoad.setText("");
        this.txtBlock.setText("");
        this.txtSection.setText("");
        this.txtArea.setText("");
        this.txtCity.setText("");
        this.txtVillageAddress.setText("");
        this.imgCustomer.setImage(new Image("/images/Customers.png"));
    }
    private void getData(){
        cList.setCID(this.lblCustomerID.getText());
        cList.setCName(this.txtName.getText());
        cList.setCMobile(this.txtMobile.getText());
        cList.setCEmail(this.txtEmail.getText());
        cList.setCFax(this.txtFax.getText());
        cList.setCHouse(this.txtHome.getText());
        cList.setCRoad(this.txtRoad.getText());
        cList.setCBlock(this.txtBlock.getText());
        cList.setCSection(this.txtSection.getText());
        cList.setCArea(this.txtArea.getText());
        cList.setCCity(this.txtCity.getText());
        cList.setCVillageAddress(this.txtVillageAddress.getText());
        
        if(photoActionType.equals("new")){
                 cList.setCPhotoURL("./img/customers/"+new File(imgSaveURL).getName());
        }else if(ActionType.equals("save") && photoActionType.equals("old")){
                 cList.setCPhotoURL("/images/Customers.png");
        }
        
    }
    private void setData(){
        this.lblCustomerID.setText(cList.getCID());
        this.txtName.setText(cList.getCName());
        this.txtMobile.setText(cList.getCMobile());
        this.txtEmail.setText(cList.getCEmail());
        this.txtFax.setText(cList.getCFax());
        this.txtHome.setText(cList.getCHouse());
        this.txtRoad.setText(cList.getCRoad());
        this.txtBlock.setText(cList.getCBlock());
        this.txtSection.setText(cList.getCSection());
        this.txtArea.setText(cList.getCArea());
        this.txtCity.setText(cList.getCCity());
        this.txtVillageAddress.setText(cList.getCVillageAddress());

        tempImgURL=cList.getCPhotoURL();
        
        if(tempImgURL.equals("/images/Customers.png")){
             this.imgCustomer.setImage(new Image("/images/Customers.png"));
        }else this.imgCustomer.setImage(LoadImage.getImage(tempImgURL));
    }
    Login login=new Login();
    private String genarateProductID(){
        return "CU"+String.valueOf(cListDAL.getLastProductID()+1)+""+String.valueOf(login.getUserId())+""+vars.getBranchID();
    }
}
