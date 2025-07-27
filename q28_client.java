// TCPClient.java
import java.io.*;
import java.net.*;

public class q28_client {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1"; // localhost
        int port = 1234;

        try (Socket socket = new Socket(serverIP, port)) {
            // Send message to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello Server, this is the client!");

            // Receive reply from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverReply = in.readLine();
            System.out.println("Received from server: " + serverReply);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
