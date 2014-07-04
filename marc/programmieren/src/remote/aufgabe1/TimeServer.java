package remote.aufgabe1;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeServer extends UnicastRemoteObject implements TimeServerInterface {

	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) throws Exception {
		LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		Naming.rebind("Time", new TimeServer());
	}
	
	protected TimeServer() throws RemoteException {
		super();
	}

	@Override
	public String getTime() throws RemoteException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		
		return sdf.format(Calendar.getInstance().getTime());
	}

	
	
}
