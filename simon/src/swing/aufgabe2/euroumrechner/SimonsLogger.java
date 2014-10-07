package swing.aufgabe2.euroumrechner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SimonsLogger {

	private String fileName;
	private File file;
	private FileWriter fileWriter;
	private BufferedWriter buffer;
	
	private Boolean working = false;

	/**
	 * @param fileName
	 */
	public SimonsLogger(String fileName, Boolean append) {
		this.fileName = fileName;
		
		this.file = new File(this.fileName);
		try {
			this.fileWriter = new FileWriter(this.file, append);
		} catch (IOException e) {
			this.working = false;	
			System.out.println("Error while genereting filewriter for " + this.fileName);
			e.printStackTrace();
			return;
		} 
		
		this.buffer = new BufferedWriter(fileWriter);
		
		System.out.println("Created logfile at " + this.file.getAbsolutePath());
		
		this.working = true;
		
	}
	
	public boolean log(String line){
		if(!this.working) return false;
		
		try {
			this.buffer.write(line);
			this.buffer.newLine();
			this.buffer.flush();
		} catch (IOException e) {
			System.out.println("Error writing log for '" + line +  "' inside '" + this.fileName +"'");
			e.printStackTrace();
			return false;
		}			
		
		return true;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
