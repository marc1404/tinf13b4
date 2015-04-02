import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;


public class Start {

	public static void main(String[] args){
		try(Scanner scanner = new Scanner(System.in)){
			for(;;){
				System.out.print("[Idiot Explorer v4.8.15] Bitte geben Sie eine Adresse ein: ");
				
				String line = scanner.next();
				URL url = new URL(line);
				
				sendRequest(url);
				
				if(line.equalsIgnoreCase("quit")){
					break;
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private static void sendRequest(URL url){
		String host = url.getHost();
		
		try(Socket socket = new Socket(host, 80)){
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			out.write("GET / HTTP/1.1\r\n");
			out.write("Host: " + host + "\r\n");
			out.write("Connection: close\r\n");
			out.write("Cache-Control: max-age=0\r\n");
			out.write("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n");
			out.write("User-Agent: Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.101 Safari/537.36\r\n");
			out.write("Accept-Encoding:\r\n");
			out.write("Accept-Language: de-DE,de;q=0.8,en-US;q=0.6,en;q=0.4\r\n");
			out.write("\r\n");
			out.flush();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line;
			
			while((line = in.readLine()) != null){
				System.out.println(line);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
