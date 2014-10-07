package dhbw.aufgabe91.jbay;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;

import dhbw.lib.SimonsFrame;

public class BieterTerminal extends SimonsFrame {

	private Bieter bieter;
	private Auktionshaus auktionshaus;
	
	private JLabel timeLabel;
	private List<AuktionPanel> auktionPanels = new ArrayList<AuktionPanel>();
	
	/**
	 * @param bieter
	 * @param auktionshaus
	 */
	public BieterTerminal(Bieter bieter, Auktionshaus auktionshaus) {
		this.bieter = bieter;
		this.auktionshaus = auktionshaus;
		
		this.buildTerminal();
		
		this.deliverGui(true);
		this.setTitle(this.bieter.getFullName() + "'s Terminal");
		startTimeThread();
	}

	private void buildTerminal(){
		timeLabel = new JLabel("Time");
		
		this.addToGui(timeLabel);
		
		for (Auktion auktion : auktionshaus.getAuktionen()) {
			AuktionPanel auktionPanel = new AuktionPanel(auktion, this);
			this.addToGui(auktionPanel);
			auktionPanels.add(auktionPanel);
		}
		
		this.updateTerminal();
	}
	
	public void updateTerminal(){
		Calendar currentTime = java.util.Calendar.getInstance();
		
		for (AuktionPanel auktionPanel : auktionPanels) {
			auktionPanel.updatePanel();
		}
		
		timeLabel.setText(currentTime.getTime().toString());
	}
	
	/**
	 * @return the bieter
	 */
	public Bieter getBieter() {
		return bieter;
	}

	/**
	 * @param bieter the bieter to set
	 */
	public void setBieter(Bieter bieter) {
		this.bieter = bieter;
	}

	/**
	 * @return the auktionshaus
	 */
	public Auktionshaus getAuktionshaus() {
		return auktionshaus;
	}

	/**
	 * @param auktionshaus the auktionshaus to set
	 */
	public void setAuktionshaus(Auktionshaus auktionshaus) {
		this.auktionshaus = auktionshaus;
	}
	
	private void startTimeThread(){
		Runnable task = new Runnable(){
			@Override
			public void run(){
				while(!Thread.interrupted()){
					updateTerminal();
					
					try{
						Thread.sleep(1000);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}
		};
		
		new Thread(task).start();
	}
	
	
	
	
	


}
