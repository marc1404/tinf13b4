package vererbung.periodensystem;

public class Start {

	public static void main(String[] args){
		Periodensystem system = new Periodensystem();
		
		system.addElement(new Element("Wasserstoff", "H", 1, 'K', Aggregatzustand.GASFÖRMIG, true));
		system.addElement(new Element("Helium", "He", 2, 'K', Aggregatzustand.GASFÖRMIG, true));
		system.addElement(new Metall("Natrium", "Na", 11, 'M', Aggregatzustand.FEST, true, false, 21 * Math.pow(10, 6)));
		system.addElement(new Metall("Eisen", "Fe", 26, 'N', Aggregatzustand.FEST, false, false, 10.02 * Math.pow(10, 6)));
		system.addElement(new Metall("Germanium", "Ge", 32, 'N', Aggregatzustand.FEST, false, true, 1.45));
		system.addElement(new Element("Brom", "Br", 35, 'N', Aggregatzustand.FLÜSSIG, true));
		system.addElement(new Metall("Tellur", "Te", 52, 'O', Aggregatzustand.FEST, true, true, 0.005));
		system.addElement(new Metall("Gold", "Au", 79, 'P', Aggregatzustand.FEST, false, false, 44 * Math.pow(10, 6)));
		
		for(Element element:system.getAllMetalls()){
			System.out.println(element.toString());
		}
		
		System.out.println("~(._.~)");
		System.out.println(system.getElement(79));
	}
	
}
