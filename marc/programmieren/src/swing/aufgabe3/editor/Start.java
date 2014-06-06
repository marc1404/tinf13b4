package swing.aufgabe3.editor;

import javax.swing.UIManager;

public class Start {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new EditorFrame();
	}
	
}
