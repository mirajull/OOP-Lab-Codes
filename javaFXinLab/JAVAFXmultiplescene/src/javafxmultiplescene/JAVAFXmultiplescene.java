/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmultiplescene;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Aspire
 */
public class JAVAFXmultiplescene extends Application {
   
    Stage mainStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        
        FXMLDocumentController controller=loader.getController();
        controller.setMain(this);
        mainStage=stage;
        
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void showHomePage() throws IOException{
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLHome.fxml"));
        Parent root = loader.load();
        
        FXMLHomeController controller=loader.getController();
        controller.setMain(this);
      
        
        
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    } 
}
