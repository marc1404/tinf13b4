package babylonisches.wurzelziehen;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("a: "); int a = scanner.nextInt();
		
		double tenPowMinusSix = Math.pow(10, -6);
		double x1 = 1;
		boolean isAbsLower = false;
		
		do{
			double x2 = (x1 + a / x1) / 2;
			
			System.out.println("x: " + x2);
			
			double abs = Math.abs(x2 - x1);
			x1 = x2;
			isAbsLower = abs < tenPowMinusSix;
		}while(!isAbsLower);
	}
	
}