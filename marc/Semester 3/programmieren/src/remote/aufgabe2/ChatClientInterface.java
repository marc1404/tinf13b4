package remote.aufgabe2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatClientInterface extends Remote {

	public void message(String message) throws RemoteException;
	public void message(String user, String message) throws RemoteException;
	public String getUser() throws RemoteException;
	
}
