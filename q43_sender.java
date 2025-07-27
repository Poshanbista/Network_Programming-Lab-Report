import java.net.*;

public class q43_sender {
    public static void main(String[] args) throws Exception {
        MulticastSocket socket = new MulticastSocket();
        InetAddress group = InetAddress.getByName("230.0.0.1"); // Multicast group IP
        int port = 4446;

        String message = "Hello Multicast Group!";
        DatagramPacket packet = new DatagramPacket(
                message.getBytes(), message.length(), group, port);

        socket.send(packet);
        System.out.println("Message sent to multicast group.");
        socket.close();
    }
}
