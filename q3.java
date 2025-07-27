import java.net.*;

public class q3 {
    public static void main(String[] args) {
        try {
            
            InetAddress address = InetAddress.getLocalHost();

            System.out.println("Host Name: " + address.getHostName());
            System.out.println("Host Address: " + address.getHostAddress());

           

            System.out.println("Is Any Local Address? " + address.isAnyLocalAddress());
            System.out.println("Is Loopback Address? " + address.isLoopbackAddress());
            System.out.println("Is Link-Local Address? " + address.isLinkLocalAddress());
            System.out.println("Is Site-Local Address? " + address.isSiteLocalAddress());
            System.out.println("Is Multicast Address? " + address.isMulticastAddress());


        } catch (UnknownHostException e) {
            System.out.println("Invalid host or IP address.");
            e.printStackTrace();
        }
    }
}
