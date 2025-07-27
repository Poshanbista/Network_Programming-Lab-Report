import java.net.*;

public class q2 {
    public static void main(String[] args) {
        try {
            
            InetAddress remoteHost = InetAddress.getLocalHost();

            System.out.println("Host Name           : " + remoteHost.getHostName());
            System.out.println("IP Address          : " + remoteHost.getHostAddress());
            System.out.println("Canonical Host Name : " + remoteHost.getCanonicalHostName());

        } catch (UnknownHostException e) {
            System.out.println("Host not found: " + e.getMessage());
        }
    }
}
