package probeklausur;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Zoo {

	public static void main(String[] args){
		if(args.length >= 1){
			int max = Integer.parseInt(args[0]);
			Zoo zoo = new Zoo(max);
			
			try{
				zoo.addAnimal(new Raubtier("Tiger", "Fred"));
				zoo.addAnimal(new Raubtier("Tiger", "Lisa"));
				zoo.addAnimal(new Raubtier("Löwe", "Simba"));
				zoo.addAnimal(new Singvogel("Kleiber", "Hansi"));
				zoo.addAnimal(new Singvogel("Schneeammer", "Sina"));
				zoo.addAnimal(new Singvogel("Zaunkoenig", "Henry"));
			}catch(ZooCapacityException ex){
				System.err.println("Fehler: Zoo-Kapazität überschritten!");
			}
			
			System.out.println();
			
			try{
				zoo.saveToFile("zootiere.txt");
				System.out.println("Tiere in Datei gespeichert!");
			}catch(ZooFileException ex){
				ex.printStackTrace();
			}
				
			System.out.println();
			
			zoo.fuettern("Körner");
			
			System.out.println();
			
			printExistsAnimal(zoo, "Fred");
			printExistsAnimal(zoo, "Kimba");
			printExistsAnimal(zoo, "Henry");
			printExistsAnimal(zoo, "Lotte");
		}else{
			System.err.println("Bitte geben Sie die maximale Kapazität des Zoos in den Parametern an!");
		}
	}
	
	private static void printExistsAnimal(Zoo zoo, String name){
		System.out.print("Gibt es '" + name + "' im Zoo? ");
		
		if(zoo.existsAnimal(name)){
			System.out.println("ja");
		}else{
			System.out.println("nein");
		}
	}
	
	private int max;
	private ZooTier[] tiere;
	
	public Zoo(int max){
		this.max = max;
		this.tiere = new ZooTier[max];
	}
	
	public void addAnimal(ZooTier tier) throws ZooCapacityException {
			for(int i = 0; i < tiere.length; i++){
				if(tiere[i] == null){
					tiere[i] = tier;
					
					System.out.println(tier.toString() + " zum Zoo hinzugefügt.");
					
					return;
				}
			}
			
			throw new ZooCapacityException(max);
	}
	
	public ZooTier[] getAnimals(){
		int animalCount = 0;
		
		for(ZooTier tier:tiere){
			if(tier != null){
				animalCount++;
			}
		}
		
		ZooTier[] animals = new ZooTier[animalCount];
		int j = 0;
		
		for(ZooTier tier:tiere){
			if(tier != null){
				animals[j++] = tier;
			}
		}
		
		return animals;
	}
	
	public boolean existsAnimal(String name){
		for(ZooTier tier:tiere){
			if(tier.getName().equals(name)){
				return true;
			}
		}
		
		return false;
	}
	
	public void fuettern(String futter){
		for(ZooTier tier:tiere){
			tier.fuettern(futter);
		}
	}
	
	public void saveToFile(String filename) throws ZooFileException {
		try(BufferedWriter out = new BufferedWriter(new FileWriter(filename))){
			for(ZooTier tier:tiere){
				out.write(tier.getArt() + ";" + tier.getName() + ";" + tier.getClass().getSimpleName());
				out.newLine();
			}
		}catch(IOException ex){
			throw new ZooFileException("Es ist ein Fehler beim Schreiben der Datei " + filename + " aufgetreten!");
		}
	}
	
}
