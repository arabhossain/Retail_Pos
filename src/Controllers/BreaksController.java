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
import BusniessObjects.Breaks;
import DataAccessLayer.BreaksDAL;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 *
 * @author Loser
 */
public class BreaksController implements Initializable {

    @FXML private ListView listView;
    @FXML private TextField txtName,txtTime;
    @FXML private CheckBox cheekVisible;
    @FXML private TextArea txtNote;
    
    private int SelectedID;
    private String ActionType="save";
    
    Breaks brk=new Breaks();
    BreaksDAL brkDAL=new BreaksDAL();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Config.setTitle("Breaks");
        Snyc();
    }    
    
    @FXML private void listClicked(MouseEvent e){
         SelectedID=Breaks.bIDs[listView.getFocusModel().getFocusedIndex()];
         if(brkDAL.SelectBreakByID(SelectedID)){
             setData();
             ActionType="edit";
         }
    }
    
    @FXML private void btnAddBreak(ActionEvent e){
            setNull();
            ActionType="save";
    }
    
    @FXML private void btnDelete(ActionEvent e){
        if(SelectedID!=0){
            if(Notify.toConfirmPane("Please Make sure you want to delete this user.", "Are you sure to delete")){
                if(brkDAL.deleteByID(SelectedID)){
                    AfterAction();
               }
            }
        }else
            Notify.setMessage("Please select item and try again later");
    }
    
    @FXML private void btnSave(ActionEvent e){
        try{
            Integer.parseInt(this.txtTime.getText());
        }catch(Exception er){
            Notify.setMessage("Error! Invilid Time Field Format. Try agin i.e 3,30,60 ");
            this.txtTime.setText("");
            return;
        }
         getData();
        if(ActionType.equals("save")){
            if(brkDAL.insert()){
                AfterAction();
            }
        }else if(ActionType.equals("edit")){
            if(brkDAL.update(SelectedID)){
                AfterAction();
            }
        }
    }
    
    
    private void Snyc(){
         if(brkDAL.getBreaksNames()){
            listView.getItems().clear();
            for(int i=0;i<Breaks.bIDs.length;i++){
                    listView.getItems().add(Breaks.bNames[i]);
                  } 
        }
    }
    private void setData(){
        this.txtName.setText(brk.getBName());
        Config.setCheckBoxValue(cheekVisible, brk.getBVisibility());
        this.txtTime.setText(brk.getBTime());
        this.txtNote.setText(brk.getBNote());
    }
    private void getData(){
        brk.setBName(this.txtName.getText());
        brk.setBVisibility(Config.getCheckBoxValue(cheekVisible));
        brk.setBNote(this.txtNote.getText());
        brk.setBTime(this.txtTime.getText());
    }
    private void AfterAction(){
        Snyc();
        setNull();
    }
    private void setNull(){
        this.txtName.setText("");
        this.cheekVisible.setSelected(false);
        this.txtTime.setText("");
        this.txtNote.setText("");
        SelectedID=0;
    }
}
