import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class q31_server {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(1111)) {
            while (true) {
                try {
                    Socket s = ss.accept();
                    Thread t = new primeorcompositethread(s);  // make sure name matches below
                    t.start();
                } catch (IOException e) {
                    System.out.println("Error accepting connection: " + e);
                }
            }
        } catch (IOException e) {
            System.out.println("Server not connected: " + e);
        }
    }

    private static class primeorcompositethread extends Thread {
        private Socket s;

        public primeorcompositethread(Socket s) {
            this.s = s;
        }

        public void run() {
            try {
                DataInputStream dis = new DataInputStream(s.getInputStream());
                int number = dis.readInt();
                System.out.println("Received number = " + number);

                String result;

                if (number <= 1) {
                    result = number + " is an invalid number";
                } else {
                    boolean isPrime = true;
                    for (int i = 2; i <= Math.sqrt(number); i++) {
                        if (number % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    result = isPrime ? number + " is prime" : number + " is composite";
                }

                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                dout.writeUTF(result);

                dout.flush();
                dout.close();
                s.close();

            } catch (IOException e) {
                System.out.println("Thread error: " + e);
            }
        }
    }
}
