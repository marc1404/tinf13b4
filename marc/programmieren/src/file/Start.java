package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Start {

	public static void main(String[] args){
		File datei = new File("neuedatei.txt");
		
		System.out.println(datei + " " + datei.exists());
		
		try{
			datei.createNewFile();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		System.out.println(datei + " " + datei.exists());
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(datei));
			
			out.write("Hallo");
			out.newLine();
			out.write("halli hallöchen");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(datei));
			
			System.out.println(in.readLine());
			
			String line;
			
			while((line = in.readLine()) != null){
				System.out.println(line);
			}
			
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
