package tcpserver;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer 
{
    public static void main(String[] args) throws Exception
    {
        int id=1;
        int count=0;
        ServerSocket ss = new ServerSocket(5678);
        while(true)
        {
            Socket cs = ss.accept();
            WorkerThread wt = new WorkerThread(cs,id);
            Thread t = new Thread(wt);
            t.start();
            count++;
            System.out.println("Client: "+id+" got connected. Total threads : "+count);
            id++;
        }
        // TODO code application logic here
    }
}

class WorkerThread implements Runnable
{
    private int id;
    private Socket cs;
    public WorkerThread(Socket cs, int id) 
    {
        this.id=id;
        this.cs=cs;
    }
    
    @Override
    public void run()
    {
        String s1;
        String s2;
        String s3;
        byte[] buffer = new byte[9999];
        int byteread,current=0;
        InputStream is;
        try
        {
            File test= new File("H:\\abc.txt");
            test.createNewFile();
            FileOutputStream fos = new FileOutputStream(test);
            BufferedOutputStream out = new BufferedOutputStream(fos);
            is= cs.getInputStream();
         //   while ((byteread = is.read(buffer, 0, buffer.length)) != -1) 
         //   {
            //    System.out.println(byteread + "\n");
                byteread = is.read(buffer, 0, buffer.length);
                out.write(buffer, 0, byteread);
         //   }
            
            out.flush();

            //BufferedReader in = new BufferedReader (new InputStreamReader(cs.getInputStream()));
            //BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));
            //DataOutputStream out = new DataOutputStream(cs.getOutputStream());
            
            //while(true)
            {
              //  s1=in.readLine();
               // System.out.println("Client Says : "+s1);
               // s3=inu.readLine();
               // out.writeBytes(s3+'\n');
                
            }
            
        }
        catch(Exception e)
        {
            
        }    
    }
}