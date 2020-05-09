package clientt;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Clientt extends Application {
    
    public static Socket cs;
    public static DataOutputStream outToServer;
    public static BufferedReader inFromServer;
    
    public Clientt() 
    {
        try{
        this.cs = new Socket("localhost", 6789);
        outToServer = new DataOutputStream(cs.getOutputStream());
        inFromServer = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        }
        catch(Exception e)
        {
            
        }
    }
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root,600,400);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
