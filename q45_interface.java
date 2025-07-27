import java.rmi.Remote;
import java.rmi.RemoteException;

public interface q45_interface extends Remote {
    int calculateGCD(int a, int b) throws RemoteException;
}
