package remote.aufgabe1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TimeServerInterface extends Remote {

	public String getTime() throws RemoteException;
	
}
