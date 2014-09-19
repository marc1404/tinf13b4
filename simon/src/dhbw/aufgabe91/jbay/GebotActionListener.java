package dhbw.aufgabe91.jbay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dhbw.lib.SFrame;

public class GebotActionListener implements ActionListener {

	private AuktionPanel auktionPanel;
	private BieterTerminal frame;

	public GebotActionListener(AuktionPanel auktionPanel, BieterTerminal frame) {
		this.auktionPanel = auktionPanel;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String gebotInput = frame.showInput("Wie viel möchten Sie bieten");
		if(gebotInput == null) return;
		
		
		Double gebotNumeric = Double.parseDouble(gebotInput);
		
		Auktionshaus auktionsHaus = frame.getAuktionshaus();
		Auktion auktion = auktionPanel.auktion;
		Bieter bieter = frame.getBieter();
		
		Gebot gebot = new Gebot(gebotNumeric, bieter);
		auktionsHaus.log(gebot.logEntry(auktion));
		
		Boolean gebotAbgabe = auktion.gebotAbgeben(gebot);
		
		System.out.println("Gebot abgegeben: " + String.valueOf(gebotAbgabe));
		
		
		
		
		
		auktionsHaus.updateTerminals();
	}

}
