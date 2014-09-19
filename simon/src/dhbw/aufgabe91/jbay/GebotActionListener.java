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
		
		Auktionshaus auktionsHaus = frame.getAuktionshaus();
		Auktion auktion = auktionPanel.auktion;
		Bieter bieter = frame.getBieter();
		
		String gebotInput = frame.showInput("Wie viel möchten Sie bieten. Mindestens " +  auktion.minimalGebot() +  " Euro.");
		if(gebotInput == null) return;
		
		
		Double gebotNumeric = Double.parseDouble(gebotInput);
		
		
		
		Gebot gebot = new Gebot(gebotNumeric, bieter);
		auktionsHaus.log(gebot.logEntry(auktion));
		
		if(!auktion.isRunning()){
			frame.showAlert("Diese Auktion ist bereits vorbei");			
			return;
		}
		
		Boolean gebotAbgabe = auktion.gebotAbgeben(gebot);
		
		System.out.println("Gebot abgegeben: " + String.valueOf(gebotAbgabe));
		
		
		
		
		
		auktionsHaus.updateTerminals();
	}

}
