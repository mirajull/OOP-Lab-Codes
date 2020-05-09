/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxanimation;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Aspire
 */
public class JAVAFXKeyEvent extends Application {
    
  @Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Key Event Test");
		Group root = new Group();
		Scene scene = new Scene(root, 300, 300);
		primaryStage.setScene(scene);
		
		Rectangle r = new Rectangle(100, 100, 100, 100);
		r.setFill(Color.RED);
		root.getChildren().add(r);
		
              //http://docs.oracle.com/javafx/2/events/processing.htm#CEGJAAFD
                
                 scene.setOnKeyTyped(new EventHandler<KeyEvent>() {

                    @Override
                    public void handle(KeyEvent event) {
                        if(event.getCharacter().equals("q")){
                            System.out.println("Quit");
                            Platform.exit();
                        }
                        else{
                            System.out.print(event.getCharacter());
                        }
                    }
                });
                scene.setOnMouseClicked(new EventH());
		/*scene.setOnKeyTyped(event -> {
			if (event.getCharacter().equals("Q")) {
				System.out.println("Quitting ... ");
				Platform.exit();
			} else {
				System.out.println("You typed a ... "+event.getCharacter());
			}
		});*/
		
		primaryStage.show();
		System.out.println("End of start");
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
