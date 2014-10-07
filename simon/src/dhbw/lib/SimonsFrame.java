package dhbw.lib;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class SimonsFrame extends JFrame {
	public static String defaultMessageTitle;
	
	private final static int GRID_PADDING = 5;
	
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
		Border framePadding = BorderFactory.createEmptyBorder(GRID_PADDING,GRID_PADDING,GRID_PADDING,GRID_PADDING);
		this.mainPanel.setBorder(framePadding);
		
			
		this.mainPanel.setLayout(new GridLayout(0,1, GRID_PADDING, GRID_PADDING));
		

		this.add(this.mainPanel);
		
		
	}
		
	public void addToGui(Component toAdd){
		this.mainPanel.add(toAdd);
	}
	
	public JPanel addPanel(int rows, int cols){
		JPanel newPanel = new JPanel();
		GridLayout newGrid = new GridLayout(rows, cols, GRID_PADDING, GRID_PADDING);
		
		newPanel.setLayout(newGrid);
		
		this.addToGui(newPanel);
		
		return newPanel;
		
	}
	
	public JMenuBar createMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		
		/*
		if(createFileMenu){
			JMenu fileMenu = new JMenu();
			fileMenu.add(new JMenuItem("Oeffnen"));
			fileMenu.add(new JMenuItem("Schlieﬂen"));
			
		}
		*/
		
		this.setJMenuBar(menuBar);
		return menuBar;		
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
	
	
	public File showFileChooser(){
		JFileChooser fc = new JFileChooser();
		
		if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			File f = fc.getSelectedFile();
			return f;
		}
		
		return null;
	}
	
		
}
