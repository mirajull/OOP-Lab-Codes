/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxanimation;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Aspire
 */
public class BallSimulator extends Application{

   Text fps=new Text(0,30,"X");
    double last;
    double count=0;
    
    //Ball ball;
    Ball []balls;
    
    public void updateValue(long now){
        double time=(now-last)/1000000000.0;
        
        if(count%10==0){
            fps.setText(String.format("%.2f",1/time));
            count=0;          
        }
         
        for(Ball b:balls){
             b.updateCenter(1);
              b.collision();
        }
        
      //  ball.updateCenter(1);
      //  ball.collision();
        
        
        count++;
        
        last=now;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
       // AnchorPane root=new AnchorPane();
        Group root=new Group();
        root.getChildren().add(fps);
        
        fps.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
        
       // ball=new Ball(Math.random()*400,Math.random()*400, root, 30,Math.random()*5,Math.random()*5);
       // ball=new Ball (30,30,root,30,m,1);
        
        balls=new Ball[40];
        
        Random rand=new Random();
        for(int i=0;i<balls.length;i++){
             
        Color color=new Color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), rand.nextDouble());
            balls[i]=new Ball(Math.random()*400,Math.random()*400, root, 30,Math.random()*5,Math.random()*5,color);
        }
        
        new AnimationTimer() {

            @Override
            public void handle(long now) {
                updateValue(now);
            }
        }.start();
        
        Scene scene=new Scene(root,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
