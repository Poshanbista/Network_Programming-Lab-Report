import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class q44_sniffer{
    public static void main(String[] args) {
        final String MULTICAST_GROUP = "230.0.0.1";
        final int PORT = 4446;

        try (MulticastSocket socket = new MulticastSocket(PORT)) {
            InetAddress group = InetAddress.getByName(MULTICAST_GROUP);
            socket.joinGroup(group);

            System.out.println(" Multicast Sniffer started. Listening on " + MULTICAST_GROUP + ":" + PORT);

            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet); // Wait for multicast packet

                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println(" Received: " + message + " from " + packet.getAddress());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
