import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class q41_server {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9876);
            byte[] receiveBuffer = new byte[1024];
            byte[] sendBuffer;

            System.out.println("Server is running...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);

                String numberStr = new String(receivePacket.getData(), 0, receivePacket.getLength());
                int number = Integer.parseInt(numberStr);
                String result = isArmstrong(number) ? "Armstrong Number" : "Not an Armstrong Number";

                sendBuffer = result.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(
                        sendBuffer,
                        sendBuffer.length,
                        receivePacket.getAddress(),
                        receivePacket.getPort()
                );
                serverSocket.send(sendPacket);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isArmstrong(int num) {
        int original = num;
        int result = 0;
        int digits = String.valueOf(num).length();

        while (num != 0) {
            int digit = num % 10;
            result += Math.pow(digit, digits);
            num /= 10;
        }

        return result == original;
    }
}
