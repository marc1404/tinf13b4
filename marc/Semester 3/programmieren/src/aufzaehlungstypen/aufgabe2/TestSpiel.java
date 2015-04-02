package aufzaehlungstypen.aufgabe2;

public class TestSpiel {

	public static void main(String[] args){
		// Kartenspiel erzeugen
		Kartenspiel spiel = new Kartenspiel();
		
		// mischen
		spiel.shuffle();
		
		// 10 Karten vom Stapel entnehmen
		Spielkarte herz7 = new Spielkarte(Farbe.HERZ, Kartenwert.SIEBEN);
		
		for(int i = 0; i < 10; i++){
			Spielkarte karte = spiel.get();
			
			System.out.println(karte + " - Vergleich mit Herz 7: " + karte.compareTo(herz7));
		}
		
		// die restlichen Karten sortieren
		spiel.sort();
		
		// und auflisten
		System.out.println(spiel.all());
	}
	
}
