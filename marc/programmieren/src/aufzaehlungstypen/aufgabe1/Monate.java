package aufzaehlungstypen.aufgabe1;

public enum Monate {
	
	JANUAR("Januar", 31, new String[]{"Hartung", "Eismond"}),
	FEBRUAR("Februar", 28, new String[]{"Hornung", "Schmelzmond", "Taumond", "Narrenmond", "Rebmond", "Hintester"}),
	MÄRZ("März", 31, new String[]{"Lenzing", "Lenzmond"}),
	APRIL("April", 30, new String[]{"Launing", "Ostermond"}),
	MAI("Mai", 31, new String[]{"Winnemond", "Blumenmond"}),
	JUNI("Juni", 30, new String[]{"Brachet", "Brachmond"}),
	JULI("Juli", 31, new String[]{"Heuert", "Heumond"}),
	AUGUST("August", 31, new String[]{"Ernting", "Erntemond", "Bisemond"}),
	SEPTEMBER("September", 30, new String[]{"Scheiding", "Herbstmond"}),
	OKTOBER("Oktober", 31, new String[]{"Gilbhart", "Gilbhard", "Weinmond"}),
	NOVEMBER("November", 30, new String[]{"Nebelung", "Windmond", "Wintermond"}),
	DEZEMBER("Dezember", 31, new String[]{"Julmond", "Heilmond", "Christmond", "Dustermond"});
	
	private String name;
	private int days;
	private String[] oldNames;
	
	Monate(String name, int days, String[] oldNames){
		this.name = name;
		this.days = days;
		this.oldNames = oldNames;
	}
	
	public String getName(){
		return name;
	}
	
	public int getDays(){
		return days;
	}
	
	public String[] getOldNames(){
		return oldNames;
	}
	
}
