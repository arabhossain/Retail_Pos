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
package retail_pos_loader;


import AppConfig.Config;
import AppConfig.Notify;
import FileIOService.LoadImage;
import FileIOService.WriteFile;
import com.qotsa.jni.controller.WinampController;
import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author Loser
 */
public class start extends Application {

    /**
     *
     */
    public static String url="Login.fxml";

    /**
     *
     */
    public static String title="Login";

    /**
     *
     */
    public static Parent root;

    /**
     *
     */
    public static Stage stage;

    /**
     *
     */
    public static Scene scene;
    @Override
    public void start(Stage Pstage) throws Exception {
        stage=Pstage;
        root = FXMLLoader.load(getClass().getResource("/View/"+url));
        scene = new Scene(root);
        Config.setTitle(title);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        if(title.equals("Login")){
            stage.getIcons().add(LoadImage.from_images("login.png"));
            stage.setMaximized(false);
        }else{
            stage.getIcons().add(LoadImage.from_images("sale_new.png"));
            stage.setMaximized(true);
        }
        stage.show();
   
    }

    public static void main(String[] args){ 
        /* Toolkit.getDefaultToolkit().addPropertyChangeListener(url, pcl);
        Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener(){
        public void eventDispatched(AWTEvent e)
        {
        if(e.get == KeyEvent.KEY_PRESSED)
        {
        boolean dirtyData = true;
        }
        }
        }, AWTEvent.KEY_EVENT_MASK);*/

        try {
        //    Notify.toConsole(System.);
        //   WinampController.run() ;
        } catch (Exception ex) {
            Logger.getLogger(start.class.getName()).log(Level.SEVERE, null, ex);
        }

        try{
         launch(args);
        }catch(Exception e){
            e.printStackTrace();
            new WriteFile("error_start.txt",e.getMessage(),"./");
            JOptionPane.showMessageDialog(null, e.getStackTrace());
        }   
    }
    
}
