import java.io.*;
import java.net.*;

public class q30_server {
    public static void main(String[] args) {
        int port = 5000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            File file = new File("sample.txt");
            if (!file.exists()) {
                System.out.println("sample.txt not found!");
                return;
            }

            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String line;
            while ((line = fileReader.readLine()) != null) {
                out.println(line);  // send line to client
            }

            out.println("EOF"); // end of file indicator
            fileReader.close();
            socket.close();

            System.out.println("✅ File sent successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
