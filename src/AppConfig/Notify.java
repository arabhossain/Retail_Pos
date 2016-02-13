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

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import retail_pos_loader.start;
import static retail_pos_loader.start.stage;

/**
 *
 * @author Loser
 */
public final class Notify {
    private static String msg;

    /**
     *
     * @param msg
     */
    public final static void toConsole(String msg){
       System.out.println(msg);
    }

    /**
     *
     * @param msg
     */
    public final static void toConsole(char msg){
       System.out.println(msg);
    }

    /**
     *
     * @param msg
     */
    public final static void toConsole(int msg){
       System.out.println(msg);
    }

    /**
     *
     * @param msg
     */
    public final static void toConsole(Object msg){
       System.out.println(msg);
    }
    
    /**
     *
     * @param msg
     */
    public final static void toInfoPane(String msg){
         Alert alrt=new Alert(Alert.AlertType.NONE);
        alrt.setTitle("Message");
       // alrt.setHeaderText("This is header text");
        alrt.setContentText(msg);
        alrt.showAndWait();
    //   JOptionPane.showMessageDialog(null, msg);
    }

    /**
     *
     * @param msg
     */
    public final static void toErrorPane(String msg){
         Alert alrt=new Alert(Alert.AlertType.ERROR);
        alrt.setTitle("Error Message");
       // alrt.setHeaderText("This is header text");
        alrt.setContentText(msg);
        alrt.showAndWait();
     //  JOptionPane.showMessageDialog(null, msg, "Error Message",JOptionPane.ERROR_MESSAGE);
    }

    /**
     *
     * @param msg
     */
    public final static void toSimplePane(String msg){
        Alert alrt=new Alert(Alert.AlertType.INFORMATION);
        alrt.setTitle("Message");
       // alrt.setHeaderText("This is header text");
        alrt.setContentText(msg);
        alrt.showAndWait();
      // JOptionPane.showMessageDialog(null, msg,"Message",JOptionPane.CLOSED_OPTION);
    }

    /**
     *
     * @param msg
     */
    public final static void toAlartPane(String msg){
        Alert alrt=new Alert(Alert.AlertType.WARNING);
        alrt.setTitle("Warning Message");
       // alrt.setHeaderText("This is header text");
        alrt.setContentText(msg);
        alrt.showAndWait();
    //   JOptionPane.showMessageDialog(null, msg,"Warning Message",JOptionPane.CANCEL_OPTION);
    }



    /**
     *
     * @param msg
     * @param title
     * @return
     */
    public final static boolean toConfirmPane(String msg, String title){
       
        String type;
        Alert alrt=new Alert(Alert.AlertType.CONFIRMATION);
        alrt.getDialogPane().toFront();
        alrt.setTitle("Confirmation");
        alrt.setHeaderText(title);
        alrt.setContentText(msg);
        alrt.initOwner(stage);
        type=alrt.showAndWait().get().getText();
        if(type.equals("OK")){
            return true;
        }else if(type.equals("Cancel")){
            return false;
        }else
             return false; 
    }


    private static  Thread erese_megese_thread;

    /**
     *
     * @param msgs
     */
    public static void setMessage(String msgs) {
        Label lblData = (Label) start.root.lookup("#lblHomeMessege");
        ProgressBar p=(ProgressBar) start.root.lookup("#ProgressMassege");
        p.setVisible(false);
        lblData.setVisible(true);
        if (lblData != null) {
           Platform.runLater(() -> lblData.setText(msgs));
        }
        erese_megese_thread=new Thread(erese_messege);
        erese_megese_thread.setName("MsgClearThread");
        erese_megese_thread.start();
    }
   
    private static final Task<Void> erese_messege = new Task<Void>() {
        @Override 
        protected Void call() throws Exception {
            while(true){
            try {
                Thread.sleep(10000);
                Label lblData = (Label) start.root.lookup("#lblHomeMessege");
                if (lblData != null) {
                    Platform.runLater(() -> lblData.setText(""));
                }
            } catch (InterruptedException ex) {
                    Logger.getLogger(Notify.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
          //  return null;  
        }
        
     };
    public static void progresShow(String msgs){
        ProgressBar p=(ProgressBar) start.root.lookup("#ProgressMassege");
        Label lblData = (Label) start.root.lookup("#lblHomeMessege");
        p.setVisible(true);
        lblData.setVisible(false);
       // p.setTooltip(Tooltip.);.setValue(msg);
        p.setProgress(-1);
    }
    public static void progressHide(){
        ProgressBar p=(ProgressBar) start.root.lookup("#ProgressMassege");
        Label lblData = (Label) start.root.lookup("#lblHomeMessege");
        p.setVisible(false);
        lblData.setVisible(false);
    }
}

