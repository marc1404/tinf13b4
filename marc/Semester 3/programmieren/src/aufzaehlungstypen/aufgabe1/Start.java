package aufzaehlungstypen.aufgabe1;

import java.util.Calendar;

public class Start {

	public static void main(String[] args){
		int month = Calendar.getInstance().get(Calendar.MONTH);
		Monate monat = Monate.values()[month];
		String[] oldNames = monat.getOldNames();
		StringBuilder names = new StringBuilder();
		
		for(int i = 0; i < oldNames.length; i++){
			names.append(oldNames[i]);
			
			if(i < oldNames.length - 1){
				names.append(", ");
			}
		}
		
		System.out.println("Der " + monat.getName() + " hat " + monat.getDays() + " Tage und hieß früher '" + names + "'");
	}
	
}
