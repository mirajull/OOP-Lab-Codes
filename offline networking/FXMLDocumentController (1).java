
package offlineclient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextArea InputText;
    @FXML
    private TextArea OutputText;
    
    String sentence;
    String modifiedSentence;
    
    //OfflineClient ob= new OfflineClient();
    
    private String Text= "";
        
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception{
        
       sentence= InputText.getText();
       Clientt.outToServerr.writeBytes(sentence+'\n');
        
        modifiedSentence= Clientt.inFromServerr.readLine();
       
        Text+="\n From Server : "+modifiedSentence;
         
        InputText.setText(Text);
        OutputText.setText("");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
