package swing.aufgabe3.editor;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.text.DefaultEditorKit;

public class EditMenu extends JMenu {
	
	private static final long serialVersionUID = 1L;
	public final JMenuItem undoItem = new JMenuItem("Rückgängig: nicht möglich");
	public final JMenuItem redoItem = new JMenuItem("Wiederholen: nicht möglich");
	public final JMenuItem cutItem = new JMenuItem(new DefaultEditorKit.CutAction());
	public final JMenuItem copyItem = new JMenuItem(new DefaultEditorKit.CopyAction());
	public final JMenuItem officeItem = new JMenuItem("Office-Zwischenablage");
	public final JMenuItem pasteItem = new JMenuItem(new DefaultEditorKit.PasteAction());
	public final JMenuItem pasteContentItem = new JMenuItem("Inhalte einfügen");
	public final JMenuItem pasteHyperlinkItem = new JMenuItem("Als Hyperlink einfügen");
	public final JMenuItem deleteItem = new JMenuItem("Löschen");
	public final JMenuItem selectItem = new JMenuItem("Alles markieren");
	public final JMenuItem searchItem = new JMenuItem("Suchen...");
	public final JMenuItem replaceItem = new JMenuItem("Ersetzen...");
	public final JMenuItem goToItem = new JMenuItem("Gehe zu...");
	public final JMenuItem linkItem = new JMenuItem("Verknüpfungen...");
	public final JMenuItem objectItem = new JMenuItem("Objekt");
	
	public EditMenu(ActionListener actionListener){
		super("Bearbeiten");
		
		undoItem.setEnabled(false);
		redoItem.setEnabled(false);
		
		cutItem.setText("Ausschneiden");
		copyItem.setText("Kopieren");
		pasteItem.setText("Einfügen");
		
		undoItem.addActionListener(actionListener);
		redoItem.addActionListener(actionListener);
		officeItem.addActionListener(actionListener);
		pasteContentItem.addActionListener(actionListener);
		pasteHyperlinkItem.addActionListener(actionListener);
		deleteItem.addActionListener(actionListener);
		selectItem.addActionListener(actionListener);
		searchItem.addActionListener(actionListener);
		replaceItem.addActionListener(actionListener);
		goToItem.addActionListener(actionListener);
		linkItem.addActionListener(actionListener);
		objectItem.addActionListener(actionListener);
		
		this.add(undoItem);
		this.add(redoItem);
		this.addSeparator();
		this.add(cutItem);
		this.add(copyItem);
		this.add(officeItem);
		this.addSeparator();
		this.add(pasteItem);
		this.add(pasteContentItem);
		this.add(pasteHyperlinkItem);
		this.addSeparator();
		this.add(deleteItem);
		this.add(selectItem);
		this.addSeparator();
		this.add(searchItem);
		this.add(replaceItem);
		this.add(goToItem);
		this.addSeparator();
		this.add(linkItem);
		this.add(objectItem);
	}
	
}
