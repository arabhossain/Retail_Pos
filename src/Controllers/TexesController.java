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



import BusniessObjects.Taxes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import static retail_pos_loader.start.stage;


/**
 * FXML Controller class
 *
 * @author Loser
 */
public class TexesController implements Initializable {
    @FXML private ListView listView;
    @FXML private TextField txtName;
    @FXML private TextField txtValue;
    
    private String selected=null;
    private String ActionType="save";
    
    BusniessObjects.Taxes tax=new BusniessObjects.Taxes();
    DataAccessLayer.TaxesDAL taxdal=new DataAccessLayer.TaxesDAL();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         AppConfig.Config.setTitle("Tax");
        SynSettng();
    } 
     @FXML private void listClick(MouseEvent e){
            this.selected=listView.getFocusModel().getFocusedItem().toString();
            if(selected!=null){
                if(taxdal.selectByNames(selected)){
                    setData();
                    ActionType="edit";
                } 
            }
         
         
     }
    @FXML private void btnSave(ActionEvent evt){
        int a=0;
        if(txtName.getText().equals("")){
            return;
        }
        if(txtValue.getText().equals("")){
            return;
        }
        try{
            a= Integer.parseInt(this.txtValue.getText());
        }catch(NumberFormatException e){
            this.txtValue.setText("");
            return;
        }
       
        tax.setTaxName(txtName.getText());
        tax.setTaxValue(a);
        
       if(ActionType.equals("save")){
           save_data();
       }else if(ActionType.equals("edit")){
           edit_data();
       }   
    }
    @FXML private void btnDelete(ActionEvent evt){
        if(selected!=null){
            if(taxdal.deleteByName(selected)){
                AfterAction();
               JOptionPane.showMessageDialog(null, "deleted!");
            }else JOptionPane.showMessageDialog(null, "not deleted!");
        }else JOptionPane.showMessageDialog(null, "Please Select");
        
    }
    private void save_data(){
        if(taxdal.insert()){
            JOptionPane.showMessageDialog(null, "Data Saved");
            AfterAction();
        }else JOptionPane.showMessageDialog(null, "Data not saved!");
    }
    private void edit_data(){
         if(taxdal.update(selected)){
            JOptionPane.showMessageDialog(null, "Data Edited");
            AfterAction();
        }else JOptionPane.showMessageDialog(null, "Data not Edited!");
    }
    private void setData(){
        this.txtName.setText(tax.getTaxName());this.txtValue.setText(String.valueOf(tax.getTaxValue()));
    }
    private void setNull(){
        this.txtName.setText("");this.txtValue.setText("");
        this.selected=null;
    }
    private void AfterAction(){
        ActionType="save";
        setNull();
        SynSettng();
    }
    private void SynSettng(){
        if(taxdal.getTaxNames()){
            listView.getItems().clear();
             for(int i=0;i<Taxes.taxNames.length;i++){
                 listView.getItems().add(Taxes.taxNames[i]);
             }
        }    
    }
}
