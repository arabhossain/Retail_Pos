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
import BusniessObjects.Login;
import BusniessObjects.UserRole;
import DataAccessLayer.UserRoleDAL;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Loser
 */
public class MaintananceController implements Initializable {
    //FXML Variables
    
    @FXML  private AnchorPane ShowPen;
    @FXML private Button btnUsers;
    @FXML private Button btnrole;
    @FXML private Button btntax;
    
    //Local variables
    
    //Objects
    Config config=new Config();
    UserRole ur=new UserRole();
    Login login=new Login();
    UserRoleDAL urdal=new UserRoleDAL();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         AppConfig.Config.setTitle("Maintainance");
        if(urdal.SelectRoleBy(login.getUserType(),"")){
            this.btnrole.setVisible(HomeController.getAction(ur.getUserRole()));
            this.btntax.setVisible(HomeController.getAction(ur.getTaxes()));
            this.btnUsers.setVisible(HomeController.getAction(ur.getUsers()));
           
        }
        
    }
    
    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_Users(ActionEvent event) throws Exception{
         Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                 config.addFXML(ShowPen, "Users");
                 Notify.progressHide();
                 }
         });
      
    }

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_Role(ActionEvent event) throws Exception{
         Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                 config.addFXML(ShowPen, "UserRole");
                 Notify.progressHide();
                 }
         });
      
    }

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_Texes(ActionEvent event) throws Exception{
         Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                  config.addFXML(ShowPen, "Texes");
                 Notify.progressHide();
                 }
         });
     
    }
}
