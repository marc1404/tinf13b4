package datenstrukturen.aufgabe1.lottozahlen;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Start {

	public static void main(String[] args){
		Set<Integer> lottozahlen = new HashSet<Integer>();
		Random rand = new Random();
		
		for(int i = 0; i < 7; i++){
			lottozahlen.add(rand.nextInt(49) + 1);
		}
		
		Iterator<Integer> iterator = lottozahlen.iterator();
		int j = 0;
		
		while(iterator.hasNext()){
			int number = iterator.next();
			
			if(j < 6){
				System.out.print(number + " ");
			}else{
				System.out.println("Zusatzzahl: " + number);
			}
			
			j++;
		}
	}
	
}
