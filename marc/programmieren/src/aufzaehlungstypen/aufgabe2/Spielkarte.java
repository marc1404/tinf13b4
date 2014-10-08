package aufzaehlungstypen.aufgabe2;

public class Spielkarte implements Comparable<Spielkarte> {

	private Farbe farbe;
	private Kartenwert wert;
	
	public Spielkarte(Farbe farbe, Kartenwert wert){
		this.farbe = farbe;
		this.wert = wert;
	}
	
	public Kartenwert getWert(){
		return wert;
	}
	
	public Farbe getFarbe(){
		return farbe;
	}
	
	@Override
	public String toString(){
		return farbe + " " + wert;
	}
	
	@Override
	public int compareTo(Spielkarte karte){
		int thisOrdinal = this.wert.ordinal() + farbe.ordinal() * 10;
		int otherOrdinal = karte.getWert().ordinal() + karte.getFarbe().ordinal() * 10;
		
		return thisOrdinal - otherOrdinal;
	}
	
}
