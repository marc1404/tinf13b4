import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Start {

	private static final int PORT = 80;
	private static int counter = 0;
	
	public static void main(String[] args){
		try(ServerSocket server = new ServerSocket(PORT)){
			System.out.println("Server listening on port " + PORT + "...");
			
			for(;;){
				Socket socket = server.accept();
				counter++;
				
				handleSocket(socket);
				socket.close();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		System.out.println("Stopped accepting connections.");
	}
	
	private static void handleSocket(Socket socket) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line;
		
		System.out.println("- - - START REQUEST - - -");
		
		while((line = in.readLine()) != null){
			System.out.println(line);
			
			if(line.isEmpty()){
				break;
			}
		}
		
		System.out.println("- - - END REQUEST - - -");
		System.out.println("- - - START RESPONSE - - -");
		
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		out.write("HTTP/1.1 200 OK\r\n");
		out.write("Content-Type: text/html; charset=UTF-8\r\n");
		out.write("\r\n");
		out.write("<!doctype><html><head><meta charset='utf-8'><title>Hello World!</title></head><body><h1>Hello World!</h1>");
		out.write("<h2>Sie sind der " + counter + ". Besucher.</h2>");
		out.write("</body></html>");
		out.flush();
		
		System.out.println("- - - END RESPONSE - - -");
	}
	
}
