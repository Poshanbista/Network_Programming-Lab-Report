import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;

public class Q34FileClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 45456);
            BufferedReader br = new BufferedReader(new FileReader("D:\\sajin.txt"));
            String str = br.readLine();
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeUTF(str);
            System.out.println("Transfer Complete");
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
    
}
Sa Jin
package lab34;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class q34_sender {
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