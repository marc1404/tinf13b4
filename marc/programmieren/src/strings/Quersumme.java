package strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Quersumme {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String numberAsString;
		
		do{
			System.out.print("Bitte geben sie eine natürliche Zahl ein: ");
			
			numberAsString = scanner.nextLine();
			
			System.out.println();
		}while(!isValidNumber(numberAsString));
		
		scanner.close();
		
		char[] cc = numberAsString.toCharArray();
		int quersumme = 0;
		
		for(char c:cc){
			quersumme += Integer.parseInt("" + c);
		}
		
		String message = "Die Quersumme von " + numberAsString + " ist gleich " + quersumme + ".";
		
		System.out.println(message);
		
		try(BufferedWriter out = new BufferedWriter(new FileWriter("quersumme" + numberAsString + ".txt"))){
			out.write(message);
			out.flush();
			out.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private static boolean isValidNumber(String numberAsString){
		try{
			Integer.parseInt(numberAsString);
			
			return true;
		}catch(Exception ex){
			System.err.println(numberAsString + " ist keine natürliche Zahl!");
			
			return false;
		}
	}
	
}
