package array.aufgaben;

import java.util.Scanner;

public class Bubblesort {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Bitte geben sie die Größe des Feldes ein: ");
		
		int n = scanner.nextInt();
		double[] feld = new double[n];
		
		for(int i = 0; i < n; i++){
			System.out.print("feld[" + i + "] = ");
			
			feld[i] = scanner.nextDouble();
		}
		
		for(int j = 0; j < feld.length; j++){
			for(int i = 0; i < (feld.length - 1); i++){
				if(feld[i] > feld[i + 1]){
					double h = feld[i];
					feld[i] = feld[i + 1];
					feld[i + 1] = h;
				}
			}
		}
		
		for(double x:feld){
			System.out.print(x + ", ");
		}
		
		scanner.close();
	}
	
}
