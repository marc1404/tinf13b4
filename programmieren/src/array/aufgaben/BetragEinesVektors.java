package array.aufgaben;

import java.util.Scanner;

public class BetragEinesVektors {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Anzahl der Komponenten: ");
		
		int n = scanner.nextInt();
		double[] v = new double[n];
		
		for(int i = 0; i < v.length; i++){
			System.out.print("x" + i + " = ");
			
			v[i] = scanner.nextDouble();
		}
		
		double betrag = 0;
		
		for(int i = 0; i < v.length; i++){
			betrag += v[i] * v[i];
		}
		
		betrag = Math.sqrt(betrag);
		
		System.out.println("Betrag des Vektors = " + betrag);
		
		scanner.close();
	}
	
}
