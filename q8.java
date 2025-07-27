import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Scanner;

public class q8 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter IP address: ");
            String ipAddress = scanner.nextLine();

            InetAddress inet = InetAddress.getByName(ipAddress);

            NetworkInterface network = NetworkInterface.getByInetAddress(inet);

            if (network == null) {
                System.out.println("No network interface found for IP: " + ipAddress);
                return;
            }

            byte[] mac = network.getHardwareAddress();

            if (mac == null) {
                System.out.println("MAC address not found for IP: " + ipAddress);
                return;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }

            System.out.println("MAC address for IP " + ipAddress + " is: " + sb.toString());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
