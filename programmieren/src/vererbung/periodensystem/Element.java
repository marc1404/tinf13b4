package vererbung.periodensystem;

public class Element {

	private String name;
	private String symbol;
	private int oz;
	private char schale;
	private Aggregatzustand zustand;
	private boolean gruppe;
	
	public Element(String name, String symbol, int oz, char schale, Aggregatzustand zustand, boolean gruppe){
		this.name = name;
		this.symbol = symbol;
		this.oz = oz;
		this.schale = schale;
		this.zustand = zustand;
		this.gruppe = gruppe;
	}

	@Override
	public String toString(){
		return "Name: " + name + "; " +
				"Symbol: " + symbol + "; " +
				"Ordnungszahl: " + oz + "; " +
				"Schale: " + schale + "; " +
				"Aggregatzustand: " + zustand + "; " +
				"Hauptgruppe/Nebengruppe: " + gruppe;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Element){
			Element element = (Element)obj;
			
			return element.getOz() == oz;
		}
		
		return false;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getOz() {
		return oz;
	}

	public void setOz(int oz) {
		this.oz = oz;
	}

	public char getSchale() {
		return schale;
	}

	public void setSchale(char schale) {
		this.schale = schale;
	}

	public Aggregatzustand getZustand() {
		return zustand;
	}

	public void setZustand(Aggregatzustand zustand) {
		this.zustand = zustand;
	}

	public boolean isGruppe() {
		return gruppe;
	}

	public void setGruppe(boolean gruppe) {
		this.gruppe = gruppe;
	}
	
}
