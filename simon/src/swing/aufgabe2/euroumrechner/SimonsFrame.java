package swing.aufgabe2.euroumrechner;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class SimonsFrame extends JFrame {
	public static String defaultMessageTitle;
	
	private JPanel mainPanel;
	
	
	public SimonsFrame(){
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
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void showAlert(String message){
		this.showAlert(message, defaultMessageTitle);
	}
	
	public void showAlert(String message, String title){
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public String showInput(String message){
		return this.showInput(message, defaultMessageTitle);
	}
	
	public String showInput(String message, String title){
		try{
			return JOptionPane.showInputDialog(this, message);
		} catch(Exception e){
			return null;
		}
	}
	
	
}
