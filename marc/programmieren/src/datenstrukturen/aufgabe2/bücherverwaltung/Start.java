package datenstrukturen.aufgabe2.bücherverwaltung;

import java.io.File;

import javax.swing.UIManager;

public class Start {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		File f = new File("archiv.txt");
		Archiv archiv = new Archiv(f);
		
		new VerwaltungsFrame(archiv);
	}
	
}
