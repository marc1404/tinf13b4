package zeichnen.aufgabe1;

import java.util.ArrayList;
import java.util.Collection;

public class VotingResults {

	private String name;
	private int year;
	private Collection<Party> parties = new ArrayList<Party>();
	
	public VotingResults(String name, int year){
		this.name = name;
		this.year = year;
	}
	
	public void addParty(Party party){
		parties.add(party);
	}
	
	public String getName(){
		return name;
	}

	public int getYear(){
		return year;
	}
	
	public Party[] getParties(){
		return parties.toArray(new Party[parties.size()]);
	}
	
	public Party getHighestParty(){
		Party highest = null;
		
		for(Party party:parties){
			if(highest == null || party.getPercent() > highest.getPercent()){
				highest = party;
			}
		}
		
		return highest;
	}
	
}
