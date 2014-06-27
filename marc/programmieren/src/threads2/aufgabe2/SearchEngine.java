package threads2.aufgabe2;

import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SearchEngine extends Thread {

	private int maxThreads;
	private Queue<URL> urlQueue = new LinkedList<URL>();
	private List<PageLoader> pageLoaders = new ArrayList<PageLoader>();
	
	public SearchEngine(int maxThreads){
		this.maxThreads = maxThreads;
		
		try{
			List<String> lines = Files.readAllLines(new File("pages.txt").toPath(), Charset.forName("UTF-8"));
			
			for(String line:lines){
				urlQueue.add(new URL(line));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	public void run(){
		while(pageLoaders.size() > 0 || urlQueue.size() > 0){
			int active = updatePageLoaders();
			
			updateURLs(active);
		}
	}
	
	private int updatePageLoaders(){
		Collection<PageLoader> garbage = new ArrayList<PageLoader>();
		int active = 0;
		
		for(int i = 0; i < pageLoaders.size(); i++){
			PageLoader pageLoader = pageLoaders.get(i);
			
			if(pageLoader.pageLoaded()){
				URL url = pageLoader.getURL();
				String pageContent = pageLoader.getPageContent();
				String fileName = url.toString() + ".html";
				
				garbage.add(pageLoader);
				
				if(fileName.contains("://")){
					fileName = fileName.split("://")[1];
				}
				
				try{
					Files.write(new File(fileName).toPath(), pageContent.getBytes(), StandardOpenOption.CREATE);
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}else{
				active++;
			}
		}
		
		for(PageLoader pageLoader:garbage){
			pageLoaders.remove(pageLoader);
		}
		
		return active;
	}
	
	private void updateURLs(int active){
		int diff = maxThreads - active;
		
		while(diff > 0 && urlQueue.size() > 0){
			diff--;
			URL url = urlQueue.poll();
			PageLoader pageLoader = new PageLoader(url);
			
			pageLoader.start();
			pageLoaders.add(pageLoader);
		}
	}
	
}
