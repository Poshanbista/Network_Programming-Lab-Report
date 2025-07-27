import java.io.*;
import java.net.*;
import java.util.Scanner;

public class q29_client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to calculate factorial: ");
        int number = scanner.nextInt();

        dos.writeInt(number);
        long result = dis.readLong();

        System.out.println("Factorial received from server: " + result);

        dis.close();
        dos.close();
        socket.close();
    }
}
