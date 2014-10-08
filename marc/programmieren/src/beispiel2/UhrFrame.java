package threads.beispiel2;

import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class UhrFrame {

	private JLabel label;
	
	public UhrFrame(){
		JFrame frame = new JFrame("Uhr");
		this.label = new JLabel();
		
		updateTime();
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void updateTime(){
		label.setText(new Date().toString());
	}
	
}
