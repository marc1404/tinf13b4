package remote.aufgabe2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ChatClient extends UnicastRemoteObject implements ChatClientInterface {

	private static final long serialVersionUID = 1L;
	private static ChatServerInterface server;
	private static ChatClientInterface client;
	private static JTextArea chatArea;
	
	public static void main(String[] args) throws Exception {
		String url = "//localhost/chatserver";
		server = (ChatServerInterface)Naming.lookup(url);
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		final JFrame frame = new JFrame("Chat");
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		JPanel innerBottomPanel = new JPanel();
		JPanel fontPanel = new JPanel();
		final JTextField nameField = new JTextField(16);
		final JButton exitButton = new JButton("Exit");
		chatArea = new JTextArea(16, 64);
		final JTextField messageField = new JTextField(32);
		final JComboBox<String> fontBox = new JComboBox<String>(getFonts());
		final JButton colorButton = new JButton("Color");
		
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
		fontPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		exitButton.setEnabled(false);
		chatArea.setEditable(false);
		messageField.setEnabled(false);
		
		nameField.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					String name = nameField.getText();
					
					if(name.length() >= 3){
						try{
							client = new ChatClient(name);
							
							server.register(client);
							exitButton.setEnabled(true);
							messageField.setEnabled(true);
							messageField.grabFocus();
						}catch(Exception ex){
							ex.printStackTrace();
						}
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e){}
			@Override
			public void keyTyped(KeyEvent e){}
		});
		
		exitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				int result = JOptionPane.showConfirmDialog(frame, "Do you really want to exit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if(result == JOptionPane.YES_OPTION){
					try{
						server.unregister(client);
						exitButton.setEnabled(false);
						messageField.setEnabled(false);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}
		});
		
		messageField.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					String message = messageField.getText();
					
					if(message.length() > 0){
						try{
							server.post(client.getUser(), message);
							messageField.setText("");
						}catch(Exception ex){
							ex.printStackTrace();
						}
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e){}
			@Override
			public void keyTyped(KeyEvent e){}
		});
		
		fontBox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				chatArea.setFont(new Font((String)fontBox.getSelectedItem(), Font.PLAIN, 17));
			}
		});
		
		colorButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Color color = JColorChooser.showDialog(frame, "Color", Color.BLACK);
				
				chatArea.setForeground(color);
				colorButton.setForeground(color);
			}
		});
		
		topPanel.add(new JLabel("Name: "));
		topPanel.add(nameField);
		topPanel.add(exitButton);
		innerBottomPanel.add(new JLabel("Eingabe: "));
		innerBottomPanel.add(messageField);
		fontPanel.add(fontBox);
		fontPanel.add(colorButton);
		bottomPanel.add(innerBottomPanel);
		bottomPanel.add(fontPanel);
		
		frame.add(topPanel, BorderLayout.NORTH);
		frame.add(chatArea, BorderLayout.CENTER);
		frame.add(bottomPanel, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private static String[] getFonts(){
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font[] fonts = env.getAllFonts();
		String[] fontNames = new String[fonts.length];
		
		for(int i = 0; i < fonts.length; i++){
			fontNames[i] = fonts[i].getName();
		}
				
		return fontNames;
	}
	
	private String name;
	
	protected ChatClient(String name) throws RemoteException {
		super();
		
		this.name = name;
	}
	
	@Override
	public void message(String message) throws RemoteException {
		appendMessage(message);
	}

	@Override
	public void message(String user, String message) throws RemoteException {
		appendMessage(user + ": " + message);
	}

	@Override
	public String getUser() throws RemoteException {
		return name;
	}
	
	private void appendMessage(String message){
		chatArea.setText(chatArea.getText() + message + System.lineSeparator());
	}

}
