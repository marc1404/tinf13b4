package threads2.aufgabe2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class PageLoader extends Thread {

	private URL url;
	private String pageContent;
	
	public PageLoader(URL url){
		this.url = url;
	}
	
	@Override
	public void run(){
		StringBuilder buffer = new StringBuilder();
		
		try{
			URLConnection conn = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			
			while((line = in.readLine()) != null){
				buffer.append(line).append(System.lineSeparator());
			}
			
			in.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		pageContent = buffer.toString();
	}
	
	public URL getURL(){
		return url;
	}
	
	public boolean pageLoaded(){
		return pageContent != null;
	}
	
	public String getPageContent(){
		return pageContent;
	}
	
}
