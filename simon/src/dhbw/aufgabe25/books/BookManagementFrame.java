package dhbw.aufgabe25.books;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Savepoint;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BookManagementFrame extends dhbw.lib.SFrame {

	public BookManagementFrame(){
		super();
		
		this.buildGui();
		
		this.deliverGui(false);
		
	}
	
	private void buildGui(){
		
		JPanel gridPanel = new JPanel(new GridLayout(0, 2, 10, 10));
		
		JLabel labelAutor = new JLabel("Author");
		final JTextArea textAutor = new JTextArea("");
		
		JLabel labelTitle = new JLabel("Titel");
		final JTextArea textTitle = new JTextArea("");
		
		JLabel labelYear = new JLabel("Jahr");
		final JTextArea textYear = new JTextArea("");
		
		JLabel labelPublisher = new JLabel("Verlag");
		final JTextArea textPublisher = new JTextArea("");
		
		gridPanel.add(labelAutor);
		gridPanel.add(textAutor);
		gridPanel.add(labelTitle);
		gridPanel.add(textTitle);
		gridPanel.add(labelYear);
		gridPanel.add(textYear);
		gridPanel.add(labelPublisher);
		gridPanel.add(textPublisher);
		
		JPanel middlePanel = new JPanel();
		JButton buttonSave = new JButton("Eintrag speichern");
		middlePanel.add(buttonSave);
		middlePanel.setBounds(0, 0, 0, 15);
		
		JPanel bottomPanel = new JPanel();
		
		JLabel sortText = new JLabel("Ausgabe sortiert nach:");
		JButton buttonSortAuthor = new JButton("Autor");
		JButton buttonSortTitle = new JButton("Titel");
		JButton buttonSortYear = new JButton("Jahr");
		JButton buttonSortPublisher = new JButton("Verlag");
		
		bottomPanel.add(sortText);
		bottomPanel.add(buttonSortAuthor);
		bottomPanel.add(buttonSortTitle);
		bottomPanel.add(buttonSortYear);
		bottomPanel.add(buttonSortPublisher);
		
		buttonSave.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				saveBook(textAutor.getText(), textTitle.getText(), textYear.getText(), textPublisher.getText());
			}
		});
		
		super.addToGui(gridPanel);
		super.addToGui(middlePanel);
		super.addToGui(bottomPanel);
	}
	
	public void saveBook(String author, String title, String year, String publisher){
		System.out.println("Save " + author + ", " + title + " " + year + " " + publisher);
		
	}
	
	
	
	
	
	
	
}
