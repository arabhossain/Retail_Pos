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

import AppConfig.vars;
import BusniessObjects.QuantityDialog;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Arab_Aka
 */
public class InputProductQuntityDiologController implements Initializable {
    @FXML private TextField txtQuntity;
    @FXML private Label lblName,lblTex,lblPrice,lblTotal,lblM;
    
    private String name;
    private String unitName;
    private Double tex;
    private Double price;
    private double total;
    private double quantity=0.0;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Snyc();
    }    
    @FXML private void btnCancel(ActionEvent e){
        QuantityDialog.isOk=false;
        ((Node)(e.getSource())).getScene().getWindow().hide();
    }
    @FXML private void btnOk(ActionEvent e){
        QuantityDialog.qntity=quantity;
        QuantityDialog.isOk=true;
        ((Node)(e.getSource())).getScene().getWindow().hide();
    }
    @FXML private void btn0(ActionEvent e){
        if(txtQuntity.getText().equals("0") || txtQuntity.getText().equals("0.0")){
            txtQuntity.setText("");
        }
        txtQnty=txtQuntity.getText();
        txtQuntity.setText(txtQnty+"0");
        process();
    }
     @FXML private void btn1(ActionEvent e){
        if(txtQuntity.getText().equals("0") || txtQuntity.getText().equals("0.0")){
            txtQuntity.setText("");
        }
        txtQnty=txtQuntity.getText();
        txtQuntity.setText(txtQnty+"1");
        process();
    }
     @FXML private void btn2(ActionEvent e){
        if(txtQuntity.getText().equals("0") || txtQuntity.getText().equals("0.0")){
            txtQuntity.setText("");
        }
        txtQnty=txtQuntity.getText();
        txtQuntity.setText(txtQnty+"2");
        process();
    }
     @FXML private void btn3(ActionEvent e){
        if(txtQuntity.getText().equals("0") || txtQuntity.getText().equals("0.0")){
            txtQuntity.setText("");
        }
        txtQnty=txtQuntity.getText();
        txtQuntity.setText(txtQnty+"3");
        process();
    }
     @FXML private void btn4(ActionEvent e){
        if(txtQuntity.getText().equals("0") || txtQuntity.getText().equals("0.0")){
            txtQuntity.setText("");
        }
        txtQnty=txtQuntity.getText();
        txtQuntity.setText(txtQnty+"4");
        process();
    }
     @FXML private void btn5(ActionEvent e){
        if(txtQuntity.getText().equals("0") || txtQuntity.getText().equals("0.0")){
            txtQuntity.setText("");
        }
        txtQnty=txtQuntity.getText();
        txtQuntity.setText(txtQnty+"5");
        process();
    }
     @FXML private void btn6(ActionEvent e){
        if(txtQuntity.getText().equals("0") || txtQuntity.getText().equals("0.0")){
            txtQuntity.setText("");
        }
        txtQnty=txtQuntity.getText();
        txtQuntity.setText(txtQnty+"6");
        process();
    }
     @FXML private void btn7(ActionEvent e){
        if(txtQuntity.getText().equals("0") || txtQuntity.getText().equals("0.0")){
            txtQuntity.setText("");
        }
        txtQnty=txtQuntity.getText();
        txtQuntity.setText(txtQnty+"7");
        process();
    }
     private String txtQnty;
     @FXML private void btn8(ActionEvent e){
        if(txtQuntity.getText().equals("0") || txtQuntity.getText().equals("0.0")){
            txtQuntity.setText("");
        }
        txtQnty=txtQuntity.getText();
        txtQuntity.setText(txtQnty+"8");
        process();
    }
    @FXML private void btn9(ActionEvent e){
        if(txtQuntity.getText().equals("0") || txtQuntity.getText().equals("0.0")){
            txtQuntity.setText("");
        }
        txtQnty=txtQuntity.getText();
        txtQuntity.setText(txtQnty+"9");
        process();
    }
    @FXML private void btnDot(ActionEvent e){
        if(txtQuntity.getText().equals("0") || txtQuntity.getText().equals("0.0")){
            txtQuntity.setText("");
        }
        txtQnty=txtQuntity.getText();
        txtQuntity.setText(txtQnty+".");
        process();
    }
    @FXML private void btnClear(MouseEvent e){
        if(txtQuntity.getText().equals("0") || txtQuntity.getText().equals("0.0")){
            txtQuntity.setText("");
        }
        txtQuntity.setText("0");
        process();
    }
    @FXML private void onTypeQuantity(KeyEvent e){
        if(this.txtQuntity.getText().equals("")){
            txtQuntity.setText("0");
        }
        try{
           lblM.setText("");
           Double.parseDouble(this.txtQuntity.getText());
        }catch(Exception ex){
                lblM.setText("Error: Invilad Input!");
                String temp=this.txtQuntity.getText();
                String tempString="";
                for(int i=0; i<temp.length()-1; i++){
                    char tempCar=temp.charAt(i);
                    tempString+=tempCar;
                }
                if(tempString.equals("")){
                    this.txtQuntity.setText("0");
                }else{
                    this.txtQuntity.setText(tempString);
                }
            return;
        }
        process();
    }
    @FXML private void btnIncrese(ActionEvent e){
       Double quantit=Double.parseDouble(this.txtQuntity.getText());
       quantit=quantit+1;
       this.txtQuntity.setText(String.valueOf(quantit));
       process();
    }
    @FXML private void btnDecrese(ActionEvent e){
       Double quantit=Double.parseDouble(this.txtQuntity.getText());
       quantit=quantit-1;
       this.txtQuntity.setText(String.valueOf(quantit));
       process();
    }
    private void Snyc(){
        this.name=QuantityDialog.Name;
        this.price=QuantityDialog.price;
        this.tex=QuantityDialog.tex;
        this.unitName=QuantityDialog.Unit;
        
        this.lblName.setText(name);
        this.lblTex.setText(String.valueOf(tex)+" "+vars.getMoneySymble()+" /"+unitName);
        this.lblPrice.setText(String.valueOf(price)+" "+vars.getMoneySymble()+" /"+unitName);
    }
   @FXML private Button btnDecrese; 
   @FXML private void btnBack(ActionEvent e){
       try{
       if(quantity>0){
           String temp=this.txtQuntity.getText();
           String tempString="";
           for(int i=0; i<temp.length()-1; i++){
               char tempCar=temp.charAt(i);
               tempString+=tempCar;
           }
           if(tempString.equals("")){
               this.txtQuntity.setText("0");
           }else{
               this.txtQuntity.setText(tempString);
           }
       }
           process();
       }catch(Exception er){
           er.printStackTrace();
       }
   }
    private void process(){
        lblM.setText("");
        quantity=Double.parseDouble(this.txtQuntity.getText());
        if(quantity>0){
            btnDecrese.setDisable(false);
        }else{
            btnDecrese.setDisable(true);
        }
        total=price*quantity+tex*quantity;
        lblTotal.setText(String.valueOf(total));
    }
    
}
