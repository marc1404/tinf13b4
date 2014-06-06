package array.aufgaben;

public class Fibonacci {

	public static void main(String[] args){
		int[] fibonacci = new int[51];
		fibonacci[0] = 1;
		fibonacci[1] = 1;
		
		for(int n = 2; n <= 50; n++){
			fibonacci[n] = fibonacci[n - 1] + fibonacci[n - 2];
		}
		
		for(int i = 0; i < fibonacci.length; i++){
			System.out.println("a" + i + " = " + fibonacci[i]);
		}
	}
	
}
