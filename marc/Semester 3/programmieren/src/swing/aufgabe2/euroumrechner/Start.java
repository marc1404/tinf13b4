package swing.aufgabe2.euroumrechner;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Start {

	private static final double EXCHANGE_RATE = 1.95583;
	
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		final JFrame frame = new JFrame("Euroumrechner");
		final JTextField textField = new JTextField("Bitte hier Betrag zum Umrechnen eingeben!");
		JButton euroToDm = new JButton("EUR -> DM");
		JButton dmToEur = new JButton("DM -> EUR");
		JButton cancel = new JButton("Abbrechen");
		
		euroToDm.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String text = textField.getText();
				double euro = Double.parseDouble(text.split(" ")[0]);
				double dm = euro * EXCHANGE_RATE;
				
				textField.setText(dm + " DM");
			}
		});
		
		dmToEur.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String text = textField.getText();
				double dm = Double.parseDouble(text.split(" ")[0]);
				double euro = dm / EXCHANGE_RATE;
				
				textField.setText(euro + " €");
			}
		});
		
		cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		
		frame.setLayout(new BorderLayout(5, 5));
		frame.add(textField, BorderLayout.NORTH);
		frame.add(euroToDm, BorderLayout.WEST);
		frame.add(dmToEur, BorderLayout.CENTER);
		frame.add(cancel, BorderLayout.EAST);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
