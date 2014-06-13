package datenstrukturen.aufgabe2.bucherverwaltung;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;

public class Archiv {

	private File f;
	private Collection<Buch> books = new ArrayList<Buch>();
	
	public Archiv(File f){
		parseFile(f);
	}
	
	private void parseFile(File f){
		if(f.exists()){
			try(BufferedReader in = new BufferedReader(new FileReader(f))){
				String line;
				
				while((line = in.readLine()) != null){
					String[] split = line.split(";");
					
					if(split.length >= 4){
						String autor = split[0];
						String titel = split[1];
						int jahr = Integer.parseInt(split[2]);
						String verlag = split[3];
						Buch buch = new Buch(autor, titel, jahr, verlag);
						
						books.add(buch);
					}
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	public void addBook(Buch buch){
		String bookAsString = buch.getAutor() + ";" + buch.getTitle() + ";" + buch.getYear() + ";" + buch.getVerlag();
		
		books.add(buch);
		
		try{
			Files.write(f.toPath(), bookAsString.getBytes(), StandardOpenOption.APPEND);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
