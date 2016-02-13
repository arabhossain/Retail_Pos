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
import BusniessObjects.Breaks;
import DataAccessLayer.BreaksDAL;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import retail_pos_loader.start;


/**
 * FXML Controller class
 *
 * @author Loser
 */
public class CheckInOutController implements Initializable {
    @FXML private GridPane gPane;
    @FXML private Label lblRemainingTimeShowing,lblLateTimeShowing;
    @FXML private Pane paneRemaining,paneLate;
    
    private static boolean isIn=false;
    BreaksDAL brkDAL=new BreaksDAL();
    private int BreakID;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         AppConfig.Config.setTitle("Check In/Out");
         Snyc();
         gPane.setVisible(!isIn);
         this.btnIn.setVisible(isIn);
    }    
    
     private void Snyc(){
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                if(brkDAL.getBreaksIfVisible()){
                    gPane.getChildren().clear();
                        int temp=Breaks.bIDs.length/2;
                        gPane.addColumn(2);
                        int i=0;
                        while(true){
                            for(int row=0; row<=temp;row++){
                                for(int col=0; col<2;col++){
                                    gPane.add(addButton(Breaks.bIDs[i],Breaks.bNames[i]), col, row);
                                    i++;
                                    if(i==Breaks.bIDs.length)return;
                                }
                            }
                            break;
                        }
                }else {
                     gPane.getChildren().clear();
                }
            }
        });
    }
     private Button addButton( int btnID, String btnText) {
       Button btn=new Button();
       btn.setStyle("-fx-pref-width: 150px; -fx-pref-height: 50px");
        if (btnText != null && !btnText.equals("")){
             btn.setText(btnText);
        }else btn.setText("NO NAME");
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                 try {                    
                  btnFireAction(btnID);
                }catch (Exception e) {

                }
            }
        });
        
        return btn;
     }
   @FXML private Button btnIn; 
   @FXML private void hndlebtnIn(ActionEvent e){
       isIn=false;
       t.resume();
       btnIn.setVisible(false);
       gPane.setVisible(true);
       this.paneLate.setVisible(false);
       this.paneRemaining.setVisible(false);
        visualForIn();
   }
        static Thread t;
        int count=1;
        long EndMinutes = 0;
    private void btnFireAction(int btnID){
        BreakID=btnID;
        isIn=true;
        count=1;
        EndMinutes = 0;
        t= new Thread(task_CLOCK);
        t.setName("Arab-Breaks Timer");
        t.start();
        t.resume();
        btnIn.setVisible(true);
        gPane.setVisible(false);
        visualForOut();
    }
    Accordion navSlider;
    private void visualForOut(){
        try{
          BorderPane screen=(BorderPane) start.root.lookup("#screen"); 
          Notify.progresShow("Loading . . .");
          Platform.runLater(() -> {
              if (screen != null) {
                  navSlider=(Accordion) start.root.lookup("#navSlider"); 
                  screen.leftProperty().set(null);
                  Notify.progressHide();
              }
          });
        }catch(Exception e){ e.printStackTrace();}
    }
     private void visualForIn(){
          BorderPane screen=(BorderPane) start.root.lookup("#screen"); 
          
          Notify.progresShow("Loading . . .");
          Platform.runLater(() -> {
              if (screen != null) {
                  if(navSlider != null){
                      screen.leftProperty().set(navSlider);
                      Notify.progressHide();
                  }
                  
              }
          });
    }
     private final Task<Void> task_CLOCK = new Task<Void>() {
        String RecentT="00";     
      //  String endTime="";
      //  Date d1 = null;
       // Date d2 = null;
        long diffinMinuts ;
        private NumberFormat m_format = new DecimalFormat("#,#00");
        
        
        private long getTimeUpdate(){
            long StartMinutes = 0;
            SimpleDateFormat simpleFormat = new SimpleDateFormat("HH:mm:ss");  
            try { 
                RecentT=simpleFormat.format(new Date());
                StartMinutes = simpleFormat.parse(RecentT).getTime() / (60 * 1000) % 60;
            } catch (ParseException ex) {
                Logger.getLogger(CheckInOutController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return StartMinutes;
        }
        BreaksDAL brkDAL=new BreaksDAL();
        Breaks brk=new Breaks();
        private long getEndTime(){
            while(count==1){
                if(brkDAL.SelectBreakByID(BreakID)){
                     EndMinutes=getTimeUpdate()+Integer.parseInt(brk.getBTime());
                      count++;
                }
               
            }
            return EndMinutes;
        }
        
        private void getCalculateTime(){
         try{
            diffinMinuts =  getEndTime() - getTimeUpdate();
            if(diffinMinuts>=0 && diffinMinuts<=10){
                 paneRemaining.setVisible(true);
                 paneLate.setVisible(false);
                 Platform.runLater(() ->lblRemainingTimeShowing.setText( m_format.format(diffinMinuts)));
            }else if(diffinMinuts>10){
                 paneRemaining.setVisible(true);
                 paneLate.setVisible(false);
                 Platform.runLater(() ->lblRemainingTimeShowing.setText(String.valueOf(diffinMinuts)));
            }
            else{
                 Platform.runLater(() ->lblLateTimeShowing.setText(String.valueOf(diffinMinuts*-1)));
                 paneRemaining.setVisible(false);
                 paneLate.setVisible(true);
            }
               
                
         }catch(Exception e){e.printStackTrace();}
        }
        @Override 
        protected Void call() throws Exception {
            while(true){
                try {
                  if(isIn)
                    getCalculateTime();
                    Thread.sleep(1000);                             
                }catch (InterruptedException ex) {
                  Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }
          // return null;
        }
    };
}
