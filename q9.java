import java.net.*;
import java.util.*;

public class q9{

    public static void main(String[] args) {
        try {
            
            String interfaceName = "eth0"; 
            NetworkInterface netIfByName = NetworkInterface.getByName(interfaceName);

            if (netIfByName != null) {
                System.out.println("Network Interface found by name: " + interfaceName);
                printNetworkInterfaceDetails(netIfByName);
            } else {
                System.out.println("No Network Interface found with name: " + interfaceName);
            }

            System.out.println("=================================");

            
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
            if (nets.hasMoreElements()) {
                NetworkInterface firstInterface = nets.nextElement();
                Enumeration<InetAddress> addresses = firstInterface.getInetAddresses();
                if (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    NetworkInterface netIfByAddr = NetworkInterface.getByInetAddress(addr);
                    System.out.println("Network Interface found by IP address: " + addr.getHostAddress());
                    printNetworkInterfaceDetails(netIfByAddr);
                }
            }

            System.out.println("=================================");

            
            System.out.println("Listing all network interfaces on this machine:");
            Enumeration<NetworkInterface> allNets = NetworkInterface.getNetworkInterfaces();
            while (allNets.hasMoreElements()) {
                NetworkInterface netIf = allNets.nextElement();
                printNetworkInterfaceDetails(netIf);
                System.out.println("----------------------------");
            }

        } catch (SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
        }
    }

    
    public static void printNetworkInterfaceDetails(NetworkInterface netIf) throws SocketException {
        System.out.println("Name: " + netIf.getName());
        System.out.println("Display Name: " + netIf.getDisplayName());

       
        byte[] mac = netIf.getHardwareAddress();
        if (mac != null) {
            System.out.print("MAC Address: ");
            for (int i = 0; i < mac.length; i++) {
                System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
            }
            System.out.println();
        } else {
            System.out.println("MAC Address: Not available");
        }

        
        System.out.println("IP Addresses:");
        Enumeration<InetAddress> inetAddresses = netIf.getInetAddresses();
        while (inetAddresses.hasMoreElements()) {
            InetAddress inetAddress = inetAddresses.nextElement();
            System.out.println("\t" + inetAddress);
        }

       
        System.out.println("Is up? " + netIf.isUp());
        System.out.println("Is loopback? " + netIf.isLoopback());
        System.out.println("Is virtual? " + netIf.isVirtual());
        System.out.println("Supports multicast? " + netIf.supportsMulticast());
    }
}
