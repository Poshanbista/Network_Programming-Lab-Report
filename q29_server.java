import java.io.*;
import java.net.*;

public class q29_server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);

        Socket socket = serverSocket.accept();

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        int number = dis.readInt();
        long result = factorial(number);

        dos.writeLong(result);

        System.out.println("Factorial of " + number + " is sent to the client.");

        dis.close();
        dos.close();
        socket.close();
        serverSocket.close();
    }

    private static long factorial(int n) {
        if (n < 0) return -1; // invalid input
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}

