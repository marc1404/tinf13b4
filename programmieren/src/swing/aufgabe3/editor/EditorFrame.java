package swing.aufgabe3.editor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

public class EditorFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private FileMenu fileMenu = new FileMenu(this);
	private EditMenu editMenu = new EditMenu(this);
	private JEditorPane editor = new JEditorPane();
	private File currentFile = null;
	private boolean isWebsitePreview = false;
	
	public EditorFrame(){
		super("Editor");
		
		addMenuBar();
		this.add(new JScrollPane(editor));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}
	
	private void addMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		this.setJMenuBar(menuBar);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		
		if(source == fileMenu.newItem){
			onNew();
		}else if(source == fileMenu.openItem){
			onOpen();
		}else if(source == fileMenu.saveItem){
			onSave();
		}else if(source == fileMenu.saveAsItem){
			onSaveAs();
		}else if(source == fileMenu.saveAsWebsiteItem){
			onSaveAsWebsite();
		}else if(source == fileMenu.searchItem){
			onSearch();
		}else if(source == fileMenu.websitePreviewItem){
			onWebsitePreview();
		}else if(source == fileMenu.quitItem){
			onQuit();
		}
		
		if(source == editMenu.selectItem){
			onSelect();
		}
	}
	
	private void onNew(){
		editor.setText("");
	}
	
	private void onOpen(){
		JFileChooser fc = new JFileChooser();
		
		if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
			currentFile = fc.getSelectedFile();
			Path path = currentFile.toPath();
			
			try{
				byte[] data = Files.readAllBytes(path);
				String text = new String(data);
				
				editor.setText(text);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	private void onSave(){
		if(currentFile == null){
			showSaveDialog();
		}
		
		if(currentFile != null){
			writeText(currentFile, editor.getText());
		}
	}
	
	private void onSaveAs(){
		if(showSaveDialog()){
			onSave();
		}
	}
	
	private void onSaveAsWebsite(){
		JFileChooser fc = new JFileChooser();
		
		fc.setFileFilter(new FileFilter(){
			@Override
			public boolean accept(File f){
				
				return f.getName().endsWith(".html");
			}

			@Override
			public String getDescription() {
				return ".html";
			}
		});
		
		if(fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
			File f = fc.getSelectedFile();
			
			writeText(f, editor.getText());
		}
	}
	
	private void onSearch(){
		JDialog dialog = new JDialog(this, "Suchen");
		JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
		
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.add(new JLabel("Suchen"));
		panel.add(new JTextField());
		panel.add(new JLabel("Ersetzen"));
		panel.add(new JTextField());
		panel.add(new JButton("Suchen"));
		panel.add(new JButton("Ersetzen"));
		
		dialog.add(panel);
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.pack();
		dialog.setVisible(true);
	}
	
	private void onWebsitePreview(){
		this.isWebsitePreview = !isWebsitePreview;
		
		if(isWebsitePreview){
			String text = editor.getText();
			
			editor.setContentType("text/html");
			editor.setEditable(false);
			editor.setText(text);
		}else{
			String text = editor.getText();
			
			editor.setContentType("text/plain");
			editor.setEditable(true);
			editor.setText(text);
		}
	}
	
	private void onQuit(){
		int result = JOptionPane.showConfirmDialog(this, "Möchten Sie den Editor wirklich beenden?", "Beenden", JOptionPane.YES_NO_OPTION);
		
		if(result == JOptionPane.OK_OPTION){
			this.dispose();
		}
	}
	
	private void onSelect(){
		editor.selectAll();
	}
	
	private boolean showSaveDialog(){
		JFileChooser fc = new JFileChooser();
		
		if(fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
			currentFile = fc.getSelectedFile();
			
			return true;
		}else{
			return false;
		}
	}
	
	private void writeText(File f, String text){
		try{
			Files.write(f.toPath(), text.getBytes(), StandardOpenOption.CREATE);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
