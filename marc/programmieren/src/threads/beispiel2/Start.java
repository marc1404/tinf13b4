package threads.beispiel2;

public class Start {

	public static void main(String[] args){
		final UhrFrame uhr = new UhrFrame();
		// anonyme Klasse welche die run()-Methode enthält
		Runnable task = new Runnable(){
			@Override
			public void run(){
				while(true){
					uhr.updateTime();
					
					try{
						Thread.sleep(1000);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}
		};
		
		// Neues Thread Objekt erstellen und Runnable-Objekt übergeben
		Thread thread = new Thread(task);
		
		thread.start();
	}
	
}
