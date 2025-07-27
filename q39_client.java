import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class q39_client {
    public static void main(String[] args) {
        String serverHost = "localhost";
        int port = 12345;

        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName(serverHost);

            // Send empty request (just to trigger response)
            byte[] sendBuffer = new byte[1];
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, port);
            clientSocket.send(sendPacket);

            // Receive response
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);

            String serverTime = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Current server time: " + serverTime);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
