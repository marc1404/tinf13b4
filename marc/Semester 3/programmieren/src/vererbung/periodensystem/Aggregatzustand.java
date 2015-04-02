package vererbung.periodensystem;

public enum Aggregatzustand {

	FEST(1),
	FLUESSIG(2),
	GASFOERMIG(3);
	
	private int zustand;
	
	private Aggregatzustand(int zustand){
		this.zustand = zustand;
	}
	
	public int getZustand(){
		return zustand;
	}
	
}
