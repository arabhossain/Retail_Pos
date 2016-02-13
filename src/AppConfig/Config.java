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
package AppConfig;

import FileIOService.Cloud_config_read;
import FileIOService.Local_config_read;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import retail_pos_loader.start;
import static retail_pos_loader.start.stage;




/**
 *
 * @author Loser
 */
public class Config {
    /**
     *  Default Constractor
     */
    public Config(){
        new Local_config_read();
        new Cloud_config_read();
    }
   
   //

    /**
     *  FXML Files Loader with same window
     * @param PaneName
     * @param fileName
     */
     public void addFXML(AnchorPane PaneName,String fileName){
      PaneName.getChildren().clear();
        try {
            PaneName.getChildren().add((Node) FXMLLoader.load(getClass().getResource("/View/"+fileName+".fxml")));
        } catch (IOException ex) {
            Notify.toConsole(fileName+ ".fxml file can't be loaded!");
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param title
     */
    public static void setTitle(String title){
         stage.setTitle(title+" || "+vars.APP_VERSION);
    }
    public static Double getDiscount(Double getPercent, Double Value){
        return Value-(Value*getPercent/100);
    }
    public static double getPercent(double getPercentValue,double Value){
        return Value*getPercentValue/100;
    }

    /**
     *
     * @param ch
     * @return
     */
    public static int getCheckBoxValue(CheckBox ch){
       if(ch.isSelected()){
            return 1;
        }else return 0;
    }

    /**
     *
     * @param ch
     * @param value
     */
    public static void setCheckBoxValue(CheckBox ch, int value){
        if(value==0){
            ch.setSelected(false);
        }else if(value==1){
            ch.setSelected(true);
        }
    }
    public static void setOpacityForHome(Double value){
        try{
        Accordion menu = (Accordion) start.root.lookup("#navSlider");
        AnchorPane Canvas=(AnchorPane) start.root.lookup("#showPane"); 
         if (menu != null) {
            menu.setOpacity(value);
         }
         if (Canvas != null) {
           Canvas.setOpacity(value);
         }
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
