package swing.aufgabe2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class FrameMitText extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public FrameMitText(String rahmentitel, int breite, int höhe, String dateiname){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		File f = new File(dateiname);
		StringBuilder text = new StringBuilder();
		
		try(BufferedReader in = new BufferedReader(new FileReader(f))){
			String line;
			
			while((line = in.readLine()) != null){
				text.append(line + System.lineSeparator());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		this.add(new JTextArea(text.toString()));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(breite, höhe);
		this.setTitle(rahmentitel);
		this.setVisible(true);
	}

}
