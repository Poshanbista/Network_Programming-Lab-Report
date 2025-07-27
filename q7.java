import java.net.*;
import java.util.*;
import java.io.*;

public class q7 {

    // Convert byte[] MAC to human-readable MAC address string
    public static String macBytesToString(byte[] mac) {
        if (mac == null) return "No MAC address";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws SocketException, IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Listing all network interfaces:\n");
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        while (nets.hasMoreElements()) {
            NetworkInterface netint = nets.nextElement();
            byte[] mac = netint.getHardwareAddress();
            System.out.printf("Name: %s\n", netint.getName());
            System.out.printf("Display Name: %s\n", netint.getDisplayName());
            System.out.printf("MAC Address: %s\n", macBytesToString(mac));
            Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddress = inetAddresses.nextElement();
                System.out.printf("IP Address: %s\n", inetAddress.getHostAddress());
            }
            System.out.println("--------------------------");
        }

        System.out.println("\nEnter Interface Name or MAC Address to find IP addresses:");
        String input = scanner.nextLine().trim().toUpperCase();

        NetworkInterface targetInterface = null;
        nets = NetworkInterface.getNetworkInterfaces();

        while (nets.hasMoreElements()) {
            NetworkInterface netint = nets.nextElement();

            String name = netint.getName().toUpperCase();
            byte[] mac = netint.getHardwareAddress();
            String macStr = macBytesToString(mac).toUpperCase();

            if (input.equals(name) || input.equals(macStr)) {
                targetInterface = netint;
                break;
            }
        }

        if (targetInterface == null) {
            System.out.println("No network interface found matching the input.");
        } else {
            System.out.printf("Interface found: %s (%s)\n", targetInterface.getName(), targetInterface.getDisplayName());
            Enumeration<InetAddress> inetAddresses = targetInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddress = inetAddresses.nextElement();
                System.out.printf("IP Address: %s\n", inetAddress.getHostAddress());
            }
        }

        scanner.close();
    }
}
