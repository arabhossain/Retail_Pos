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
import BusniessObjects.Productcategories;
import DataAccessLayer.ProductcategoriesDAL;
import FileIOService.Delete;
import FileIOService.LoadImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Loser
 */
public class CategoriesProductController implements Initializable {
    @FXML private ListView listView;
    @FXML private TextField txtName;
    @FXML private CheckBox checkVisible;
    @FXML private ImageView imgCat;
    
    
    private String imgSourceURL=null;
    private String imgSaveURL=null;
    private String tempImgURL=null;
    private String SelectedItem;
    private String ActionType="save";
    private String photoActionType="old";
    
    Productcategories pCat=new Productcategories();
    ProductcategoriesDAL pCatDAL=new ProductcategoriesDAL();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         AppConfig.Config.setTitle("Product Categories");
        SnykSetting();
    }    
        @FXML private void listClicked(MouseEvent evt){
        setNull();
         SelectedItem=listView.getFocusModel().getFocusedItem().toString();
         if(pCatDAL.SelectCatByNames(SelectedItem)){
             setData();
             ActionType="edit";
         }
    }
        @FXML private void btnAddNewCat(ActionEvent evt){
            ActionType="save";
            setNull();
        }
    @FXML private void btnAddPhoto(ActionEvent evt){
        imgSourceURL=null;
        imgSourceURL=Chooser.getImageFile("Select Image Of This Categories");
        
        imgSaveURL="./img/Categories/"+this.txtName.getText()+"_"+new File(imgSourceURL).getName();
        this.imgCat.setImage(LoadImage.getImage(imgSourceURL));
        if(imgSourceURL!=null){
             photoActionType="new";
        }else if(imgSourceURL==null){
            photoActionType="old";
        }
    }
    @FXML private void btnRemovePhoto(ActionEvent e){
          this.imgCat.setImage(new Image("/images/cat.png"));
           pCat.setCatPhotoURL("/images/cat.png");
           
          photoActionType="RemovePhoto";
    }
    @FXML private void btnSave(ActionEvent e){
        if(ActionType.equals("save")){
            save_data();
        }else if(ActionType.equals("edit")){
            edit_data();
        }
    }
     @FXML private void btnDeleteCat(ActionEvent evt){
      if(SelectedItem!=null){
          if(Notify.toConfirmPane("Please Make sure you want to delete this categorie.", "Are you sure to delete")){
            if(pCatDAL.delete(SelectedItem)){
                if(!tempImgURL.equals("/images/cat.png")) {
                  new Delete(tempImgURL,"","");   
                }
                 AfterAction();
            }
        }
      }else Notify.toAlartPane("Please Select a name from the list and try again!");
        
     }
    private void save_data(){
        getData();
        if(pCatDAL.insert()){
            if(photoActionType.equals("new")){
                    if(LoadImage.SavedImage(imgSourceURL, this.imgSaveURL)){
                         JOptionPane.showMessageDialog(null, "Data saved");
                          AfterAction();
                    }
                }else if(photoActionType.equals("old")){
                    JOptionPane.showMessageDialog(null, "Data saved with default image");
                    AfterAction();
                }
        }else  JOptionPane.showMessageDialog(null,"Not done");
    }
    private void edit_data(){
         getData();
        if(pCatDAL.update(SelectedItem)){
           if(photoActionType.equals("old")){
                 JOptionPane.showMessageDialog(null, "Data Edited without photo");
                  AfterAction();
            }else if(photoActionType.equals("new")){
                if(LoadImage.SavedImage(this.imgSourceURL, this.imgSaveURL)){
                    JOptionPane.showMessageDialog(null, "Data Edited with new photo");
                    if(!tempImgURL.equals("/images/cat.png")){
                        new Delete(tempImgURL,"","");
                    }
                    
                     AfterAction();
                }else{
                    JOptionPane.showMessageDialog(null, "Data Can't Edit with new photo");
                }
            }else if(photoActionType.equals("RemovePhoto")){
                if(!tempImgURL.equals("/images/cat.png")){
                    new Delete(tempImgURL,"",""); 
                }
            }
        }else  JOptionPane.showMessageDialog(null,"Not done edit");
    }
    private void SnykSetting(){
        if(pCatDAL.SelectCatNames()){
            listView.getItems().clear();
            for(int i=0;i<Productcategories.pCatNames.length;i++){
                    listView.getItems().add(Productcategories.pCatNames[i]);
                  } 
        }
    }
    private void AfterAction(){
        setNull();
        SnykSetting();
    }
    
    private void setNull(){
         imgSourceURL=null;
         imgSaveURL=null;
         tempImgURL=null;
         SelectedItem=null;
         ActionType="save";
         photoActionType="old";
         this.SelectedItem=null;
         this.txtName.setText("");
         this.checkVisible.setSelected(false);
         this.imgCat.setImage(new Image("/images/cat.png"));
    }
    private void getData(){
        pCat.setCatName(this.txtName.getText());
        pCat.setCatVisibile(getCheckBoxValue(checkVisible));
         if(photoActionType.equals("new")){
                 pCat.setCatPhotoURL("./img/Categories/"+new File(imgSaveURL).getName());
        }else if(ActionType.equals("save") && photoActionType.equals("old")){
                 pCat.setCatPhotoURL("/images/cat.png");
        }
        
    }
    private void setData(){
        txtName.setText(pCat.getCatName());
        checkVisible.setSelected(setCheckBoxValue(pCat.getCatVisibile()));
       
        tempImgURL=pCat.getCatPhotoURL();
        
        if(tempImgURL.equals("/images/cat.png")){
             this.imgCat.setImage(new Image("/images/cat.png"));
        }else this.imgCat.setImage(LoadImage.getImage(tempImgURL));
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
