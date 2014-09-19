package dhbw.aufgabe91.jbay;

public class jBay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to jBay by Simon");
		
		Auktionshaus jbay = new Auktionshaus();
		
		jbay.addAuktion(new Auktion( new Ware("Turnschuhe", "Tolle Turnschuhe, kaum getragen"), 1));
		jbay.addAuktion(new Auktion( new Ware("iPad", "Uraltes ipad 3"), 2));
		jbay.addAuktion(new Auktion( new Ware("Currywurst", "Scharf, ohne Pommes"), 3));
		
		BieterTerminal b1 = new BieterTerminal(new Bieter("Micky", "Maus"), jbay);
		BieterTerminal b2 = new BieterTerminal(new Bieter("Donald", "Duck"), jbay);
		
		jbay.registerTerminal(b1);
		jbay.registerTerminal(b2);
		
	}

}
