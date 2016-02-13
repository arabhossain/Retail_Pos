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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author Loser
 */
public class LocalDataImportController implements Initializable {
    @FXML private TextField url;
    @FXML private ProgressBar progrs;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         AppConfig.Config.setTitle("Local Data Import");
    }    
    
    @FXML private void btnBrowse(ActionEvent e){
        String fc=Chooser.getSqlFile("Select A Database File");
        url.setText(Chooser.toSimpleURL(fc));
    }
    @FXML private void btnImport(ActionEvent e){
          Task<Void> task = new Task<Void>(){
                @Override
                public Void call(){
                    int max = 100000000;
                    progrs.setVisible(true);
                    for (int i=1; i<=max; i++) {
                        updateProgress(i, max);
                        succeeded(i);
                    }
                    
                    return null;
                }

              private void succeeded(int v) {
                  if(v==100000000){
                      progrs.setVisible(false);
                      cancel(true);
                  }
              }
            }; 
     progrs.progressProperty().bind(task.progressProperty());
     new Thread(task).start();
     
    }
}
