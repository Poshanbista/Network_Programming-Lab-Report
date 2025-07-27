import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class q45_client {
    public static void main(String[] args) {
        try {
            // Get registry at localhost
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Lookup the remote object
            q45_interface stub = (q45_interface) registry.lookup("GCDService");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter first number: ");
            int a = sc.nextInt();
            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            // Invoke remote method
            int result = stub.calculateGCD(a, b);
            System.out.println("GCD is: " + result);

        } catch (Exception e) {
            System.out.println("Client Exception: " + e);
        }
    }
}
