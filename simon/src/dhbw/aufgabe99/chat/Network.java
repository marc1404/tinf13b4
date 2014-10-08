package dhbw.aufgabe99.chat;

import java.util.ArrayList;
import java.util.List;

public class Network {

	private List<ChatSession> chatSessions = new ArrayList<ChatSession>();

	public Network() {
		super();
	}

	public void addChat(ChatSession chatSession){
		this.getChatSessions().add(chatSession);
		chatSession.setNetwork(this);
	}
	
	public List<ChatSession> getChatSessions() {
		return chatSessions;
	}

	public void setChatSessions(List<ChatSession> chatSessions) {
		this.chatSessions = chatSessions;
	}
	
	public void commandWho(){
		String whoText = "INFO: ";
		for (ChatSession chatSession : this.getChatSessions()) {
			whoText += chatSession.getNickname() + ", ";
		}
		
		this.send(whoText);
		
	}
	
	public void commandLogout(String nickname){
		this.send("INFO: " + nickname + " logged out.");
	}

	public void send(String text) {
		this.send(text, null);
		
	}
	
	public void send(String text, String nickname) {
		if(nickname != null)
			text = nickname + " >> " + text;
		
		for (ChatSession chatSession : this.getChatSessions()) {
			chatSession.writeMessage(text);
		}
	}

	
	
	 
	
}
