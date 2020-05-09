package serverr;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Serverr extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage.setTitle("Server");
        
        
        stage.setScene(new Scene(root, 600, 380));
       
        
        stage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
