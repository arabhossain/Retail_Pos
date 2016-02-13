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

import BusniessObjects.Leavelist;
import BusniessObjects.Login;
import DataAccessLayer.LeavelistDAL;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author Loser
 */
public class LeavesController implements Initializable {
    @FXML private ListView listView;
    @FXML private AnchorPane viewPane,addPane;
    @FXML private Label vstuffID,vName,vStartDate,vEndDate,vApprove,vSeenAt,rID,rName;
    @FXML private TextArea rdescription,vReasion;
    @FXML private DatePicker rStartDate,rEndDate;
    @FXML private ComboBox rRequestToStuff;
    
    int SelectedItem;
    
    Leavelist lList=new Leavelist();
    LeavelistDAL lListDAL=new LeavelistDAL();
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         AppConfig.Config.setTitle("Leave");
         this.rID.setText(String.valueOf(login.getUserId()));
         this.rName.setText(login.getUserName());
        Snyc();
    }    
    @FXML private void btnSendRequest(ActionEvent e){
        getData();
        if(lListDAL.insert()){
            JOptionPane.showMessageDialog(null,addPane);
            viewPane.setVisible(false);
            addPane.setVisible(false);
        }
        
    }
    @FXML private void btnCreateRequest(ActionEvent e){
        this.vstuffID.setText(String.valueOf(login.getUserId()));
        this.vName.setText(login.getUserName());
        viewPane.setVisible(false);
        addPane.setVisible(true);
    }
    @FXML private void listClicked(MouseEvent e){

         SelectedItem=Leavelist.LIDs[listView.getFocusModel().getFocusedIndex()];
         if(lListDAL.SelectByID(SelectedItem)){
             setData();
         }
    }
    
    
    ///
    private void Snyc(){
          if(lListDAL.LeaveLists()){
            listView.getItems().clear();
            for(int i=0;i<Leavelist.LIDs.length;i++){
                    listView.getItems().add(Leavelist.StartEnds[i]);
                  } 
        }
    }
    private void getData(){
        String pattern = "yyyy-MM-dd";
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
        SimpleDateFormat format = new SimpleDateFormat(pattern);

        Date sdate=java.sql.Date.valueOf(rStartDate.getValue());
        Date edate=java.sql.Date.valueOf(rEndDate.getValue());
        lList.setLStuffID(Integer.parseInt(this.rID.getText()));
        lList.setLReasion(this.rdescription.getText());
        /*  try {
        lList.setLStartDate(dateFormatter.);
        lList.setLEndDate(dateFormatter.parse(edate.toString()));
        } catch (ParseException ex) {
        Logger.getLogger(LeavesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        lList.setLRequestStuffID(0);
    }
    Login login=new Login();
    private void setData(){
        String a = null;
        String approved=null;
        this.vstuffID.setText(String.valueOf(login.getUserId()));
        this.vName.setText(login.getUserName());
        this.vStartDate.setText(lList.getLStartDate().toString());
        this.vEndDate.setText(lList.getLEndDate().toString());
        vReasion.setText(lList.getLReasion());
        if(lList.getLRequestSeenAt().getTime()==0){
            a="Not Seen Yet";
        }else if(lList.getLRequestSeenAt().getTime()!=0){
            a=lList.getLRequestSeenAt().toString();
        }
        this.vSeenAt.setText(a);
        if(lList.getLApproved()==0){
            approved="You have not permitted to leave yet";
        }else if(lList.getLApproved()==1){
            approved="Congratulation... Your leave permission has been accepted";
        }
        this.vApprove.setText(approved);
        viewPane.setVisible(true);
        addPane.setVisible(false);
    }
}
