import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class q38_server {
    public static void main(String[] args) {
        final int PORT = 9876;
        byte[] receiveData = new byte[1024];

        try {
            DatagramSocket serverSocket = new DatagramSocket(PORT);
            System.out.println("UDP Echo Server is running on port " + PORT + "...");

            while (true) {
                // Receive packet from client
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                // Get message
                String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from client: " + clientMessage);

                // Send back (echo) the same message
                DatagramPacket sendPacket = new DatagramPacket(
                        receivePacket.getData(),
                        receivePacket.getLength(),
                        receivePacket.getAddress(),
                        receivePacket.getPort()
                );

                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
