package rekursion.quicksort;

import java.util.Random;

public class Quicksort {

	public static void main(String[] args){
		Random random = new Random();
		int[] daten = new int[10000];
		
		for(int i = 0; i < daten.length; i++){
			daten[i] = random.nextInt(10);
		}
		
		printArray(daten);
		sortiere(daten);
		printArray(daten);
	}
	
	private static void printArray(int[] array){
		System.out.print("{");
		
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i]);
			
			if(i < array.length - 1){
				System.out.print(",");
			}
		}
		
		System.out.println("}");
	}
	
	private static void sortiere(int[] daten){
		quicksort(daten, 0, daten.length - 1);
	}
	
	private static void quicksort(int[] daten, int links, int rechts){
		if(links < rechts){
			int teiler = teile(daten, links, rechts);
			
			quicksort(daten, links, teiler - 1);
			quicksort(daten, teiler + 1, rechts);
		}
	}
	
	private static int teile(int[] daten, int links, int rechts){
		int i = links;
		int j = rechts - 1;
		int pivot = daten[rechts];
		
		do{
			while(daten[i] <= pivot && i < rechts){
				i = i + 1;
			}
			
			while(daten[j] >= pivot && j > links){
				j = j - 1;
			}
			
			if(i < j){
				tausche(daten, i, j);
			}
		}while(i < j);
		
		if(daten[i] > pivot){
			tausche(daten, i, rechts);
		}
		
		return i;
	}
	
	private static void tausche(int[] daten, int i1, int i2){
		int h = daten[i1];
		daten[i1] = daten[i2];
		daten[i2] = h;
	}
	
}
