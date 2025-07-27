import java.net.*;

public class q43_receiver {
    public static void main(String[] args) throws Exception {
        int port = 4446;
        MulticastSocket socket = new MulticastSocket(port);
        InetAddress group = InetAddress.getByName("230.0.0.1");

        socket.joinGroup(group); // Join the multicast group

        byte[] buffer = new byte[256];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        System.out.println("Waiting for multicast message...");

        socket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Received: " + received);

        socket.leaveGroup(group); // Leave the group
        socket.close();
    }
}
