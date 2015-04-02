package threads.aufgabe1;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Start {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		JFrame frame = new JFrame("Tanzende Schrift");
		JTextField textField = new JTextField("Wat is denn los mit dir ?!");
		
		textField.setOpaque(false);
		
		final JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 1001, Options.getSpeed());
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		
		labelTable.put(new Integer(1), new JLabel("Schnell"));
		labelTable.put(new Integer(500), new JLabel("Mittel"));
		labelTable.put(new Integer(1000), new JLabel("Langsam"));
		
		slider.setInverted(true);
		slider.setMinorTickSpacing(50);
		slider.setMajorTickSpacing(250);
		slider.setLabelTable(labelTable);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		
		slider.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e){
				Options.setSpeed(slider.getValue());
			}
		});
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = ge.getAllFonts();
		String[] fontNames = new String[fonts.length];
        
        for(int i = 0; i < fonts.length; i++){
        	fontNames[i] = fonts[i].getName();
        }
        
		final JComboBox<String> comboBox = new JComboBox<String>(fontNames);
		
		comboBox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Options.setFont((String)comboBox.getSelectedItem());
			}
		});
		
		JPanel panel = new JPanel(new BorderLayout());
		
		panel.add(textField, BorderLayout.NORTH);
		panel.add(slider, BorderLayout.CENTER);
		panel.add(comboBox, BorderLayout.SOUTH);

		frame.add(new PaintPanel(textField), BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(600, 200);
		frame.setVisible(true);
	}
	
}
