package chat;

import java.util.ArrayList;
import java.util.List;

public class Network {

	private List<ChatSession> sessions = new ArrayList<ChatSession>();
	
	public void addChat(ChatSession chat){
		sessions.add(chat);
	}
	
	public void removeChat(ChatSession chat){
		sessions.remove(chat);
	}
	
	public void send(String message, String nickname){
		send(nickname + ">>" + message);
	}
	
	public void send(String message){
		for(ChatSession session:sessions){
			session.sendMessage(message);
		}
	}
	
	public List<ChatSession> getSessions(){
		return sessions;
	}
	
}
