package compnet;

import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompNet {

    public static void main(String[] args) {
        try {
            InetAddress a= InetAddress.getByName("www.yahoo.com");
            System.out.println("hostname :"+ a.getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(CompNet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no ip address is found");
        }
    }
    
}
