package tcpclient;

import java.io.BufferedInputStream;
//import java.io.BufferedReader;
//import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
//import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
public class TCPClient 
{
    public static void main(String[] args) throws Exception
    {
        //String s1;
        //String s2;
        Socket cs = new Socket("localhost",5678);
        OutputStream out= cs.getOutputStream();
        File f= new File("F:\\password.txt");
        byte[] buffer = new byte[(int) f.length()];
        FileInputStream fis = new FileInputStream(f);
        BufferedInputStream in = new BufferedInputStream(fis);
        //BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader ins = new BufferedReader (new InputStreamReader(cs.getInputStream()));
        //DataOutputStream os = new DataOutputStream(cs.getOutputStream());
        int i=5000;
        while(true)
        {
        //    s1=inu.readLine();
        //    os.writeBytes(s1+'\n');
        //    s2=ins.readLine();
        //    System.out.println("Server Says : "+s2);
        //in.wait(2000);
     
        in.read(buffer);
        //System.out.println(buffer.toString());
        out.write(buffer,0,buffer.length);
        out.flush();
        //i=i-1;
        //if(in.read()==-1){break;}
        }
        //while(true);
    }
}

