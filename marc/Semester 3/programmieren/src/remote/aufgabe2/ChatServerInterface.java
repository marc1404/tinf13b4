package remote.aufgabe2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatServerInterface extends Remote {

	public void register(ChatClientInterface client) throws RemoteException;
	public void unregister(ChatClientInterface client) throws RemoteException;
	public void post(String user, String message) throws RemoteException;
	
}
