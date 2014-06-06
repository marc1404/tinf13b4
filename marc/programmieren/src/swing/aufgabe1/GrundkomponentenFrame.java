package swing.aufgabe1;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

public class GrundkomponentenFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public GrundkomponentenFrame(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		
		panel.add(new JLabel("JLabel"));
		panel.add(new JTextField("JTextField"));
		panel.add(new JPasswordField("vomsalatschrumpftderbizeps"));
		
		JButton button = new JButton("JButton");
		
		button.setToolTipText("Tooltip Text");
		panel.add(button);
		panel.add(new JToggleButton("JToggleButton"));
		panel.add(new JCheckBox("JCheckBox"));
		
		JComboBox<String> comboBox = new JComboBox<String>();
		
		comboBox.addItem("JComboBox1.Item");
		panel.add(comboBox);
		
		JPanel panel2 = new JPanel();
		JRadioButton radioButton1 = new JRadioButton("Radio-Button-1");
		JRadioButton radioButton2 = new JRadioButton("Radio-Button-2");
		JRadioButton radioButton3 = new JRadioButton("Radio-Button-3");
		ButtonGroup buttonGroup = new ButtonGroup();
		
		buttonGroup.add(radioButton1);
		buttonGroup.add(radioButton2);
		buttonGroup.add(radioButton3);
		panel2.add(radioButton1);
		panel2.add(radioButton2);
		panel2.add(radioButton3);
		
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.PAGE_START);
		this.add(panel2, BorderLayout.PAGE_END);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Einige Swing-Grundkomponenten");
		this.pack();
		this.setVisible(true);
	}
	
}
