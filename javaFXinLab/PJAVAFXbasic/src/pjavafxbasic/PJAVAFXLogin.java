/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pjavafxbasic;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 *
 * @author Aspire
 */
public class PJAVAFXLogin extends Application{
    
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root=new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(10);
        root.setHgap(10);
        
        Label username=new Label("Username");
        Label password=new Label("Password");
        
        root.add(username,0,0);
        root.add(password,0,1);
        
        TextField user=new TextField();
        PasswordField pass=new PasswordField();
        
        root.add(user, 1, 0);
        root.add(pass, 1, 1);
        
        Button btn=new Button("Login");
        
        HBox hbox=new HBox();
        hbox.getChildren().add(btn);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        
        
        root.add(hbox, 1, 2);
        
        
        
        root.setGridLinesVisible(true);
        
        
        Scene scene=new Scene(root,400,400);
        
        primaryStage.setScene(scene);
        
        primaryStage.setTitle("Hello FX");
        primaryStage.show();
        
    }
    
}
