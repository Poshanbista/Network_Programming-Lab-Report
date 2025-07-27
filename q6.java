import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class q6 {
    public static void main(String[] args) {
        try {
            // Get the local host (your system)
            InetAddress localHost = InetAddress.getLocalHost();
            
            // Get the IP address
            String ipAddress = localHost.getHostAddress();
            System.out.println("IP Address: " + ipAddress);
            
            // Get the network interface for the local host
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(localHost);
            if (networkInterface == null) {
                System.out.println("Network Interface for the specified address is not found.");
                return;
            }
            
            // Get the MAC address bytes
            byte[] macAddressBytes = networkInterface.getHardwareAddress();
            
            if (macAddressBytes == null) {
                System.out.println("MAC Address not found.");
                return;
            }
            
            // Convert bytes to readable MAC address format
            StringBuilder macAddressStr = new StringBuilder();
            for (int i = 0; i < macAddressBytes.length; i++) {
                macAddressStr.append(String.format("%02X%s", macAddressBytes[i], (i < macAddressBytes.length - 1) ? "-" : ""));
            }
            
            System.out.println("MAC Address: " + macAddressStr.toString());
            
        } catch (UnknownHostException e) {
            System.out.println("UnknownHostException: " + e.getMessage());
        } catch (SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
        }
    }
}
