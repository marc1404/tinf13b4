package threads.beispiel1;

import java.util.Random;

// Erbt von der Klasse Thread
public class CountThread extends Thread {

	private Random random = new Random();
	private String name;
	private int count = 0;
	private boolean enabled = true;
	
	public CountThread(String name){
		this.name = name;
	}
	
	// Nur der Code in der run()-Methode wird asynchron ausgeführt
	// run darf NICHT direkt aufgerufen werden
	@Override
	public void run(){
		// Wenn die run()-Methode fertig ist wird auch der Thread beendet -> while-Schleife
		while(enabled){
			// Die sleep Zeit für Threads wird in Millisekunden angegeben
			long sleepTime = random.nextInt(1000); // Zahl zwischen 0 und 999
			
			System.out.println(name + ": " + count++);
			
			try{
				// Thread.sleep() lässt den aktuellen Thread für die angegebene Anzahl von Millisekunden pausieren
				Thread.sleep(sleepTime);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	public void disable(){
		this.enabled = false;
	}
	
}
