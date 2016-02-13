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

import BusniessObjects.Productunits;
import DataAccessLayer.ProductunitsDAL;
import FileIOService.Delete;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Loser
 */
public class ProductsUnitsController implements Initializable {
    @FXML private ListView listView;
    @FXML private TextField txtName;
    
    
    private String SelectedItem;
    private String ActionType="save";
    
    Productunits pUnit=new Productunits();
    ProductunitsDAL pUnitDAL=new ProductunitsDAL();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         AppConfig.Config.setTitle("Product Units");
        SynkSetting();
    }
     @FXML private void listClicked(MouseEvent evt){
         SelectedItem=null;
         SelectedItem=listView.getFocusModel().getFocusedItem().toString();
         if(SelectedItem!=null){
             this.txtName.setText(SelectedItem);
             ActionType="edit";
         }
    }
     @FXML private void btnAddNewUnit(ActionEvent evt){
             this.txtName.setText("");
            ActionType="save";
           
        }
     @FXML private void btnDeleteUnit(ActionEvent evt){
           int a;
       a=JOptionPane.showConfirmDialog(null,"Please Make sure you want to delete this user.","Are you sure to delete",JOptionPane.OK_CANCEL_OPTION);
       if(a==0){
           //Do if pressed YES option from the confirm dilog box
           if(pUnitDAL.deleteByName(SelectedItem) && SelectedItem!=null){
                AfterAction();
                return;
           }else JOptionPane.showMessageDialog(null, "Please Select a name from the list and try again!");
       }else if(a==2){
           // Do what if user pressed the cencel button
           return;
       }
     }
    @FXML private void btnSave(ActionEvent e){
        pUnit.setPUniName(txtName.getText());
        if(ActionType.equals("save")){
            if(pUnitDAL.insert()){
                AfterAction();
            }
        }else if(ActionType.equals("edit")){
            if(pUnitDAL.update(SelectedItem)){
                AfterAction();
            }
        }
    }
    private void SynkSetting(){
        if(pUnitDAL.getUnitNames()){
            listView.getItems().clear();
            for(int i=0;i<Productunits.pUnitNames.length;i++){
                    listView.getItems().add(Productunits.pUnitNames[i]);
                  } 
        }
    }
    private void AfterAction(){
        SynkSetting();
        setNull();
    }
    private void setNull(){
        this.txtName.setText("");
        SelectedItem=null;
    }
}
