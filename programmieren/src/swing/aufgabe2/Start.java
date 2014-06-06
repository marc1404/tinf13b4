package swing.aufgabe2;

import javax.swing.JOptionPane;

public class Start {

	public static void main(String[] args){
		String rahmentitel = JOptionPane.showInputDialog(null, "Bitte geben Sie den Rahmentitel ein", "Rahmentitel", JOptionPane.QUESTION_MESSAGE);
		int breite = Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte geben Sie die Breite ein", "Breite", JOptionPane.QUESTION_MESSAGE));
		int höhe = Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte geben Sie die Höhe ein", "Höhe", JOptionPane.QUESTION_MESSAGE));
		String dateiname = JOptionPane.showInputDialog(null, "Bitte geben Sie den Dateinamen ein", "Dateiname", JOptionPane.QUESTION_MESSAGE);
		
		new FrameMitText(rahmentitel, breite, höhe, dateiname);
	}
	
}
