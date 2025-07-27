import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class q45_implementation extends UnicastRemoteObject implements q45_interface {

    protected q45_implementation() throws RemoteException {
        super();
    }

    @Override
    public int calculateGCD(int a, int b) throws RemoteException {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
