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

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import static retail_pos_loader.start.stage;

/**
 * FXML Controller class
 *
 * @author Loser
 */
public class LocalDataExportController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         AppConfig.Config.setTitle("Local Data Export");
    }
@FXML private void saave(ActionEvent e) {
        FileChooser f=new FileChooser();
        f.setTitle("Browse and select user's profile photo");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Database File", "*.sql");
        f.getExtensionFilters().add(extFilter);
     //   f.setInitialDirectory(new File("./src/images/"));
     //   f.setInitialFileName("arab.txt");
        f.showSaveDialog(stage);
}   
    
}
