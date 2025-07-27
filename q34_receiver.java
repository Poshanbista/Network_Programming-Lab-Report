import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class q34_receiver {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(45456);
            Socket s = ss.accept();
            DataInputStream in = new DataInputStream(s.getInputStream());
            String str = in.readUTF();
            FileOutputStream out = new FileOutputStream("D:\\sajin.txt");
            byte[] buf = str.getBytes();
            out.write(buf);
            System.out.println("File Transferred");
        } catch (IOException e) {
            System.out.println("Exception : "+e);
        }
    }
    
}