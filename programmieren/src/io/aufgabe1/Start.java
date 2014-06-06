package io.aufgabe1;

import java.io.File;

public class Start {

	public static void main(String[] args) throws Exception {
		File dir = new File("myDir");
		
		dir.mkdir();
		dir.deleteOnExit();
		createFileAndDeleteOnExit("myDir/foo1");
		createFileAndDeleteOnExit("myDir/foo2");
		createFileAndDeleteOnExit("myDir/foo3");
		
		System.out.println(dir.getAbsolutePath());
		
		for(String file:dir.list()){
			System.out.println(file);
		}
	}
	
	private static void createFileAndDeleteOnExit(String fileName) throws Exception {
		File f = new File(fileName);
		
		f.createNewFile();
		f.deleteOnExit();
	}
	
}
