import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class q44_sender {
    public static void main(String[] args) {
        final String MULTICAST_GROUP = "230.0.0.1";
        final int PORT = 4446;

        try (MulticastSocket socket = new MulticastSocket()) {
            InetAddress group = InetAddress.getByName(MULTICAST_GROUP);
            String message = "Hello Multicast!";

            byte[] buffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, PORT);
            socket.send(packet);

            System.out.println("Multicast message sent.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
