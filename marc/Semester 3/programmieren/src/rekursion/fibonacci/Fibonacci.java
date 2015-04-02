package rekursion.fibonacci;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		int n;
		
		do{
			System.out.print("Geben Sie bitte eine positive ganze Zahl ein: ");
			
			n = scanner.nextInt();
		}while(n < 1);
		
		scanner.close();
		
		for(int i = 1; i <= n; i++){
			int fibonacci = fibonacci(i);
			
			System.out.println("F( " + i + ") = " + fibonacci);
		}
	}
	
	private static int fibonacci(int n){
		if(n == 1){
			return 1;
		}else if(n == 2){
			return 1;
		}else{
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
	
}
