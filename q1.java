 import java.net.InetAddress;
 public class q1 {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("IP address of your system is: " + ip.getHostAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 }