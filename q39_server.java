import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class q39_server {
    public static void main(String[] args) {
        int port = 12345;
        try (DatagramSocket serverSocket = new DatagramSocket(port)) {
            byte[] receiveBuffer = new byte[1024];

            System.out.println("UDP Daytime Server is running on port " + port);

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);  // wait for client request

                // Get current date and time
                String dateTime = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                byte[] sendBuffer = dateTime.getBytes();

                // Send response back to client
                DatagramPacket sendPacket = new DatagramPacket(
                        sendBuffer,
                        sendBuffer.length,
                        receivePacket.getAddress(),
                        receivePacket.getPort()
                );

                serverSocket.send(sendPacket);
                System.out.println("Sent current time to client: " + dateTime);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
