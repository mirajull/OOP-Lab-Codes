/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplescene;

import com.sun.javaws.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
       
    private Button button;
    
    
    JavaFXLoginSceneBuilder Main;          
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void check(ActionEvent event) {
        System.out.println("Clicked");
    }
    
    
    public void setMain(JavaFXLoginSceneBuilder ma){
        Main=ma;
    }
    
}
