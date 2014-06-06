package dhbw.aufgaben.fahrzeuge;

public class Wettrennen {

	public static void main(String[] args){
		Fahrrad fahrrad = new Fahrrad();
		Auto auto = new Auto();
		Rennwagen rennwagen = new Rennwagen();
		Krankenwagen krankenwagen = new Krankenwagen();
		
		fahrrad.setGeschwindigkeit(20);
		auto.setGeschwindigkeit(150);
		rennwagen.setGeschwindigkeit(200);
		krankenwagen.setGeschwindigkeit(80);
		
		fahrrad.bewege(4 * 60);
		auto.bewege(60);
		rennwagen.bewege(60);
		krankenwagen.bewege(60);
		
		System.out.println(fahrrad);
		System.out.println(auto);
		System.out.println(rennwagen);
		System.out.println(krankenwagen);
	}
	
}
