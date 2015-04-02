package remote.aufgabe2;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class ChatServer extends UnicastRemoteObject implements ChatServerInterface {

	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) throws Exception {
		LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		Naming.rebind("chatserver", new ChatServer());
	}
	
	private Map<String, ChatClientInterface> clients = new HashMap<String, ChatClientInterface>();
	
	protected ChatServer() throws RemoteException {
		super();
	}

	@Override
	public void register(ChatClientInterface client) throws RemoteException {
		String user = client.getUser();
	
		if(!clients.containsKey(user)){
			clients.put(client.getUser(), client);
			
			StringBuilder users = new StringBuilder();
			
			users.append("Available users: ");
			
			for(ChatClientInterface c:clients.values()){
				users.append(c.getUser()).append(", ");
			}
			
			client.message(users.toString());
			broadcast(client.getUser() + " has joined the chat.");
		}else{
			client.message("Error: Username is already taken!");
		}
	}

	@Override
	public void unregister(ChatClientInterface client) throws RemoteException {
		clients.remove(client.getUser());
		broadcast(client.getUser() + " has left the chat.");
	}

	@Override
	public void post(String user, String message) throws RemoteException {
		broadcast(user + ": " + message);
	}
	
	private void broadcast(String message) throws RemoteException {
		for(ChatClientInterface client:clients.values()){
			client.message(message);
		}
	}

}
