package threads2.aufgabe1;

import java.util.ArrayList;
import java.util.List;

public class MyBuffer {

	private static final int SIZE = 3;
	private List<Integer> values = new ArrayList<Integer>();
	
	public synchronized void put(int v){
		if(values.size() >= SIZE){
			try{
				wait();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		this.values.add(v);
		
		System.out.println("Put: " + v);
		System.out.println("Füllstand: " + values.size());
		
		notify();
	}
	
	public synchronized int get(){
		int v;
		
		if(values.size() == 0){
			try{
				wait();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		v = values.remove(0);
		
		System.out.println("Get: " + v);
		System.out.println("Füllstand: " + values.size());
		
		notify();
		
		return v;
	}
	
}
