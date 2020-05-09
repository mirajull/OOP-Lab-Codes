/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pjavafxbasicscene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Aspire
 */
public class FXMLLoginController implements Initializable {
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;
    @FXML
    private Button loginBtn;
    @FXML
    private Text errormsg;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void checkLogin(ActionEvent event) throws IOException {
        String user=username.getText();
        String pass=password.getText();
        
        System.out.println(user+" "+pass);
        
        if(user.equals("admin") && pass.equals("123")){
            
            main.showHomePage();
        }
        else{
            /*Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Wrong username pass");
            alert.showAndWait();*/
            errormsg.setText("Wrong user name pass");
            errormsg.setFill(Color.RED);
        }
        
        
    }
    
    private PJavaFXBasicScene main;
    public void setMain(PJavaFXBasicScene mainC){
        main=mainC;
    }
    
}
