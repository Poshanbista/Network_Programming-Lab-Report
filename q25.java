import java.io.*;
import java.net.*;

public class q25 {
    public static void main(String[] args) {
        String server = "example.com";  // You can use any domain or IP
        int port = 80;                  // HTTP default port

        try {
            // Create a socket and connect to the server
            Socket socket = new Socket(server, port);

            // Get information from the socket
            System.out.println("Connected to server: " + server);
            System.out.println("Remote IP Address: " + socket.getInetAddress());
            System.out.println("Remote Port: " + socket.getPort());
            System.out.println("Local IP Address: " + socket.getLocalAddress());
            System.out.println("Local Port: " + socket.getLocalPort());

            // Check socket status
            System.out.println("Is socket connected? " + socket.isConnected());
            System.out.println("Is socket closed? " + socket.isClosed());

            // Close the socket
            socket.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
