// NIOClient.java
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class q37_client {
    public static void main(String[] args) throws IOException {
        SocketChannel client = SocketChannel.open(new InetSocketAddress("localhost", 5000));
        client.configureBlocking(true);

        System.out.println("Connected to server.");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter message: ");
            String msg = scanner.nextLine();

            if (msg.equalsIgnoreCase("exit")) {
                client.close();
                break;
            }

            ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
            client.write(buffer);
        }

        scanner.close();
    }
}
