
package offlineserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class FXMLDocumentController implements Runnable {
    
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextArea ServerTextArea;
    
    private String text= "Server has stared";
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception{
        //ServerTextArea.setText("Server has started");
        
        System.out.println(text);
        ServerTextArea.setText(text);
        new Thread(this).start();
        
    }
    
    /*@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  */  

    @Override
    public void run() {
        
        int workerThreadCount = 0;
        int id = 1;
        ServerSocket welcomeSocket;
        try {
            welcomeSocket = new ServerSocket(6789);
        
        
        while(true)
        {
            Socket connectionSocket = welcomeSocket.accept();
           
            WorkerThread wt = new WorkerThread(connectionSocket,id);
            Thread t = new Thread(wt);
            t.start();
            workerThreadCount++;
            System.out.println("Client [" + id + "] is now connected. No. of worker threads = " + workerThreadCount);
            id++;
            
            
            
        }
        
        } catch (IOException ex) {

        }
    }
    
    
    
    class WorkerThread implements Runnable
    {
    private Socket connectionSocket;
    private int id;
    public WorkerThread(Socket ConnectionSocket, int id) 
    {
        this.connectionSocket=ConnectionSocket;
        this.id=id;
    }
    @Override
    public void run()
    {
       // boolean flag= true;
        String clientSentence;
        String capitalizedSentence;
        while(true)
        {
            try
            {
               // if(flag==false) break;
                DataOutputStream outToServer = new DataOutputStream(connectionSocket.getOutputStream());
                
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));    
                clientSentence = inFromServer.readLine();
                capitalizedSentence = clientSentence.toUpperCase();
                outToServer.writeBytes(capitalizedSentence+'\n');
                System.out.println("from Client"+ id+ " :"+capitalizedSentence );
                text+="client"+id+" "+capitalizedSentence;
                ServerTextArea.setText(text);
                
            }
            catch(Exception e)
            {
                text+="Client"+id+"has leaved\n";
                System.out.println("client"+id+"has leaved");
                ServerTextArea.setText(text);
                flag= false;
            }
        }
    }
}
    
}
