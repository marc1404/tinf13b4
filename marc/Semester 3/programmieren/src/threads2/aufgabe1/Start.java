package threads2.aufgabe1;

public class Start {

	public static void main(String[] args){
		MyBuffer buffer = new MyBuffer();
		ErsterThread thread1 = new ErsterThread(buffer);
		ZweiterThread thread2 = new ZweiterThread(buffer);
		
		thread1.start();
		thread2.start();
	}
	
}
