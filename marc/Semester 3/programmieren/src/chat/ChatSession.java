package chat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatSession implements ActionListener {
	
	private String nickname;
	private Network network;
	private JFrame frame;
	private JTextArea chatArea;
	private JTextField chatField;
	private JButton nickButton;
	private JButton whoButton;
	private JButton logoffButton;
	private JButton clearButton;
	
	public ChatSession(String nickname, Network network){
		this.nickname = nickname;
		this.network = network;
		this.frame = new JFrame("#" + nickname);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel btnPanel = new JPanel(new FlowLayout());
		
		this.nickButton = new JButton("Nick");
		this.whoButton = new JButton("Who");
		this.logoffButton = new JButton("Logoff");
		this.clearButton = new JButton("Clear");
		
		this.chatArea = new JTextArea(10, 30);
		this.chatField = new JTextField();
		
		chatArea.setEditable(false);
		chatArea.setAutoscrolls(true);
		
		chatField.addActionListener(this);
		
		btnPanel.add(nickButton);
		btnPanel.add(whoButton);
		btnPanel.add(logoffButton);
		btnPanel.add(clearButton);
		
		mainPanel.add(btnPanel, BorderLayout.NORTH);
		mainPanel.add(chatArea, BorderLayout.CENTER);
		mainPanel.add(chatField, BorderLayout.SOUTH);
		
		frame.add(mainPanel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		nickButton.addActionListener(this);
		whoButton.addActionListener(this);
		logoffButton.addActionListener(this);
		clearButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		
		if(source == nickButton){
			String newNickname = JOptionPane.showInputDialog(frame, "Neuer Nickname", "Nickname ändern", JOptionPane.QUESTION_MESSAGE);
			
			if(newNickname != null){
				frame.setTitle("#" + newNickname);
				network.send("INFO: " + nickname + " HAS CHANGED HIS NICK TO " + newNickname);
				
				nickname = newNickname;
			}
		}else if(source == whoButton){
			String online = "INFO: ";
			
			for(ChatSession session:network.getSessions()){
				online += "#" + session.getNickname() + ", ";
			}
			
			sendMessage(online);
		}else if(source == logoffButton){
			frame.setVisible(false);
			frame.dispose();
			network.removeChat(this);
			network.send("INFO: " + nickname + " HAS LOGGED OFF");
		}else if(source == clearButton){
			chatArea.setText("");
		}else if(source == chatField){
			String message = chatField.getText();
			
			chatField.setText("");
			network.send(message, nickname);
		}
	}
	
	public void sendMessage(String message){
		chatArea.setText(chatArea.getText() + System.lineSeparator() + message);
	}
	
	public String getNickname(){
		return nickname;
	}
	
}
