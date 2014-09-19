package dhbw.aufgabe91.jbay;

import java.util.Calendar;


public class Auktion {
	
	static double increment = 1.0;
	
	private Ware ware;
	private Gebot maxgebot = null;
	private double preis = 0.0;
	private Calendar ende;
	
	public Auktion(Ware ware, int dauer) {
		this.ware = ware;
		this.ende = Calendar.getInstance();
		this.ende.setTimeInMillis(System.currentTimeMillis() + 60000 * dauer);
	}	
	
	public boolean gebotAbgeben(Gebot g){
		
		//Gebot niedriger als Mindestpreis
		if(g.getMaxbetrag() < this.minimalGebot())
			return false;
		
		//Erster Bieter
		if(this.maxgebot == null){
			this.setMaxgebot(g);
			this.setPreis(increment);
			return true;
		}
			
		//Gleicher bieter erhöht
		if(this.gleicheBieter(g) && this.gebotHöher(g)){
			this.setMaxgebot(g);
			return true;
		}
		
		//Anderer Bieter erhöht
		if(!this.gleicheBieter(g) && this.gebotHöher(g)){
			this.setPreis(this.maxgebot.getMaxbetrag());
			this.setMaxgebot(g);			
			return true;
		}
		
		this.setPreis(g.getMaxbetrag());
		
		return false;
		
	}
	
	public boolean gleicheBieter(Gebot g){
		return g.getBieter().equals(this.maxgebot.getBieter());
	}
	
	public boolean gebotHöher(Gebot g){
		return g.getMaxbetrag() > this.getMaxgebot().getMaxbetrag();
	}
	
	public double minimalGebot(){
		return this.preis + Auktion.increment;
	}
	
	/**
	 * @return the ware
	 */
	public Ware getWare() {
		return ware;
	}
	/**
	 * @param ware the ware to set
	 */
	public void setWare(Ware ware) {
		this.ware = ware;
	}
	/**
	 * @return the maxgebot
	 */
	public Gebot getMaxgebot() {
		return maxgebot;
	}
	/**
	 * @param maxgebot the maxgebot to set
	 */
	public void setMaxgebot(Gebot maxgebot) {
		this.maxgebot = maxgebot;
	}
	/**
	 * @return the preis
	 */
	public double getPreis() {
		return preis;
	}
	/**
	 * @param preis the preis to set
	 */
	public void setPreis(double preis) {
		this.preis = preis;
	}
	/**
	 * @return the ende
	 */
	public Calendar getEnde() {
		return ende;
	}
	/**
	 * @param ende the ende to set
	 */
	public void setEnde(Calendar ende) {
		this.ende = ende;
	}
	
	
	
	
}
