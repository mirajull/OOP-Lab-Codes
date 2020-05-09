/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxanimation;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Aspire
 */
public class JAVAFXkeyeventTransform extends Application {
    
    double rotation = 0;
	double opacity = 1.0;

	@Override
	public void start(Stage primaryStage) throws Exception {
            
            
            Group group=new Group();
            
            Scene scene=new Scene(group,300,300);
            
            Rectangle r=new Rectangle(0,0,10,50);
            r.setFill(Color.RED);
            group.getChildren().add(r);
            
            /*scene.setOnMouseClicked(new EventHandler<MouseEvent>(){

                @Override
                public void handle(MouseEvent event) {
                    double x=event.getX();
                    double y=event.getY();
                    
                    r.setX(x);
                    r.setY(y);
                }
                
            });*/
            
            scene.setOnMouseDragged(event->{
                r.setX(event.getX());
                r.setY(event.getY());
            });
            
            
            primaryStage.setTitle("Moving");
            primaryStage.setScene(scene);
            primaryStage.show();
            
            
		/*primaryStage.setTitle("EventTransform");
		Group root = new Group();
		Scene scene = new Scene(root, 300, 300);
		primaryStage.setScene(scene);
		
		Rectangle r = new Rectangle(145, 100, 10, 100);
		r.setFill(Color.RED);
		root.getChildren().add(r);

		scene.setOnMouseClicked(event -> {
			r.setX(event.getX());
			r.setY(event.getY());
		});

		scene.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.RIGHT) {
				rotation = (rotation + 22.5) % 360;
				r.setRotate(rotation);	
			} else if (event.getCode() == KeyCode.LEFT) {
				rotation = (rotation - 22.5) % 360;
				r.setRotate(rotation);	
			} else if (event.getCode() == KeyCode.UP) {
				opacity = Math.min((opacity + 0.1) , 1.0);
				primaryStage.setOpacity(opacity);	
			}  if (event.getCode() == KeyCode.DOWN) {
				opacity = Math.max((opacity - 0.1) , 0);
				primaryStage.setOpacity(opacity);	
			}  
		});
		
		primaryStage.show();*/
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
