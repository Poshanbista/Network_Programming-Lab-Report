import java.net.*;

public class q12 {

    public static void main(String[] args) {
        checkTCPSupport();
        checkUDPSupport();
        checkICMPSupport("8.8.8.8"); // Google's DNS server
    }

    static void checkTCPSupport() {
        try (Socket socket = new Socket("www.google.com", 80)) {
            System.out.println("TCP Protocol: Supported");
        } catch (Exception e) {
            System.out.println("TCP Protocol: Not Supported or Blocked");
        }
    }

    static void checkUDPSupport() {
        try {
            DatagramSocket udpSocket = new DatagramSocket();
            udpSocket.connect(InetAddress.getByName("8.8.8.8"), 53);
            System.out.println("UDP Protocol: Supported");
            udpSocket.close();
        } catch (Exception e) {
            System.out.println("UDP Protocol: Not Supported or Blocked");
        }
    }

    static void checkICMPSupport(String host) {
        try {
            InetAddress inet = InetAddress.getByName(host);
            if (inet.isReachable(3000)) {
                System.out.println("ICMP Protocol (Ping): Supported");
            } else {
                System.out.println("ICMP Protocol (Ping): Not Reachable");
            }
        } catch (Exception e) {
            System.out.println("ICMP Protocol: Not Supported or Blocked");
        }
    }
}
