import java.io.*;
import java.net.*;

public class q33 {

    public static void main(String[] args) {
        int port = 5000;

        try {
            ServerSocket serverSocket = new ServerSocket();

            // Set socket options before binding
            serverSocket.setReuseAddress(true); // allows reuse of address
            serverSocket.setSoTimeout(10000); // 10 seconds timeout
            serverSocket.setReceiveBufferSize(65536); // 64 KB buffer

            // Bind the socket to the port
            serverSocket.bind(new InetSocketAddress(port));
            System.out.println("Server is listening on port " + port);

            // Accept client connection (wait for a connection)
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getInetAddress());

            // Communicate with client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Hello from Server!");

            // Cleanup
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (SocketTimeoutException e) {
            System.out.println("Accept timed out after 10 seconds.");
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
