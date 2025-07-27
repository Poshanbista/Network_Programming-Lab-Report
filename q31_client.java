import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class q31_client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost",1111);

            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            int number  = 23 ;
            dout.writeInt(number);
            dout.flush();


            DataInputStream dis = new DataInputStream(s.getInputStream());
            String answer = (String) dis.readUTF();
            System.out.println("Server says = " +answer);
            dis.close();
            dout.close();
            s.close();

        }catch (IOException e){
            System.out.println(e);
        }
    }
}
