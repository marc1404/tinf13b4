package io.aufgabe5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextFile {

	private final File file;
	private List<String> lines = new ArrayList<String>();
	
	public TextFile(File f){
		this.file = f;
	}
	
	public TextFile(String pathname){
		this.file = new File(pathname);
	}
	
	public void read(){
		lines.clear();
		
		try(BufferedReader in = new BufferedReader(new FileReader(file))){
			while(in.ready()){
				String line = in.readLine();
				
				lines.add(line);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void write(){
		try(BufferedWriter out = new BufferedWriter(new FileWriter(file))){
			for(String line:lines){
				out.write(line);
				out.newLine();
			}
			
			out.flush();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public int availableLines(){
		return lines.size();
	}
	
	public String[] getLines(){
		return lines.toArray(new String[lines.size()]);
	}
	
	public String getLine(int i){
		return lines.get(i);
	}
	
	public void setLine(int i, String s){
		lines.set(i, s);
	}
	
	public void replaceAll(String regexp, String ersatz){
		StringBuilder text = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		
		for(String line:lines){
			text.append(line);
			text.append(newLine);
		}
		
		String result = text.toString().replaceAll(regexp, ersatz);
		lines = Arrays.asList(result.split(newLine));
	}
	
}
