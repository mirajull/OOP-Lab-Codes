/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxanimation;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Aspire
 */
public class FrameRate extends Application{
   
    Text fps=new Text("X");
    double last;
    double count=0;
    public void updateValue(long now){
        double time=(now-last)/1000000000.0;
        
        if(count%10==0){
            fps.setText(String.format("%.2f",1/time));
            count=0;
        }
        
        count++;
        
        last=now;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root=new StackPane();
        fps.setFont(Font.font("Times", FontWeight.THIN, 40));
        root.getChildren().add(fps);
        
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
    
    
    	/*Text fps = new Text(0, 30, "X");
	
	long lastFrame = 0;
	long frameCount = 0;
	
	private void updateGameState(long now) {
		double elapsedSec = (now - lastFrame) / 1000000000.0;
		if (frameCount % 10 == 0)
			fps.setText(String.format("%.1f", 1/elapsedSec));
		lastFrame = now;
		frameCount++;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Frame Rate");
		Group root = new Group();
		Scene scene = new Scene(root, 300, 300);
		primaryStage.setScene(scene);
		
		fps.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
		fps.setOpacity(0.4);
		root.getChildren().add(fps);
		
		new AnimationTimer() {
			@Override
			public void handle(long now) {
				updateGameState(now);
			}
			
		}.start();
		
		
		primaryStage.show();
	}*/

	public static void main(String[] args) {
		launch(args);
	}

    
}
