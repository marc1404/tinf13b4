package aufgaben;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Studium {

	public static void main(String[] args) throws Exception {
		
	}
	
	@SuppressWarnings("unused")
	private static void aufgabe1Wertebereich(){
		short x = 32767;
		
		System.out.println(x);
		
		x++;
		
		System.out.println(x);
	}
	
	@SuppressWarnings("unused")
	private static void aufgabe2Ostertermin() throws ParseException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Bitte geben Sie ein Jahr ein: ");
		
		int year = scanner.nextInt();
		int a = year % 19;
		int b = year % 4;
		int c = year % 7;
		int k = year / 100;
		int p = (8 * k + 13) / 25;
		int q = k / 4;
		int M = (15 + k - p - q) % 30;
		int N = (4 + k - q) % 7;
		int d = (19 * a + M) % 30;
		int e = (2 * b + 4 * c + 6 * d + N) % 7;
		int ostern = 22 + d + e;
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date date = sdf.parse(ostern + ".03." + year);
		
		System.out.println("Ostertermin: " + ostern + " -> " + sdf.format(date));
	}
	
	@SuppressWarnings("unused")
	private static void aufgabe3InkrementDekrement(){
		int i=0;
		int j=0;
		j = ++i;
		int k = j++ + ++i;
		System.out.println("k: " + k);
		System.out.println("*: " + j++ + ++i);
		System.out.println(j++ + ++i);
		int m = j++ * ++i;
		System.out.println("m: " + m);
		int n = --j * --i;
		System.out.println("n: " + n);
		System.out.println("i: " + i);
		System.out.println("j: " + j);
	}
	
	@SuppressWarnings("unused")
	private static void aufgabe4Schaltjahr(){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Bitte geben Sie ein Jahr ein: ");
		
		int year = scanner.nextInt();
		boolean isSchaltjahr = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
		
		if(isSchaltjahr){
			System.out.println("Das Jahr " + year + " ist ein Schaltjahr");
		}else{
			System.out.println("Das Jahr " + year + " ist kein Schaltjahr");
		}
	}
	
	@SuppressWarnings("unused")
	private static void quadratischeGleichung(double a, double b, double c){
		System.out.println("--- Beginn einer Quadratischen Gleichung ---");
		System.out.println("Quadratische Gleichung für a = " + a + "; b = " + b + "; c = " + c);
		
		if(a == 0){
			if(b == 0){
				System.out.println("Die Gleichung ist degeneriert.");
			}else{
				double x = -(c / b);
				
				System.out.println("x: " + x);
			}
		}else{
			double d = Math.pow(b, 2) - 4 * a * c;
			
			System.out.println("Diskriminante der Gleichung: " + d);
			
			if(d >= 0){
				double sqrtD = Math.sqrt(d);
				double denominator = 2 * a;
				double x1 = (-b + sqrtD) / denominator;
				double x2 = (-b - sqrtD) / denominator;
				
				System.out.println("x1: " + x1);
				System.out.println("x2: " + x2);
			}else{
				System.out.println("Die Lösung ist konjugiert komplex.");
			}
		}
		
		System.out.println("--- Ende der Quadratischen Gleichung ---");
	}
	
}
