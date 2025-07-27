import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class q38_client {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 9876;

        try (Scanner scanner = new Scanner(System.in)) {
            DatagramSocket clientSocket = new DatagramSocket();

            System.out.print("Enter message to send to server: ");
            String message = scanner.nextLine();
            byte[] sendData = message.getBytes();

            // Send packet to server
            InetAddress serverIPAddress = InetAddress.getByName(SERVER_ADDRESS);
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIPAddress, SERVER_PORT);
            clientSocket.send(sendPacket);

            // Receive echoed message
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String echoedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Echoed from server: " + echoedMessage);

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
