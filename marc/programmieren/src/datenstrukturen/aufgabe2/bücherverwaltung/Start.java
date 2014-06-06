package datenstrukturen.aufgabe2.bücherverwaltung;

import javax.swing.UIManager;

public class Start {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new VerwaltungsFrame();
	}
	
}
