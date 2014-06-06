package datenstrukturen.aufgabe2.bücherverwaltung;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VerwaltungsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private Archiv archiv;
	private JTextField autorField = new JTextField();
	private JTextField titelField = new JTextField();
	private JTextField jahrField = new JTextField();
	private JTextField verlagField = new JTextField();
	
	public VerwaltungsFrame(Archiv archiv){
		super("Bücherverwaltung");
		
		this.archiv = archiv;
		JPanel topPanel = new JPanel(new GridLayout(4, 2, 0, 3));
		
		topPanel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		topPanel.add(new JLabel("Autor"));
		topPanel.add(autorField);
		topPanel.add(new JLabel("Titel"));
		topPanel.add(titelField);
		topPanel.add(new JLabel("Jahr"));
		topPanel.add(jahrField);
		topPanel.add(new JLabel("Verlag"));
		topPanel.add(verlagField);
		
		JPanel centerPanel = new JPanel(new GridLayout(1, 3));
		JButton speichernButton = new JButton("Eintrag speichern");

		speichernButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				
			}
		});
		
		centerPanel.add(new JLabel());
		centerPanel.add(speichernButton);
		centerPanel.add(new JLabel());
		
		JPanel bottomPanel = new JPanel(new FlowLayout());
		JButton autorButton = new JButton("Autor");
		JButton titelButton = new JButton("Titel");
		JButton jahrButton = new JButton("Jahr");
		JButton verlagButton = new JButton("Verlag");
		
		bottomPanel.add(new JLabel("Ausgabe sortiert nach:"));
		bottomPanel.add(autorButton);
		bottomPanel.add(titelButton);
		bottomPanel.add(jahrButton);
		bottomPanel.add(verlagButton);
		
		this.add(topPanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
	
}
