import java.io.*;
import java.net.*;

public class q30_client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter fileWriter = new PrintWriter("received.txt");

            String line;
            while ((line = in.readLine()) != null) {
                if (line.equals("EOF")) break;
                fileWriter.println(line);
            }

            fileWriter.close();
            System.out.println("✅ File received and saved as received.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
