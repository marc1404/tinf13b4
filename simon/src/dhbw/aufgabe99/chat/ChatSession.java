package dhbw.aufgabe99.chat;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class ChatSession extends JFrame implements ActionListener  {
	public static String defaultMessageTitle;
	
	private final static int GRID_PADDING = 5;
	
	private JPanel mainPanel;
	private String nickname;
	private Network network;
	
	JButton btnNick, btnWho, btnLogoff, btnClear;
	JTextArea areaChat;
	JTextField inputChat;
	
	public ChatSession(String nickname){

		this.nickname = nickname;
		this.prepareGui();
		this.buildGui();
		this.deliverGui(true);
		
		this.setTitle("#" + nickname);
		
	}
	
	
	
	public Network getNetwork() {
		return network;
	}



	public void setNetwork(Network network) {
		this.network = network;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	private void buildGui(){
		btnNick = new JButton("Nick");
		btnWho = new JButton("Who");
		btnLogoff = new JButton("Logoff");
		btnClear = new JButton("Clear");
		
		JPanel panelButtons = new JPanel(new FlowLayout());
		panelButtons.add(btnNick);
		panelButtons.add(btnWho);
		panelButtons.add(btnLogoff);
		panelButtons.add(btnClear);
		
		btnNick.addActionListener(this);
		btnWho.addActionListener(this);
		btnLogoff.addActionListener(this);
		btnClear.addActionListener(this);
		
		
		areaChat = new JTextArea("Welcome\n");

		//areaChat.setRows(5);
		JScrollPane chatScrollPane = new JScrollPane(areaChat);
		JPanel panelChat = new JPanel(new GridLayout(1,1, GRID_PADDING, GRID_PADDING));
		panelChat.add(chatScrollPane);
		areaChat.setEditable(false);
				
		JPanel panelInput = new JPanel(new GridLayout(1,1, GRID_PADDING, GRID_PADDING));
		inputChat = new JTextField();	
		panelInput.add(inputChat);
		inputChat.addActionListener(this);
		
		this.add(panelButtons, BorderLayout.NORTH);
		this.add(chatScrollPane, BorderLayout.CENTER);
		this.add(panelInput, BorderLayout.SOUTH);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
			
		if(source.equals(this.btnNick)){
			String newNickname = this.showInput("Change your nickname", "Nickname");
			
			this.getNetwork().send(this.nickname + " changed his name to " + newNickname);
			
			this.nickname = newNickname;
			this.setTitle("#" + this.nickname);
		}
		
		if(source.equals(this.btnWho)){
			this.getNetwork().commandWho();
		}
		
		if(source.equals(this.btnLogoff)){
			this.setVisible(false);
			this.dispose();
			this.getNetwork().commandLogout(this.getNickname());
			
		}
		
		if(source.equals(this.btnClear)){
			this.areaChat.setText("");
		}
		
		if(source.equals(this.inputChat)){
			this.getNetwork().send(this.inputChat.getText(), this.getNickname());
			this.inputChat.setText("");
		}
		
		
	}
	
	public void writeInfo(String text){
		this.writeInfo("INFO: " + text);
	}
	
	public void writeMessage(String text) {
		this.areaChat.append(text +  "\n" );
		
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
		
			
		this.mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, GRID_PADDING, GRID_PADDING));
		

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
	
	public JPanel addFlowPanel(){
		JPanel newPanel = new JPanel();
		
		FlowLayout newFlow = new FlowLayout(FlowLayout.CENTER);
		newPanel.setLayout(newFlow);
		
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
