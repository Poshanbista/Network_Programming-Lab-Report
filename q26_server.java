import java.io.*;
import java.net.*;

public class q26_server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5001);
        Socket clientSocket = serverSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println("Received: " + line);
            out.println("Echo: " + line);
        }

        clientSocket.close();
        serverSocket.close();
    }
}
