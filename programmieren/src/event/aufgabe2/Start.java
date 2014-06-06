package event.aufgabe2;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Start {

	 public static void main(String[] args) throws Exception {
		 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		 
		 JFrame frame = new JFrame("Body-Mass-Index"); 
		 
		 frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		 
		 addWeightRow(frame);
		 addSizeRow(frame);
		 addGenderRow(frame);
		 addCalculateRow(frame);
		 addBMIRow(frame);
		 addClassificationRow(frame);
		 
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.pack();
		 frame.setResizable(false);
		 frame.setVisible(true);
	 }
	 
	 private static void addWeightRow(JFrame frame){
		 JPanel panel = new JPanel(new GridLayout(1, 2));
		 
		 panel.add(new JLabel("Gewicht in kg:"));
		 panel.add(new JTextField());
		 frame.add(panel);
	 }
	 
	 private static void addSizeRow(JFrame frame){
		 JPanel panel = new JPanel(new GridLayout(1, 2));
		 
		 panel.add(new JLabel("Größe in m:"));
		 panel.add(new JTextField());
		 frame.add(panel);
	 }
	 
	 private static void addGenderRow(JFrame frame){
		 JPanel panel = new JPanel();
		 ButtonGroup group = new ButtonGroup();
		 JRadioButton radio1 = new JRadioButton("männlich");
		 JRadioButton radio2 = new JRadioButton("weiblich");
		 
		 group.add(radio1);
		 group.add(radio2);
		 panel.add(radio1);
		 panel.add(radio2);
		 frame.add(panel);
	 }
	 
	 private static void addCalculateRow(JFrame frame){
		 JButton button = new JButton("berechne");
		 
		 button.setAlignmentX(Component.CENTER_ALIGNMENT);
		 frame.add(button);
	 }
	 
	 private static void addBMIRow(JFrame frame){
		 JPanel panel = new JPanel(new GridLayout(1, 2));
		 
		 panel.add(new JLabel("BMI:"));
		 panel.add(new JTextField());
		 frame.add(panel);
	 }
	 
	 private static void addClassificationRow(JFrame frame){
		 frame.add(new JTextField());
	 }
	
}
