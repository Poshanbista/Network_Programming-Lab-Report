import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.InetAddress;

public class q36 {
    public static void main(String[] args) {
        DatagramSocket udpSocket = null;

        try {
            udpSocket = new DatagramSocket();

            int localPort = udpSocket.getLocalPort();

            InetAddress localAddress = udpSocket.getLocalAddress();

            boolean isBound = udpSocket.isBound();

            boolean isClosed = udpSocket.isClosed();

            System.out.println("UDP Socket Information:");
            System.out.println("-----------------------");
            System.out.println("Local Port: " + localPort);
            System.out.println("Local Address: " + localAddress.getHostAddress());
            System.out.println("Is Bound: " + isBound);
            System.out.println("Is Closed: " + isClosed);

        } catch (SocketException e) {
            System.err.println("SocketException: " + e.getMessage());
        } finally {
            if (udpSocket != null && !udpSocket.isClosed()) {
                udpSocket.close(); // Close the socket to release resources
            }
        }
    }
}
