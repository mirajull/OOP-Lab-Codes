package javafxanimation;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aspire
 */
public class JFXTransform extends Application{

   @Override
    public void start(Stage primaryStage) {
       
        Group root=new Group();
        
        Scene scene=new Scene(root,400,400);
        
        Rectangle r=new Rectangle(0,100,100,100);
        r.setFill(Color.RED);
        root.getChildren().add(r);
        
        Rectangle r1=new Rectangle(200,100,100,100);
        r1.setStroke(Color.RED);
        r1.setFill(Color.ALICEBLUE);
        root.getChildren().add(r1);
        
        r.setRotate(45);
        
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
