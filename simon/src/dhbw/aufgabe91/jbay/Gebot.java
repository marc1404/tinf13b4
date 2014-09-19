package dhbw.aufgabe91.jbay;

import java.util.Calendar;

import dhbw.lib.SCalendar;

public class Gebot {

	private double maxbetrag;
	private Bieter bieter;
	
	/**
	 * @param maxbetrag
	 * @param bieter
	 */
	public Gebot(double maxbetrag, Bieter bieter) {
		this.maxbetrag = maxbetrag;
		this.bieter = bieter;
	}	
	
	public double getMaxbetrag() {
		return maxbetrag;
	}
	
	public void setMaxbetrag(double maxbetrag) {
		this.maxbetrag = maxbetrag;
	}
	
	public Bieter getBieter() {
		return bieter;
	}
	
	public void setBieter(Bieter bieter) {
		this.bieter = bieter;
	}
	
	public String logEntry(Auktion auktion){
		String entry = "";
		entry += "[" + Calendar.getInstance().getTime().toString() + "] ";
		entry += "Gebot von " + this.bieter.getFullName() + " ";
		entry += "für " + auktion.getWare().getTitel();
		entry += ": " + String.valueOf(this.maxbetrag) + " Euro";
		
		return entry;
	}
	
	

}
