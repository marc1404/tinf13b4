package array.aufgaben;

import java.util.Scanner;

public class Skalarprodukt {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Anzahl der Komponenten: ");
		
		int n = scanner.nextInt();
		double[] v1 = new double[n];
		double[] v2 = new double[n];
		
		for(int i = 0; i < v1.length; i++){
			System.out.print("x" + i + " = ");
			
			v1[i] = scanner.nextDouble();
		}
		
		for(int i = 0; i < v2.length; i++){
			System.out.print("y" + i + " = ");
			
			v2[i] = scanner.nextDouble();
		}
		
		double skalarprodukt = 0;
		
		for(int i = 0; i < n; i++){
			skalarprodukt += v1[i] * v2[i];
		}
		
		System.out.println("Skalarprodukt = " + skalarprodukt);
		
		scanner.close();
	}
	
}
