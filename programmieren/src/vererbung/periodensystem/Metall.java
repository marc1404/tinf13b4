package vererbung.periodensystem;

public class Metall extends Element {

	private boolean halbmetall;
	private double leitfähigkeit;
	
	public Metall(String name, String symbol, int oz, char schale, Aggregatzustand zustand, boolean gruppe, boolean halbmetall, double leitfähigkeit){
		super(name, symbol, oz, schale, zustand, gruppe);
		
		this.halbmetall = halbmetall;
		this.leitfähigkeit = leitfähigkeit;
	}

	@Override
	public String toString(){
		return super.toString() + "; Halbmetall: " + halbmetall + "; Leitfähigkeit: " + leitfähigkeit;
	}
	
	public boolean isHalbmetall() {
		return halbmetall;
	}

	public void setHalbmetall(boolean halbmetall) {
		this.halbmetall = halbmetall;
	}

	public double getLeitfähigkeit() {
		return leitfähigkeit;
	}

	public void setLeitfähigkeit(double leitfähigkeit) {
		this.leitfähigkeit = leitfähigkeit;
	}
	
}
