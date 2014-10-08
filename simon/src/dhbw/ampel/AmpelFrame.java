package dhbw.programmierern.ampel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AmpelFrame extends JFrame {
	
	private List<AmpelLabel> ampelLabels = new ArrayList<AmpelLabel>();
	
	public AmpelFrame(){
		this.buildGui();
		this.pack();
		this.setVisible(true);
		
		
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	private void buildGui(){
		
		JPanel mainPanel = new JPanel(new FlowLayout());
		mainPanel.setBackground(Color.black);
		this.add(mainPanel);
		
		ampelLabels.add(new AmpelLabel("Grün", AmpelStaten.GRUEN));
		ampelLabels.add(new AmpelLabel("Gelb", AmpelStaten.GELB));
		ampelLabels.add(new AmpelLabel("Rot", AmpelStaten.ROT));
		
		for (AmpelLabel ampelLabel : ampelLabels) {
		
			mainPanel.add(ampelLabel);
			System.out.println("Label " + ampelLabel.getText());
		}
		
		
	}
	
	public void changeState(AmpelStaten newState){
		for (AmpelLabel ampelLabel : ampelLabels) {
			if(ampelLabel.state == newState){
				ampelLabel.setForeground(Color.white);
			}
			else
				ampelLabel.setForeground(ampelLabel.state.getColor());
		}
	}
}
