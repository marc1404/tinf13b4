package io.aufgabe4;

import java.io.BufferedReader;
import java.io.FileReader;

public class Start {

	public static void main(String[] args){
		StringBuilder message = new StringBuilder();
		int sum = 0;
		
		try(BufferedReader in = new BufferedReader(new FileReader("teil_einer_datei.txt"))){
			in.readLine();
			in.readLine();
			
			for(int i = 0; i < 4; i++){
				String line = in.readLine();
				sum += Integer.parseInt(line);
				
				message.append(line);
				
				if(i < 3){
					message.append(" + ");
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		message.append(" = " + sum);
		
		System.out.println(message);
	}
	
}
