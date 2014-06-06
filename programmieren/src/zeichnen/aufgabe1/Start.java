package zeichnen.aufgabe1;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Start {

	public static void main(String[] args){
		VotingResults results = new VotingResults("Bundestagswahl", 2005);
		
		results.addParty(new Party("SPD", Color.RED, 33.8));
		results.addParty(new Party("Union", Color.BLACK, 35.7));
		results.addParty(new Party("Grüne", Color.GREEN, 8.4));
		results.addParty(new Party("FDP", Color.YELLOW, 10.4));
		results.addParty(new Party("LINKE", Color.MAGENTA, 7.7));
		results.addParty(new Party("ANDERE", Color.DARK_GRAY, 4.0));
		
		JFrame frame = new JFrame("Ergebnis einer Wahl");
		PaintPanel panel = new PaintPanel(results);
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);
		frame.setMinimumSize(new Dimension(400, 200));
		frame.setVisible(true);
	}
	
}
