package threads.beispiel1;

public class Start {

	/*
	 * Auf die Ausgabe in der Konsole achten..
	 * Die Threads zählen nicht gleichmäßig oder nacheinander nach oben sondern laufen parallel und pausieren zufällig
	 */
	
	public static void main(String[] args){
		// Threads initialisieren, dadurch wird der Thread noch nicht gestartet
		CountThread thread1 = new CountThread("Thread1");
		CountThread thread2 = new CountThread("Thread2");
		
		// start() erstellt den Thread und löst die run()-Methode aus, die run()-Methode läuft asynchron
		thread1.start();
		thread2.start();
		
		System.out.println("Hauptthread wird für 3 Sekunden pausiert...");
		
		try{
			// "Hauptthread" für 5 Sekunden pausieren während Thread 1 und 2 laufen
			Thread.sleep(5000);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		System.out.println("Hauptthread läuft weiter.");
		
		// Threads beenden
		thread1.disable();
		thread2.disable();
	}
	
}
