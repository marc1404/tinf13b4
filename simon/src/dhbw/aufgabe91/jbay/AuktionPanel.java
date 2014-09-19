package dhbw.aufgabe91.jbay;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dhbw.lib.SFrame;

public class AuktionPanel extends JPanel{

	public Auktion auktion;
	public BieterTerminal frame;
	
	public JLabel lblName;
	public JLabel lblPreis;
	public JLabel lblBieter;
	public JLabel lblEnde;
	public JButton btnBieten;
	
	/**
	 * @param auktion
	 */
	public AuktionPanel(Auktion auktion, BieterTerminal frame) {
		this.auktion = auktion;
		this.frame = frame;
		
		this.buildPanel();
	}
	
	private void buildPanel(){
		
		this.setLayout(new GridLayout(1,5));
		
		lblName = new JLabel("Auktion");
		lblPreis = new JLabel("Preis");
		lblBieter = new JLabel("Bieter");
		lblEnde = new JLabel("Ende");
		btnBieten = new JButton("Bieten");
		
		this.add(lblName);
		this.add(lblPreis);
		this.add(lblBieter);
		this.add(lblEnde);
		this.add(btnBieten);
		
		btnBieten.addActionListener(new GebotActionListener(this, this.frame));
		
		
		this.updatePanel();
		
	}

	
	public void updatePanel(){
		if(!auktion.isRunning()){
			this.setEnabled(false);
			return;
		}
		
		lblName.setText(auktion.getWare().getTitel());
		
		String preisText = String.valueOf(auktion.getPreis()) + " €";
		if(auktion.getMaxgebot() != null){
			preisText += " ( " + auktion.getMaxgebot().getMaxbetrag() + " geboten)"; 
		}
		
		lblPreis.setText(preisText);
		
		
		
		if(auktion.getMaxgebot() != null)
			lblBieter.setText(auktion.getMaxgebot().getBieter().getFullName());
		else
			lblBieter.setText("--");
		
		lblEnde.setText(auktion.getEnde().getTime().toString());	
		
		
		
	}
	
	public Auktion getAuktion() {
		return auktion;
	}

	public void setAuktion(Auktion auktion) {
		this.auktion = auktion;
	}

}
