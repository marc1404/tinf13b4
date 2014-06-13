package dhbw.lib;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class SFrame extends JFrame {
	private JPanel mainPanel;
	
	public SFrame(){
		System.out.println("SFRAME: prepare GUI");
		this.prepareGui();
		
	}
	
	public void prepareGui(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}				
		
		this.mainPanel = new JPanel();
		this.mainPanel.setBorder(new EmptyBorder(10,10,10,10));
		
		this.mainPanel.setLayout(new GridLayout(0,1));
		
		this.add(this.mainPanel);
		
		
	}
	
	public void addToGui(Component toAdd){
		this.mainPanel.add(toAdd);
	}
	
	public void deliverGui(Boolean resizable){
		this.setSize(500, 300);
		this.setResizable(resizable);
		
		//this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
}
