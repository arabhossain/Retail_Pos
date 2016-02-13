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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Loser
 */
public class StokeController implements Initializable {
    // FXML variables
    @FXML private AnchorPane ShowPen;
    
    //Local Objects
    
    Config config=new Config();
    /**
     Initializes the controller class.
     * @param url
     * @param rb
    **/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         AppConfig.Config.setTitle("Stoke");
    }    

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_Products(ActionEvent event) throws Exception{
         Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                 config.addFXML(ShowPen, "Products");
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
     protected void btn_Categories(ActionEvent event) throws Exception{
         Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                 config.addFXML(ShowPen, "CategoriesProduct");
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
     protected void btn_units(ActionEvent event) throws Exception{
         Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                 config.addFXML(ShowPen, "ProductsUnits");
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
     protected void btn_Survay(ActionEvent event) throws Exception{
         Notify.progresShow("Loading . . .");
         Platform.runLater(new Runnable() {
          @Override
          public void run() {
                 config.addFXML(ShowPen, "ProductSurvay");
                 Notify.progressHide();
                 }
         });
      
    }
    
}
