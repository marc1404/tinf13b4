package array.aufgaben;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class SiebDesEratostenes {

	public static void main(String[] args){
		int n = 100000000;
		boolean[] isPrime = new boolean[n + 1];
		
		for(int i = 2; i <= n; i++){
			isPrime[i] = true;
		}
		
		for(int i = 2; i * i <= n; i++){
			if(isPrime[i]){
				for(int j = i; i * j <= n; j++){
					isPrime[i * j] = false;
				}
			}
		}
		
		
		try(BufferedWriter out = new BufferedWriter(new FileWriter("prim.dat"))){
			for(int i = 0; i < isPrime.length; i++){
				if(isPrime[i]){
					out.write("" + i);
					out.newLine();
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
