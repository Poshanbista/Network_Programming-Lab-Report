import java.io.*;
import java.net.*;

public class q32_SocketServer {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 12345;

        try {
            // Create client socket
            Socket socket = new Socket();
            System.out.println("Creating socket...");

            // Set socket options BEFORE connecting
            socket.setSoTimeout(5000); // Set read timeout to 5 seconds
            socket.setTcpNoDelay(true); // Disable Nagle's algorithm
            socket.setReuseAddress(true); // Allow socket to bind to an address that is in TIME_WAIT state
            socket.setReceiveBufferSize(8192); // Set receive buffer size
            socket.setSendBufferSize(8192); // Set send buffer size

            // Connect to server
            socket.connect(new InetSocketAddress(serverAddress, port));
            System.out.println("Connected to server.");

            // Display socket options
            System.out.println("Socket Options:");
            System.out.println("SoTimeout: " + socket.getSoTimeout());
            System.out.println("TcpNoDelay: " + socket.getTcpNoDelay());
            System.out.println("ReuseAddress: " + socket.getReuseAddress());
            System.out.println("ReceiveBufferSize: " + socket.getReceiveBufferSize());
            System.out.println("SendBufferSize: " + socket.getSendBufferSize());

            // Send a message to server
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello Server");

            // Close socket
            socket.close();
            System.out.println("Socket closed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
