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
import BusniessObjects.Branches;
import BusniessObjects.UserRole;
import BusniessObjects.Users;
import DataAccessLayer.BranchesDAL;
import DataAccessLayer.UserDAL;
import DataAccessLayer.UserRoleDAL;
import FileIOService.Delete;
import FileIOService.LoadImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 *
 * @author Loser
 */
public class UsersController implements Initializable {
    //FXML Controlar variables
    @FXML private TextField txtFullName;
    @FXML private TextField txtUserName;
    @FXML private TextField txtMobile;
    @FXML private TextArea tAreaAddress;
    @FXML private PasswordField txtNewPassword;
    @FXML private PasswordField txtRePassword;
    @FXML private ComboBox combRole;
    @FXML private ComboBox combStatus;
    @FXML private ComboBox combBranch;
    @FXML private ImageView imgUserPhoto;
    @FXML private ImageView imgCheckPass;
    @FXML private ImageView imgIsOnline;
    @FXML private ListView listUser;
    @FXML private Button savebtn;
         
    Users ObjUsec=new Users();        
    UserDAL user=new UserDAL();
    UserRoleDAL urdal=new UserRoleDAL();
    UserRole uRole=new UserRole();
    BranchesDAL brnchDAL=new BranchesDAL();
    Branches brnch=new Branches(); 

