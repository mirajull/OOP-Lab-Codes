/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pjavafxbasicscene;

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
public class PJavaFXBasicScene extends Application {
    
    public Stage mainStage;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        mainStage=stage;
       
        showLogin();
            


//Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        //Scene scene = new Scene(root);
        
       // stage.setScene(scene);
        //stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void showLogin() throws IOException{
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLLogin.fxml"));
        Parent root=loader.load();
        
        FXMLLoginController controller=loader.getController();
        
        controller.setMain(this);
        
        
        Scene scene=new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    
    public void showHomePage() throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLhome.fxml"));
        Parent root=loader.load();
        
        FXMLhomeController controller=loader.getController();
        
        controller.setMain(this);
        
        
        Scene scene=new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
}
