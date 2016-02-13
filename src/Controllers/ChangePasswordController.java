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

import DataAccessLayer.LoginDAL;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;
import static retail_pos_loader.start.stage;

/**
 * FXML Controller class
 *
 * @author Loser
 */
public class ChangePasswordController implements Initializable {
    
     @FXML private TextField Old;
     @FXML private TextField New;
     @FXML private TextField Re;
     @FXML private ImageView imgRe;
     @FXML private Button btnChangePass;
     
     LoginDAL login=new LoginDAL();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         AppConfig.Config.setTitle("Change Password");
        btnChangePass.setDisable(true);
    }
    
    @FXML private void MatchRe(KeyEvent evt){
        if(getText(New).equals(getText(Re)) && !getText(Re).equals("")){
            btnChangePass.setDisable(false);
            imgRe.setVisible(true);
            imgRe.setImage(new Image("/images/accept.png"));
        }else if(getText(Re).equals("") && getText(New).equals("")){
            imgRe.setVisible(false);
            btnChangePass.setDisable(false);
        }else{
             imgRe.setVisible(true);
             btnChangePass.setDisable(true);
            imgRe.setImage(new Image("/images/error.png"));
        }
    }
    @FXML private void btnChangeEvent(ActionEvent e){
        if(Old.getText().equals(login.getPassword())){
            if(login.setUserPassword(this.Re.getText())){ 
               JOptionPane.showMessageDialog(null, "Your password change successfully\n Please remember the new password \nPassword is: "+Re.getText()+" ! ","Passord has changed",JOptionPane.INFORMATION_MESSAGE);
               setNull();
               return;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Sorry, System find your old password was worng.\n Please try with correct password.", "Operation Faild",JOptionPane.ERROR_MESSAGE);
            Old.setText("");
            return;
        }
    }
    private void setNull(){
        setText(Old,"");setText(New,"");setText(Re,"");
        imgRe.setVisible(false);
    }
    private void setText(TextField textField,String Messege){
        textField.setText(Messege);
    }
    private String getText(TextField textField){
        return textField.getText();
    }
}
