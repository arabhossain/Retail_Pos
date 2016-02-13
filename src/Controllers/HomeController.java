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
import Util.Sysinfo;
import BusniessObjects.Login;
import BusniessObjects.UserRole;
import FileIOService.LoadImage;
import Util.CMD;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import retail_pos_loader.start;
import static retail_pos_loader.start.stage;

/**
 *
 * @author Loser
 */
public class HomeController implements Initializable{
    @FXML  private AnchorPane showPane;
    @FXML  private Label lbl_CP_Name;
     @FXML private Label lbl_PC_User;
     @FXML private Label lblHour;
     @FXML private Label lblMin;
    @FXML  private Label lblSec;
     @FXML private Label lblAM_PM;

    /**
     *
     */
     public Label lblHomeMessege;
     @FXML private BorderPane screen;
     @FXML private ToggleButton isNightMode;
     @FXML private ImageView d;
     @FXML private Accordion navSlider;
     @FXML private ImageView Movers;
     @FXML private Button exit;
     @FXML private Button exit1;
     @FXML private Button logout;
     @FXML private Button logout1;
     
     @FXML private Button mini;
     @FXML private Button mini1;
     @FXML private Label lblUseerName;
     @FXML private Label lblUserType;
     
     @FXML private Button btnsales;
     @FXML private Button btneditsale;
     @FXML private Button btncustomerpayment;
     @FXML private Button btnexpence;
     @FXML private Button btnclosecase;
     @FXML private Button btncustomer;
     @FXML private Button btnMaintanance;
     @FXML private Button btnstoke;
     @FXML private Button btnreports;
     @FXML private Button btnpresencemanage;
     @FXML private Button btntools;
     @FXML private Button btnconfig;
     @FXML private Button btnScreenLock,btnScreenLock1;
     @FXML private ToolBar t1,t2,t3;
     
    //Object Creation
     Config config=new Config();
     Login login=new Login();
     UserRole ur=new UserRole();
   
