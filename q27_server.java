import java.io.*;
import java.net.*;
import java.util.Date;

public class q27_server {
    public static void main(String[] args) {
        final int PORT = 5002; // You can use 13 for the actual Daytime protocol

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Daytime Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept(); // wait for client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String currentTime = new Date().toString();
                out.println("Current Date & Time: " + currentTime);

                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Server Error: " + e.getMessage());
        }
    }
}

