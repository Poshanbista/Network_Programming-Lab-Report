import java.net.*;

public class q42 {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();

            socket.setSoTimeout(3000);
            socket.setReuseAddress(true);
            socket.setReceiveBufferSize(4096);
            socket.setSendBufferSize(4096);
            socket.setBroadcast(true);

            System.out.println("SoTimeout: " + socket.getSoTimeout());
            System.out.println("ReuseAddress: " + socket.getReuseAddress());
            System.out.println("ReceiveBufferSize: " + socket.getReceiveBufferSize());
            System.out.println("SendBufferSize: " + socket.getSendBufferSize());
            System.out.println("Broadcast: " + socket.getBroadcast());

            socket.close();
        } catch (SocketException e) {
            System.err.println("Socket error: " + e.getMessage());
        }
    }
}