    private String imgSourceURL=null;
    private String imgSaveURL=null;
    private String tempUserName=null;
    private String tempImgURL=null;
    private String SelectedItem;
    private String ActionType="save";
    private String photoActionType="old";
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         AppConfig.Config.setTitle("Users");
        SynSettings();
    }
    
        //Bussness Methods
    private void SynSettings(){
            combStatus.getItems().clear();
            combRole.getItems().clear();
            listUser.getItems().clear();
            if(brnchDAL.getBranchNames()){
                combBranch.getItems().clear();
                combBranch.getItems().addAll(Branches.bNames);
         }
            if(user.SelectUsersNames()){
                for (String username : Users.usernames) {
                    listUser.getItems().add(username);
                }
            }
            if(urdal.SelectRoleNames()){
                for (String name : UserRole.names) {
                    combRole.getItems().add(name);
                }   
            }
            combStatus.getItems().addAll("Active","Suspand");
    }
    @FXML private void btn_addUser(ActionEvent evt){
        ActionType="save";
        AfterAction();
    }
    @FXML private void btn_deleteUser(ActionEvent evt){
      if(tempUserName!=null){
            if(Notify.toConfirmPane("Please Make sure you want to delete this user.", "Are you sure to delete")){
              if(user.DeleteByUserName(tempUserName)){
                  if(!tempImgURL.equals("/images/nophoto.png")) {
                      new Delete(tempImgURL,"","");   
                    }
                    AfterAction();
                }
             }
        }else Notify.setMessage("Please Select a name from the list and try again!");
        
    }
    //button add photo action event
    @FXML private void btn_addPhoto(ActionEvent evt){
        imgSourceURL=null;
        imgSourceURL=Chooser.getImageFile("Select User Photo");
        
        imgSaveURL="./img/users/"+this.txtUserName.getText()+"_"+new File(imgSourceURL).getName();
        this.imgUserPhoto.setImage(LoadImage.getImage(imgSourceURL));
        if(imgSourceURL!=null){
             photoActionType="new";
        }else if(imgSourceURL==null){
            photoActionType="old";
        }
    }
    
    //button for save user information
    @FXML private void btn_save(ActionEvent e){
        if(this.txtFullName.getText().equals("") || this.txtUserName.getText().equals("") || this.txtMobile.getText().equals("") || this.tAreaAddress.getText().equals("")){
            Notify.setMessage("Complete the form properly!");
            return;
        }
        if(this.combRole.getValue()==null || this.combStatus.getValue()==null){
            Notify.setMessage("You don't select user type or account status");
            return;
        }
       if(ActionType.equals("save")){
           data_save();
       }else if(ActionType.equals("edit")){
           data_edit();
       }
    }
    
    @FXML private void checkPasswordSame(KeyEvent e){
        if(this.txtNewPassword.getText().equals(this.txtRePassword.getText()) && !txtRePassword.getText().equals("")){
             imgCheckPass.setVisible(true);
            this.imgCheckPass.setImage(new Image("/images/accept.png"));
            savebtn.setDisable(false);
        }else if(!this.txtNewPassword.getText().equals(this.txtRePassword.getText())){
            imgCheckPass.setVisible(true);
             this.imgCheckPass.setImage(new Image("/images/error.png"));
             savebtn.setDisable(true);
        }else if(this.txtNewPassword.getText().equals("") && txtRePassword.getText().equals("")){
            savebtn.setDisable(false);
            imgCheckPass.setVisible(false);
        }
    }

    @FXML private void listClicked(MouseEvent evt){
        setNullFields();
         SelectedItem=listUser.getFocusModel().getFocusedItem().toString();
         if(user.SelectUserBy(0, SelectedItem)){
             setDataToInterface();
             ActionType="edit";
         }
    }
    private void data_edit(){
        if(!this.txtRePassword.getText().equals(ObjUsec.getPassword()) && !txtRePassword.getText().equals("")){
            if(Notify.toConfirmPane("Are sure to change this user password. The use will not allowed to access with previous password! \nClick OK button to confirm ", "Password Change")){
                ObjUsec.setPassword(this.txtRePassword.getText());
            }
        }
        getDataFromInterface();
         
        if(user.update(user.getUserIdByNames(tempUserName))){
            if(photoActionType.equals("old")){
                  AfterAction();
            }else if(photoActionType.equals("new")){
                if(LoadImage.SavedImage(this.imgSourceURL, this.imgSaveURL)){
                    new Delete(tempImgURL,"","");
                     AfterAction();
                }
            }
            Notify.setMessage("The user data edited");
        }
            
    }
    private void data_save(){
        //Set values
           getDataFromInterface();
            
            ObjUsec.setIsOnline(0);
            ObjUsec.setPassword(this.txtRePassword.getText());
            
            //Insert to database

            if(user.insert()){
                if(photoActionType.equals("new")){
                    if(LoadImage.SavedImage(imgSourceURL, this.imgSaveURL)){
                          AfterAction();
                    }
                }else if(photoActionType.equals("old")){
                    AfterAction();
                }
            Notify.setMessage("A new user created");
            }else{
                Notify.setMessage("Sorry! No new user's information stored");
            }
    }
    private void setDataToInterface(){
        getIsOnline(ObjUsec.isIsOnline());
        this.txtFullName.setText(ObjUsec.getFullName());
        txtUserName.setText(ObjUsec.getUserName());
        txtMobile.setText(ObjUsec.getMobile());
        tAreaAddress.setText(ObjUsec.getAddress());
        urdal.SelectRoleBy(ObjUsec.getRoled(),"");
        combRole.setValue(uRole.getTxtRoleName());
        
         brnchDAL.getBranchByName("",ObjUsec.getBranchID());
        this.combBranch.setValue(brnch.getBName());
        
        this.combStatus.setValue(getStatusVale(ObjUsec.isAccoutStatus()));
        if(ObjUsec.getPhotoURL().equals("/images/nophoto.png")){
             this.imgUserPhoto.setImage(vars.noImage);
        }else this.imgUserPhoto.setImage(LoadImage.getImage(ObjUsec.getPhotoURL()));

        tempUserName=ObjUsec.getUserName();
        tempImgURL=ObjUsec.getPhotoURL();
    }

    private void getDataFromInterface(){
        ObjUsec.setFullName(this.txtFullName.getText());
        ObjUsec.setUserName(this.txtUserName.getText());
        ObjUsec.setMobile(this.txtMobile.getText());
        ObjUsec.setAddress(this.tAreaAddress.getText());
        ObjUsec.setRoled(urdal.getRoleIdByNames(this.combRole.getValue().toString()));
        ObjUsec.setAccoutStatus(setStatusValue(combStatus.getValue().toString()));
        
         if(brnchDAL.getBranchByName(combBranch.getValue().toString(),0)){
           ObjUsec.setBranchID(brnch.getBID());
        }
        
        if(photoActionType.equals("new")){
                 ObjUsec.setPhotoURL("./img/users/"+new File(imgSaveURL).getName());
        }else if(ActionType.equals("save") && photoActionType.equals("old")){
                 ObjUsec.setPhotoURL("/images/nophoto.png");
        }
       
    }

   
    private void setNullFields(){
         imgSourceURL=null;
         imgSaveURL=null;
         tempImgURL=null;
         SelectedItem=null;
         ActionType="save";
         photoActionType="old";
        tempUserName=null;
        this.SelectedItem=null;
        this.txtFullName.setText("");
        this.txtUserName.setText("");
        this.txtMobile.setText("");
        this.tAreaAddress.setText("");
        this.txtNewPassword.setText("");
        this.txtRePassword.setText("");
        this.imgUserPhoto.setImage(vars.noImage);
        this.imgCheckPass.setVisible(false);
        imgIsOnline.setVisible(false);
        
    }
    private void AfterAction(){
        this.ActionType="save";
        ObjUsec.setPhotoURL(null);
        setNullFields();
        SynSettings();
    }
    private String getStatusVale(int a){
        if(a==0){
            return "Suspand";
        }else if(a==1){
            return "Active";
        }
        return "Suspand";
    }
      private void getIsOnline(int a){
          imgIsOnline.setVisible(true);
        if(a==0){
            this.imgIsOnline.setImage(new Image("/images/30.png"));
        }else if(a==1){
            this.imgIsOnline.setImage(new Image("/images/31.png"));
        }
    }
    private int setStatusValue(String value){
        if(value.equals("Active")){
            return 1;
        }else{
            return 0;
        }
    }
}
