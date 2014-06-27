package threads2.aufgabe1;

import java.util.Random;

public class ErsterThread extends Thread {

	private Random rand = new Random();
	private MyBuffer buffer;
	
	public ErsterThread(MyBuffer buffer){
		this.buffer = buffer;
	}
	
	@Override
	public void run(){
		while(!Thread.interrupted()){
			buffer.put(rand.nextInt(10));
			
			try{
				Thread.sleep(rand.nextInt(1000));
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
}
