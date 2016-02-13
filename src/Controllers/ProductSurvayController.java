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

import BusniessObjects.Productcategories;
import BusniessObjects.ProductsList;
import DataAccessLayer.ProductcategoriesDAL;
import DataAccessLayer.ProductsListDAL;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Loser
 */
public class ProductSurvayController implements Initializable {
    @FXML private Label lblPName;
    @FXML private CheckBox checkStatus;
    @FXML private TextField txtSearchByName;
    @FXML private ComboBox comboCat,comboShortByAI;
    @FXML private ListView listView;
    /**
     * Initializes the controller class.
     */
    ProductsList pList=new ProductsList();
    ProductsListDAL pListDAL=new ProductsListDAL();
    ProductcategoriesDAL pCatDAL =new ProductcategoriesDAL();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         AppConfig.Config.setTitle("Product Survay");
        Snyc();
         if(pCatDAL.SelectCatNames()){
            this.comboCat.getItems().clear();
             comboCat.getItems().add("All View");
            for(int i=0;i<Productcategories.pCatNames.length;i++){
                    comboCat.getItems().add(Productcategories.pCatNames[i]);
                  } 
        }
        comboShortByAI.getItems().addAll("All View", "Active","Invactive");
    }
    
    @FXML private void btnSave(ActionEvent e){
        pList.setPVisible(this.getCheckBoxValue(checkStatus));
        if(pListDAL.updateVisibility(SelectedPID)){
            JOptionPane.showMessageDialog(null, "Your action has done! Please check it because it is for the fast time ");
        }
    }
    @FXML private void SearchByName(KeyEvent e){
        this.comboCat.setValue("All View");this.comboShortByAI.setValue("All View");
         if(!this.txtSearchByName.getText().equals("")){
            pListDAL.getFilterProducts(0, this.txtSearchByName.getText());
        }else if(this.txtSearchByName.getText().equals("")){
            pListDAL.getProductsNames();
        }
        listView.getItems().clear();
        for(int i=0;i<ProductsList.pLists.length;i++){
            listView.getItems().add(ProductsList.pLists[i]);
        }
    }
    @FXML private void shortByCat(MouseEvent e){
        this.txtSearchByName.setText("");this.comboShortByAI.setValue("All View");
       comboCat.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
        public void changed(ObservableValue<? extends String> observable,String oldValue,String newValue){
             if(newValue==null){
            return;
            }
             if(newValue!=null && !comboCat.getValue().toString().equals("All View")){
                pListDAL.getFilterProducts(pCatDAL.getpCatIdByName(newValue),null);
            }else if(newValue.equals("All View")){
                pListDAL.getProductsNames();
            }
            listView.getItems().clear();
            for(int i=0;i<ProductsList.pLists.length;i++){
                listView.getItems().add(ProductsList.pLists[i]);
            }
        }
      });
       
    }
    @FXML private void shortByAI(MouseEvent e){
         this.txtSearchByName.setText("");this.comboCat.setValue("All View");
         comboShortByAI.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> observable,String oldValue,String newValue){
                   if(newValue==null){
                        return;
                    }
                     if(newValue!=null && !newValue.equals("All View")){
                        pListDAL.getFilterProducts(newValue);
                    }else if(newValue.equals("All View")){
                        pListDAL.getProductsNames();
                    }
                    listView.getItems().clear();
                    for(int i=0;i<ProductsList.pLists.length;i++){
                        listView.getItems().add(ProductsList.pLists[i]);
                    }
            }
          });
    }
     @FXML private void listClicked(MouseEvent e){
        int id=listView.getFocusModel().getFocusedIndex();
         SelectedPID=ProductsList.pIDs[id];
         if(pListDAL.getProductBy(SelectedPID,null,null)){
            this.lblPName.setText(pList.getPName());
            this.checkStatus.setSelected(setCheckBoxValue(pList.getPVisible()));
         }
    }
    
    private String SelectedPID;
    //---------------------=-------------------------\\
    private void Snyc(){
         if(pListDAL.getProductsNames()){
            listView.getItems().clear();
            for(int i=0;i<ProductsList.pLists.length;i++){
                    listView.getItems().add(ProductsList.pLists[i]);
                  } 
        }
    }
    private int getCheckBoxValue(CheckBox checkVisible){
        if(checkVisible.isSelected()){
            return 1;
        }else if(!checkVisible.isSelected()){
            return 0;
        }
        return 0;
    }
    private boolean setCheckBoxValue(int Value){
        if(Value==1){
            return true;
        }else if(Value==0){
            return false;
        }return false;
    }
}
