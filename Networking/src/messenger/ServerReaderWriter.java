package messenger;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectionUtillities;


public class ServerReaderWriter implements Runnable{

    public HashMap<String,Information> clientList;
    public ConnectionUtillities connection;
    public String user;
    long maxsize = Server.rest;
    byte[] b;
    String fid=Server.fileID();
    File test;
    
    public ServerReaderWriter(String username,ConnectionUtillities con, HashMap<String,Information> list){
        connection=con;
        clientList=list;
        user=username;
        b=new byte[(int)maxsize];
    }
    
    @Override
    public void run() {
        while(true){
            
            String data=connection.read();
            String msg[]=data.split("%");
            String username=msg[0];
            String fname=msg[1];
            //System.out.println(msg[0]+"  "+msg[1] );
            if(clientList.containsKey(username))
            {
                connection.write("start");
                long fsize=connection.readd();
                if(fsize>maxsize)
                {
                   connection.write("N");
                }
                
                else
                {   
                    try {
                        connection.write("Y");
                        connection.writee(Server.chunksize);
                        int chunkno=(int)(fsize/Server.chunksize);
                        Server.rest=(Server.rest-fsize);
                        
                        test = new File("H:\\"+fid+".txt");
                        test.createNewFile();
                        FileOutputStream fos = new FileOutputStream(test);
                        BufferedOutputStream out = new BufferedOutputStream(fos);
                        int i=0;
                        while(true)
                        {
                           
                            int bread=connection.read(b,0,b.length);
                            //System.out.println("bread: "+bread);
                            out.write(b,0,bread);
                            out.flush();
                            // String s3=connection.read();
                            // if(s3.equalsIgnoreCase("done")){break;}
                            // else if(s3.equalsIgnoreCase("timeout")){break;}
                            if(bread==Server.chunksize)
                            {
                                connection.write("next");
                                i+=bread;
                            }
                            else if(bread==fsize-(chunkno * Server.chunksize))
                            {
                               // System.out.println("ekhane astesi, bread:"+bread);
                                String s3=connection.read();
                                i+=bread;
                              //  System.out.println(s3);
                                if(s3.equalsIgnoreCase("done"))
                                {
                                    break;
                                }
                            }
                        }
                        if(i==fsize)
                        {
                          //  System.out.println("astese");
                            Server.fileList.put(fid,new FileInfo(user,username,fsize,test));
                        }
                        else
                        {
                            System.out.println("error in receiving in server");
                            test.delete();
                            Server.rest+=fsize;
                            break;
                        }
                        fos.close();
                        out.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ServerReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Information info=clientList.get(username);
                    //new Thread(new Writer(info.connection)).start(); 
                    info.connection.write(fid);
                    FileInfo finfo=Server.fileList.get(fid);
                    FileInputStream fis;
                    byte[]ara=new byte[(int)fsize];
                    try {
                        //System.out.println(finfo.getFile().getAbsoluteFile());
                        fis = new FileInputStream(finfo.getFile());
                        BufferedInputStream bis=new BufferedInputStream(fis);
                        bis.read(ara,0,(int)fsize);
                       // System.out.println(new String(ara));
                        info.connection.write(ara,0,(int)fsize);
                        fis.close();
                        test.delete();
                        
                        
                        Server.rest+=fsize;
                        
                       // String read=info.connection.read();
                       // System.out.println("read: "+read);
                      //  if(read.equalsIgnoreCase("done"))
                     //   {
                          //finfo.getFile().delete();
                     //   }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ServerReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
                    }catch(IOException ex){
                        
                    }
                }
            }
            else
            {
                connection.write("stop");
            }
        }
    }
}