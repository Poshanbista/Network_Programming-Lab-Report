import java.net.*;
import java.util.Enumeration;

public class q5 {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface netInterface = interfaces.nextElement();
                System.out.println("Interface Name: " + netInterface.getName());
                System.out.println("Display Name : " + netInterface.getDisplayName());

                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    System.out.println("IP Address    : " + address.getHostAddress());
                }
            }

        } catch (SocketException e) {
            System.out.println("Error fetching network interfaces: " + e.getMessage());
        }
    }
}
