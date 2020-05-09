/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlogin;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class JavaFXLogin extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        GridPane grid=new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        
        Label username=new Label("Username");        
        grid.add(username, 0, 0);
        
        TextField user=new TextField();
        grid.add(user, 1, 0);
        
        Label password=new Label("Password");        
        grid.add(password, 0, 1);
        
        PasswordField pass=new PasswordField();
        grid.add(pass, 1, 1);
        
        
        Button btn=new Button("Login");               
        //grid.add(btn, 1,2);
        HBox hbox=new HBox();
        hbox.getChildren().add(btn);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        
        grid.add(hbox, 1, 2);
        
        btn.setOnAction(new EventHandler<ActionEvent> (){

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Working");
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Something");
                alert.showAndWait();
            }
        });
        
        Scene scene=new Scene(grid,400,400);
                
       // grid.setGridLinesVisible(true);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
