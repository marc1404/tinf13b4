package dhbw.aufgabe91.jbay;

import java.util.ArrayList;
import java.util.List;

import dhbw.lib.SLogger;

public class Auktionshaus {
		
	private List<Auktion> auktionen = new ArrayList<Auktion>();
	private List<BieterTerminal> bieterTerminals = new ArrayList<BieterTerminal>();

	private SLogger logger = new SLogger("logfile.txt", true);
	
	
	public Auktionshaus(){
		
	}
	
	public void addAuktion(Auktion a){
		this.auktionen.add(a);
	}
	

	public List<Auktion> getAuktionen() {
		return auktionen;
	}

	public void setAuktionen(List<Auktion> auktionen) {
		this.auktionen = auktionen;
	}
	
	public void registerTerminal(BieterTerminal bieterTerminal){
		this.bieterTerminals.add(bieterTerminal);
	}
	
	public void unregisterTerminal(BieterTerminal bieterTerminal){
		this.bieterTerminals.remove(bieterTerminal);
	}
	
	public List<BieterTerminal> getTerminals(){
		return this.bieterTerminals;
	}
	
	public Boolean log(String line){
		return this.logger.log(line);
	}
	
	public void updateTerminals(){
		for (BieterTerminal bieterTerminal : bieterTerminals) {
			bieterTerminal.updateTerminal();
		}
	}
	
	
	
	
	
}
