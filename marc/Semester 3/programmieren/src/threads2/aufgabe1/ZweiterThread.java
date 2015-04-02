package threads2.aufgabe1;

import java.util.Random;

public class ZweiterThread extends Thread {

	private Random rand = new Random();
	private MyBuffer buffer;
	
	public ZweiterThread(MyBuffer buffer){
		this.buffer = buffer;
	}
	
	@Override
	public void run(){
		while(!Thread.interrupted()){
			buffer.get();
			
			try{
				Thread.sleep(rand.nextInt(1000));
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
}
