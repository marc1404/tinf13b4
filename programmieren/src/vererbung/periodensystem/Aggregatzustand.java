package vererbung.periodensystem;

public enum Aggregatzustand {

	FEST(1),
	FLÜSSIG(2),
	GASFÖRMIG(3);
	
	private int zustand;
	
	private Aggregatzustand(int zustand){
		this.zustand = zustand;
	}
	
	public int getZustand(){
		return zustand;
	}
	
}
