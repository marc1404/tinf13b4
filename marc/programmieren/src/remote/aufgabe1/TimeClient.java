package remote.aufgabe1;

import java.rmi.Naming;

public class TimeClient {

	public static void main(String[] args) throws Exception {
		String url="//localhost/Time";
		TimeServerInterface server = (TimeServerInterface)Naming.lookup(url);
		
		for(;;){
			System.out.println(server.getTime());
		}
	}
	
}
