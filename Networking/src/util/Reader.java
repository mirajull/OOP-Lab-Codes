package util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reader implements Runnable{
    public ConnectionUtillities connection;
    
    public Reader(ConnectionUtillities con){
        connection=con;
    }

    @Override
    public void run() {
        String fname,roll;
        long fsize; 
        Scanner in=new Scanner(System.in);
        while(true){
            System.out.println("Enter the receiver student ID:");
            roll=in.nextLine();
            if(roll.isEmpty())
            {
                new Thread(new Writer(connection)).start();
                break;
            }
            else
            {
                System.out.println("Enter the fileName: ");
                fname=in.nextLine();
                connection.write(roll+"% "+fname);


                String s1=connection.read();
                //System.out.println("eta s1" + s1);
                if(s1.equalsIgnoreCase("stop"))
                {
                    System.out.println("receiver student id is not logged in");
                }
                else
                {
                    System.out.println("Start file sending!");
                    System.out.println("Enter the fileSize: ");
                    fsize=in.nextInt();
                    connection.writee(fsize);

                    String decision=connection.read();
                    //System.out.println(decision);
                    if(decision.equalsIgnoreCase("Y"))
                    {
                        long csize=connection.readd();

                        int chunkno= (int)(fsize/csize);
                        //String fid=connection.read();
                        //System.out.println(csize);
                        File file=new File(fname);
                        byte [] ara = new byte[(int)fsize];

                        try {


                            FileInputStream fis = new FileInputStream(file);
                            BufferedInputStream bis=new BufferedInputStream(fis);
                            int j=0,flag=0;
                            for(int i=0;i<=chunkno;i++)
                            {
                                if(i==0)
                                {
                                    bis.read(ara,0,(int)csize);
                                    connection.write(ara,0,(int)csize);
                                }
                                else
                                {
                                    String s2= connection.read();
                                    if(s2.equalsIgnoreCase("next") && i==chunkno)
                                    {
                                        bis.read(ara,0,(int)(fsize-(chunkno*csize)));
                                        connection.write(ara,0,(int)(fsize-(chunkno*csize)));
                                        connection.write("done");
                                        break;
                                    }
                                    else if(s2.equalsIgnoreCase("next"))
                                    {
                                        bis.read(ara,0,(int)csize);
                                        connection.write(ara,0,(int)csize);
                                    }
                                    else
                                    {
                                        break;
                                    }
                                }
                              /*long t1=System.currentTimeMillis();
                                String s2= connection.read();
                                long t2=System.currentTimeMillis();
                                while(System.currentTimeMillis() - t1 <=3000)
                                {

                                }
                                if(s2.equalsIgnoreCase(null))
                                {
                                    connection.write("timeout");
                                    flag=1;
                                }
                                else if(s2.equalsIgnoreCase("failed"))
                                {

                                    flag=1;
                                    break;
                                }*/ 
                            }
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException e){

                        }

                    }
                    else
                    {
                        System.out.println("File size is too big!");
                        //break;
                    }
                }   
            }    
        }
    }
}