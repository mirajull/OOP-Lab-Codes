/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginwithscenebuilder;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Aspire
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button button;
    @FXML
    private GridPane pane;
    @FXML
    private Label userName;
    @FXML
    private Label password;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passWorrdFiled;
    @FXML
    private HBox hbox;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickButton(ActionEvent event) {
        System.out.print("Hello World!");
    }
    
}
