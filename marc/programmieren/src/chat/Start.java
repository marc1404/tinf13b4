package chat;

public class Start {

	public static void main(String[] args){
		Network network = new Network();
		
		network.addChat(new ChatSession("Tick", network));
		network.addChat(new ChatSession("Trick", network));
		network.addChat(new ChatSession("Track", network));
	}

}
