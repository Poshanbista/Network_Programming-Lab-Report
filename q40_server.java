import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class q40_server {
    public static void main(String[] args){
        try {
            DatagramSocket s = new DatagramSocket(1234);
            byte[] receivedData = new byte[1024];
            while(true){
                DatagramPacket receivePkt = new DatagramPacket(receivedData,receivedData.length);
                s.receive(receivePkt);

                String msg = new String(receivePkt.getData(),0,receivePkt.getLength());
                System.out.println("Client message = " +msg);

                // to reply client
                String reply = "Hello i am from server";
                byte[] sendData = reply.getBytes();

                InetAddress addr = receivePkt.getAddress();
                int port = receivePkt.getPort();

                DatagramPacket sendreply = new DatagramPacket(sendData, sendData.length, addr, port);
                s.send(sendreply);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
