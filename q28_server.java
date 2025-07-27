// TCPServer.java
import java.io.*;
import java.net.*;

public class q28_server {
    public static void main(String[] args) {
        int port = 1234;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket socket = serverSocket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientMessage = in.readLine();
            System.out.println("Received from client: " + clientMessage);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello from server. Your message was received.");

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
