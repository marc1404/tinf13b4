package klassen.aufgaben2;

public class Bankkonto {

	private String name;
	private String vorname;
	private double kontostand;
	private double limit;
	
	public Bankkonto(String name, String vorname, double kontostand, double limit){
		this.name = name;
		this.vorname = vorname;
		this.kontostand = kontostand;
		this.limit = limit;
	}
	
	public Bankkonto(String name, String vorname){
		this(name, vorname, 0, -1000);
	}
	
	public Bankkonto(String name, String vorname, double kontostand){
		this(name, vorname, kontostand, -1000);
	}
	
	public void einzahlen(double betrag){
		this.kontostand += betrag;
	}
	
	public void auszahlen(double betrag){
		if(kontostand - betrag < limit){
			throw new UnsupportedOperationException("Das Limit des Kontos (" + limit + ") wurde überzogen!");
		}
		
		this.kontostand -= betrag;
	}
	
	public double getKontostand(){
		return kontostand;
	}
	
	@Override
	public String toString(){
		return String.format("Bankkonto { name = %s, vorname = %s, kontostand = %s, limit = %s }", name, vorname, kontostand, limit);
	}
	
}