     //Local Variables
     boolean toggolMode=true;
     boolean toggolSideBar=true;
 
     
    
//~/====================== Start Button Action Event To add FXML Files========================================/~//
    //Register

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
    protected void btn_sales(ActionEvent event) throws Exception{
         Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                        screen.leftProperty().set(null);
                        setToolBar(true);
                        LeftHide();
                        config.addFXML(showPane, "POS");
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
    protected void btn_EditSales(ActionEvent event) throws Exception{
         Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                  SlideBarDefualt();
                   config.addFXML(showPane, "Edit_Sales");
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
    protected void btn_CustomerPayment(ActionEvent event) throws Exception{
          Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                  SlideBarDefualt();
                   config.addFXML(showPane, "Customer_Payment");
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
    protected void btn_Payment(ActionEvent event) throws Exception{
          Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                  SlideBarDefualt();
                  config.addFXML(showPane, "Payments");
                   Notify.progressHide();
                 }
         });
        SlideBarDefualt();
        
    }

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
    protected void btn_CloseCash(ActionEvent event) throws Exception{
         Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                  SlideBarDefualt();
                   config.addFXML(showPane, "Close_Cash");
                   Notify.progressHide();
                 }
         });
        
    }
    
    //Administration----------------------

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
    protected void btn_Customers(ActionEvent event) throws Exception{
          Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                  SlideBarDefualt();
                   config.addFXML(showPane, "Customers");
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
    protected void btn_Maintanance(ActionEvent event) throws Exception{
          Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                  SlideBarDefualt();
                   config.addFXML(showPane, "Maintanance");
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
    protected void btn_Stoke(ActionEvent event) throws Exception{
          Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                  SlideBarDefualt();
                   config.addFXML(showPane, "Stoke");
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
    protected void btn_Reports(ActionEvent event) throws Exception{
          Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                  SlideBarDefualt();
                   config.addFXML(showPane, "Reports");
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
    protected void btn_PresencManage(ActionEvent event) throws Exception{
         Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                  SlideBarDefualt();
                   config.addFXML(showPane, "PraseceManage");
                   Notify.progressHide();
                 }
         });
        
    }
    
    //System------------------------------

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
    protected void btn_tools(ActionEvent event) throws Exception{
         Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                  SlideBarDefualt();
                   config.addFXML(showPane, "Tools");
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
    protected void btn_changePassword(ActionEvent event) throws Exception{
          Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                  SlideBarDefualt();
                   config.addFXML(showPane, "ChangePassword");
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
    protected void btn_Configuration(ActionEvent event) throws Exception{
         Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                  SlideBarDefualt();
                    config.addFXML(showPane, "Configuration");
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
    protected void btn_Printers(ActionEvent event) throws Exception{
        Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                  SlideBarDefualt();
                    config.addFXML(showPane, "Printers");
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
    protected void btn_CheckOuIn(ActionEvent event) throws Exception{
         Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                  SlideBarDefualt();
                    config.addFXML(showPane, "CheckInOut");
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
    protected void btn_logout(ActionEvent event) throws Exception{
         Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                   Notify.progresShow("Session data is cleaning . . .");
                    Platform.runLater(new Runnable() {
                     @Override
                     public void run() {start main=new start();
                            start.url="Login.fxml";
                            start.title="Login";
                            try {
                                main.start(new Stage());
                            } catch (Exception ex) {
                                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            Login.sessionOut();
                            }
                    });
                
                ((Node)(event.getSource())).getScene().getWindow().hide();
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
    protected void btn_minimize(ActionEvent event) throws Exception{
      stage.setIconified(true);
    } 
    
    @FXML private void ScreenLock(ActionEvent e) {
        try{
            CMD.runAsCMD("rundll32.exe user32.dll,LockWorkStation", "Screen Locked!");
        }catch(Exception er){
            
        }
        
    }
    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
    protected void btn_exit(ActionEvent event) throws Exception{
        Login.sessionOut();
        stage.close();
    }
//~/====================== END Button Action Event To add FXML Files========================================/~//
    
    
    //Root pain Mouse hover events 

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
    protected void MouseIn(MouseEvent event) throws Exception{
        Movers.setBlendMode(BlendMode.SRC_OVER);
    }

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
    protected void MouseOut(MouseEvent event) throws Exception{
        Movers.setBlendMode(BlendMode.DIFFERENCE);
    }
    
    //Screen Mood Day and Night button Events

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
    protected void btn_ScreenMode(ActionEvent event) throws Exception{
        if(toggolMode){
          screen.setBlendMode(BlendMode.DIFFERENCE);
          isNightMode.setText("Day Mode");
          toggolMode=false;
      }else if(!toggolMode){
          screen.setBlendMode(BlendMode.SRC_OVER);
          isNightMode.setText("Night Mode");
          toggolMode=true;
      }
    }
    
    // Side-bar Change Home Screen

    /**
     *
     */

     protected void SlideBarDefualt(){
            RightHide();
            screen.leftProperty().set(navSlider);
            setToolBar(false);
    }
    //Left Side hide and Right side show
     private void LeftHide(){
         exit.setVisible(false);
         logout.setVisible(false);
         mini.setVisible(false);
         btnScreenLock.setVisible(false);
        
         
         exit1.setVisible(true);
         logout1.setVisible(true);
         mini1.setVisible(true);
         btnScreenLock1.setVisible(true);
     }
         //Right Side hide and Left side show
     private void RightHide(){
         exit.setVisible(true);
         logout.setVisible(true);
         mini.setVisible(true);
         btnScreenLock.setVisible(true);
         
         exit1.setVisible(false);
         logout1.setVisible(false);
         mini1.setVisible(false);
         btnScreenLock1.setVisible(false);

     }
    private void setToolBar(boolean Value){
        t1.setVisible(Value);t2.setVisible(Value);t3.setVisible(Value);
    }
     
     @Override
    public void initialize(URL url, ResourceBundle rb){
        Config.setTitle("Home");
        // TODO
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                Sysinfo sysinfo=new Sysinfo();
                lbl_PC_User.setText("MAC: "+sysinfo.getMacAddress());
                lbl_CP_Name.setText(sysinfo.getPC_Name());
                lblUseerName.setText(login.getUserName());
                lblUserType.setText(ur.getTxtRoleName());
                if(login.getPhotoURL().equals("/images/nophoto.png")){
                    d.setImage(new Image("/images/sysadmin.png"));
                }else{
                    d.setImage(LoadImage.getImage(login.getPhotoURL()));
                } 
            }
         });

         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                getControlForUrsers();  
          }
         });
      
         RightHide();      
      //  Time Showing Start thread
        Thread clock=new Thread(task_CLOCK);
        clock.setName("Arab-Clock-Thread");
        clock.setDaemon(true);    
        clock.start();
        
        
    } 
 
    /**
     *
     * @return
     */
    public StringProperty newLabel(){
        return lblHomeMessege.textProperty();
    }
    
    // User Access prespective to users are defined========================
    private void getControlForUrsers(){
       this.btnsales.setVisible(getAction(ur.getSales()));
       this.btneditsale.setVisible(getAction(ur.getEditSales()));
       this.btncustomerpayment.setVisible(getAction(ur.getCustomerPayment()));
       this.btnexpence.setVisible(getAction(ur.getExpence()));
       this.btnclosecase.setVisible(getAction(ur.getCashClose()));
       this.btncustomer.setVisible(getAction(ur.getCustomers()));
       this.btnstoke.setVisible(getAction(ur.getStoke()));
       this.btnreports.setVisible(getAction(ur.getReports()));
       this.btnpresencemanage.setVisible(getAction(ur.getPresenceMangae()));
       this.btntools.setVisible(getAction(ur.getTools()));
       this.btnconfig.setVisible(getAction(ur.getConfig()));
       
    }

    /**
     *
     * @param Value
     * @return
     */
    public static boolean getAction(int Value){
        if(Value==0){
            return false;
        }else if(Value==1){
            return true;
        }
        return false;
    }
    
  
    //Initialize Clock with this full class
   private Task<Void> task_CLOCK = new Task<Void>() {
        String Hour="00";
        String Min="00";
        String AmPm="AM";
        String Sec="00";
        public boolean isInternet(){
            if(true){
                return true;
            }else
                return false;
        }
         public void addControls(){
            //Do something here
            
        }
        public void getTime(){
         try{
           SimpleDateFormat fHoure=new SimpleDateFormat("hh");
           SimpleDateFormat fMin=new SimpleDateFormat("mm");
           SimpleDateFormat fSec=new SimpleDateFormat("ss");
           SimpleDateFormat fAmPm=new SimpleDateFormat("aa");
           Hour=fHoure.format(new Date());
           Min=fMin.format(new Date());
           AmPm=fAmPm.format(new Date());
           Sec=fSec.format(new Date());
           
           Platform.runLater(() ->lblHour.setText(Hour)) ;
           Platform.runLater(() ->lblMin.setText(Min));
           Platform.runLater(() ->lblAM_PM.setText(AmPm));
           Platform.runLater(() ->lblSec.setText(Sec));
         }catch(Exception e){e.printStackTrace();}
        }
        @Override 
        protected Void call() throws Exception {
            while(true){
            try {
               getTime();
               isInternet();
               addControls();
              Thread.sleep(1000);                             
              } catch (InterruptedException ex) {
              Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
              }  
            }//Try to set msg
           
        }
    };
    
}