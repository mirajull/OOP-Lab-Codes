/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class JavaApplication18
{
    public static void main(String argv[]) throws Exception
    {
        String sentence;
        String modifiedSentence;
        
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
            sentence = JOptionPane.showInputDialog(null,"Enter the text");      
            outToServer.writeUTF(sentence);
            
            modifiedSentence = inFromServer.readUTF();
            textArea.append(modifiedSentence + "\n");
            
        }
    }
}