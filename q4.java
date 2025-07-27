import java.net.*;

public class q4{
    public static void main(String[] args) {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
           byte[] add = localhost.getAddress();


           if(add.length == 4){
            System.out.println("IPv4 Address");
           }else if (add.length == 16) {
            System.out.println("IPv6 Address");
           }
        } catch (UnknownHostException e) {
            System.out.println("Unable to get IP address: " + e.getMessage());
        }
    }
}
