/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pjavafxbasic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 *
 * @author Aspire
 */
public class PJAVAFXbasic extends Application{
    
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root=new GridPane();
        root.setAlignment(Pos.CENTER);
        Button btn=new Button("Click me");
        
      //  btn.setOnAction(new MyEventHandler());
      //  btn.setOnMouseClicked(new MyMouseEvent());
        /*
          btn.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Inline event handler");
                
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
          
          });
          */
        
        btn.setOnAction(event->{
            System.out.println("Clicked by lambda expression");
        });
        
        btn.setOnMouseClicked(event->{
            System.out.println(event.getX()+" "+event.getY());
        });
        
        root.getChildren().add(btn);
        
        Scene scene=new Scene(root,400,400);
        
        primaryStage.setScene(scene);
        
        primaryStage.setTitle("Hello FX");
        primaryStage.show();
        
    }
    
}
