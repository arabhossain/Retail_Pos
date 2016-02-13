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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Loser
 */
public class ReportsController implements Initializable {
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
         AppConfig.Config.setTitle("Reports");
    }    

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_TopSales(ActionEvent event) throws Exception{
      config.addFXML(ShowPen, "Products");
    }

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_TopCustomers(ActionEvent event) throws Exception{
      config.addFXML(ShowPen, "CategoriesProduct");
    }

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_TopProducts(ActionEvent event) throws Exception{
      config.addFXML(ShowPen, "ProductSurvay");
    }

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_SaleByUser(ActionEvent event) throws Exception{
      config.addFXML(ShowPen, "ProductSurvay");
    }

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_PriceChange(ActionEvent event) throws Exception{
      config.addFXML(ShowPen, "ProductSurvay");
    }

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_ProductList(ActionEvent event) throws Exception{
      config.addFXML(ShowPen, "ProductSurvay");
    }

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_CustomerList(ActionEvent event) throws Exception{
      config.addFXML(ShowPen, "ProductSurvay");
    }

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_UserList(ActionEvent event) throws Exception{
      config.addFXML(ShowPen, "ProductSurvay");
    }

    /**
     *
     * @param event
     * @throws Exception
     */
    @FXML
     protected void btn_UserLeave(ActionEvent event) throws Exception{
      config.addFXML(ShowPen, "ProductSurvay");
    }
}
