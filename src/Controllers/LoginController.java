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
import AppConfig.vars;
import BusniessObjects.Branches;
import BusniessObjects.Login;
import DataAccessLayer.BranchesDAL;
import DataAccessLayer.LoginDAL;
import DataAccessLayer.UserRoleDAL;
import Sound.PlaySound;
import Util.BasicException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import retail_pos_loader.start;
import static retail_pos_loader.start.stage;

/**
 * FXML Controller class
 *
 * @author Loser
 */
public class LoginController implements Initializable  {
   
    @FXML private TextField txt_User;
    @FXML private PasswordField txt_pass;
    @FXML private Label lblMessege;
    @FXML private Button btns;
    Config config=new Config();
    Login lba=new Login();
    LoginDAL loginDAL=new LoginDAL();
    UserRoleDAL urDAL=new UserRoleDAL();
    Branches brnch=new Branches();
    BranchesDAL branchDAL=new BranchesDAL();
    
    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
    protected void btn_Drage(MouseEvent event) throws Exception{
                stage.setX(event.getScreenX());
                stage.setY(event.getScreenY());
                
    }
    
    @FXML
    private void btn_Login(ActionEvent event) throws Exception{
          if(loginDAL.verifyUser(this.txt_User.getText(), this.txt_pass.getText())){
                if(!lba.getUserName().equals("") && lba.getUserType()!=0){
                    if(lba.getAccountStatus()==1){
                        if(lba.getUserBranch()==vars.getBranchID()){
                            Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        urDAL.SelectRoleBy(lba.getUserType(),"");
                                        loginDAL.setUserAsOnline();
                                    }
                            });
                            
                              Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        start main=new start();
                                        start.url="Home.fxml";
                                        start.title="Home";
                                        try {
                                            main.start(new Stage());
                                        } catch (Exception ex) {
                                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        finally{
                                             ((Node)(event.getSource())).getScene().getWindow().hide();
                                        }
                                    }
                              });
                           
                           
                        }else{
                            PlaySound.ErrorSound();
                            branchDAL.getBranchByName("",lba.getUserBranch());
                            lblMessege.setText("You can't access in the system from this branch!\nSystem finds you are a member of "+brnch.getBName()+" branch.");
                        }
                        
                    }else if(lba.getAccountStatus()==0){
                        PlaySound.ErrorSound();
                        lblMessege.setText("Your Account has suspanded!\n Please contuct to administrator!");
                    }else{
                        PlaySound.ErrorSound();
                        lblMessege.setText("Sorry, You can't access to the system. \nSystem catch you as an unauthorized user!");
                    }
                   
                    
                }else NotLoged();
        }else NotLoged();        
    }
    @FXML private void btn_Exit(ActionEvent evt){
       stage.close();
    }
    
    @FXML private void UserNameKeyReleased(KeyEvent evt){
        this.lblMessege.setText("");
    }

    private void NotLoged() throws BasicException{
        lblMessege.setText("Your given information is not valide! Please try or contuct to administration \n Thank you!");
        PlaySound.ErrorSound();
    }
        

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
     
    }    
    
}
