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
import java.net.URL;
import java.util.ResourceBundle;
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
public class ToolsController implements Initializable {
    // FXML variables
    @FXML private AnchorPane ShowPen;
    @FXML private Button LocalDataImport;
    
    
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
         AppConfig.Config.setTitle("Tools");
    }    

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_LocalDataImport(ActionEvent event) throws Exception{
      config.addFXML(ShowPen, "LocalDataImport");
    }

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_OnlineDataImport(ActionEvent event) throws Exception{
      config.addFXML(ShowPen, "OnlineDataImport");
    }

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_LocalDataExport(ActionEvent event) throws Exception{
      config.addFXML(ShowPen, "LocalDataExport");
    }

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_OnlineDataExport(ActionEvent event) throws Exception{
      config.addFXML(ShowPen, "OnlineDataExport");
    }

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_OnlineAccount(ActionEvent event) throws Exception{
      config.addFXML(ShowPen, "OnlineAccount");
    }

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_WipeData(ActionEvent event) throws Exception{
      config.addFXML(ShowPen, "WipeData");
    }

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_Restore(ActionEvent event) throws Exception{
      config.addFXML(ShowPen, "Restore");
    }
    
}
