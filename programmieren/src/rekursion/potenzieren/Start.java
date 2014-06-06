package rekursion.potenzieren;

import java.util.Scanner;

public class Start {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Geben Sie bitte die Basis ein: ");
		
		double x = scanner.nextDouble();
		
		System.out.print("Geben Sie bitte den positiven ganzzahligen Exponenten ein: ");
		
		int n = scanner.nextInt();
		
		scanner.close();
		
		double y = Potenzieren.xhochn(x, n);
		
		System.out.println(x + "^ " + n + " = " + y);
	}
	
}
