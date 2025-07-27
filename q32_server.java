import java.io.*;
import java.net.*;

public class q32_server {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = in.readLine();
            System.out.println("Received from client: " + message);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
