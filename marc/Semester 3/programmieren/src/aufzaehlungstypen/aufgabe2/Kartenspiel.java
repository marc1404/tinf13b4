package aufzaehlungstypen.aufgabe2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kartenspiel {

	private List<Spielkarte> stapel = new ArrayList<Spielkarte>(32);
	
	public Kartenspiel(){
		for(Farbe farbe : Farbe.values()){
			for(Kartenwert wert : Kartenwert.values()){
				stapel.add(new Spielkarte(farbe, wert));
			}
		}
	}
	
	public void shuffle(){
		Collections.shuffle(stapel);
	}
	
	public void sort(){
		Collections.sort(stapel);
	}
	
	public Spielkarte get(){
		return stapel.remove(0);
	}
	
	public List<Spielkarte> all(){
		return stapel;
	}
	
}
