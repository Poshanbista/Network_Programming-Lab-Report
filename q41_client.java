import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class q41_client {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName("localhost");

            System.out.print("Enter a number: ");
            String number = scanner.nextLine();

            byte[] sendBuffer = number.getBytes();
            byte[] receiveBuffer = new byte[1024];

            DatagramPacket sendPacket = new DatagramPacket(
                    sendBuffer,
                    sendBuffer.length,
                    IPAddress,
                    9876
            );
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);

            String result = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server response: " + result);

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
