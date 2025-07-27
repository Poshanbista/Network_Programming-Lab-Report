import java.io.*;
import java.net.*;

public class q27_client {
    public static void main(String[] args) {
        final String SERVER = "localhost"; // or IP address
        final int PORT = 5002;

        try (Socket socket = new Socket(SERVER, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String serverTime = in.readLine();
            System.out.println("Server responded: " + serverTime);

        } catch (IOException e) {
            System.err.println("Client Error: " + e.getMessage());
        }
    }
}
