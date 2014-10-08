package dhbw.programmierern.ampel;

import javax.swing.JLabel;

public class AmpelLabel extends JLabel {

	public AmpelStaten state;
	
	public AmpelLabel(String title, AmpelStaten state) {
		
		super(title);
		
		this.state = state;
		this.setForeground(state.getColor());
		this.setVisible(true);
	}
	
	
	
}
