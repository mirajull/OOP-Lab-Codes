package tcpclient;
import java.io.*;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
class TCPClient
{
    public static void main(String argv[]) throws Exception
    {
        String sentence;
        String modifiedSentence;
        sentence = JOptionPane.showInputDialog(null,"Enter the text");
        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
        JFrame frame = new JFrame("UPPER CASE");
        frame.setLocationRelativeTo(null);
        frame.setSize(400,400);
        frame.setVisible(true);
        
        JTextArea textArea = new JTextArea();
        frame.add(textArea);
        
        while(true)
        {
          
            outToServer.writeUTF(sentence);
            modifiedSentence = inFromServer.readUTF();
            textArea.append(modifiedSentence);
            
        }
    }
}