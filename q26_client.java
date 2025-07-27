import java.io.*;
import java.net.*;

public class q26_client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5001);

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String message;
        while (true) {
            System.out.print("Enter message: ");
            message = input.readLine();
            if (message.equalsIgnoreCase("exit")) break;

            out.println(message);
            String response = in.readLine();
            System.out.println("Server echoed: " + response);
        }

        socket.close();
    }
}
