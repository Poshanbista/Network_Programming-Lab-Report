import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class q40_client {
    public static void main(String[] args) {
        try {
            DatagramSocket s = new DatagramSocket();

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter message to the server: ");
            String msg = sc.nextLine();

            byte[] sendData = msg.getBytes();

            InetAddress add = InetAddress.getByName("localhost");

            DatagramPacket dp = new DatagramPacket(sendData, sendData.length,add,1234);
            s.send(dp);

            // recieve from server

            byte[] receivedData = new byte[1024];
            DatagramPacket receivedPkt = new DatagramPacket(receivedData, receivedData.length);
            s.receive(receivedPkt);

            String reply = new String(receivedPkt.getData(),0,receivedPkt.getLength());
            System.out.println("Reply from server :" +reply);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
