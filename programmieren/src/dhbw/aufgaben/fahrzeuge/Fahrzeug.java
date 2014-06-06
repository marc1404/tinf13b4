package dhbw.aufgaben.fahrzeuge;

public class Fahrzeug {

	protected int räder = 0;
	private double position = 0;
	private double geschwindigkeit = 0;
	protected double maxGeschwindigkeit = 0;
	
	public void bewege(double minuten){
		this.position = geschwindigkeit / 60 * minuten;
	}
	
	public void setGeschwindigkeit(double geschwindigkeit){
		if(geschwindigkeit < 0){
			geschwindigkeit = 0;
		}else if(geschwindigkeit > maxGeschwindigkeit){
			geschwindigkeit = maxGeschwindigkeit;
		}
		
		this.geschwindigkeit = geschwindigkeit;
	}
	
	public int getRäder(){
		return räder;
	}
	
	public double getPosition(){
		return position;
	}
	
	@Override
	public String toString(){
		return this.getClass().getSimpleName() + " { Position: " + position + ", Geschwindigkeit: " + geschwindigkeit + " km/h }";
	}
	
}
