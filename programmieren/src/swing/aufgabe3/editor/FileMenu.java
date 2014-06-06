package swing.aufgabe3.editor;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FileMenu extends JMenu {

	private static final long serialVersionUID = 1L;
	public final JMenuItem newItem = new JMenuItem("Neu..");
	public final JMenuItem openItem = new JMenuItem("Öffnen...");
	public final JMenuItem closeItem = new JMenuItem("Schließen");
	public final JMenuItem saveItem = new JMenuItem("Speichern");
	public final JMenuItem saveAsItem = new JMenuItem("Speichern unter...");
	public final JMenuItem saveAsWebsiteItem = new JMenuItem("Als Webseite speichern...");
	public final JMenuItem searchItem = new JMenuItem("Suchen...");
	public final JMenuItem versionItem = new JMenuItem("Versionen...");
	public final JMenuItem websitePreviewItem = new JMenuItem("Webseitenvorschau");
	public final JMenuItem seiteEinrichtenItem = new JMenuItem("Seite einrichten...");
	public final JMenuItem seitenansichtItem = new JMenuItem("Seitenansicht");
	public final JMenuItem printItem = new JMenuItem("Drucken...");
	public final JMenuItem propertiesItem = new JMenuItem("Eigenschaften");
	public final JMenuItem quitItem = new JMenuItem("Beenden");
	
	public FileMenu(ActionListener actionListener){
		super("Datei");
		
		JMenu sendToMenu = new JMenu("Senden an");
		
		sendToMenu.add(new JMenuItem("E-Mail-Empfänger"));
		sendToMenu.add(new JMenuItem("E-Mail-Empfänger (zur Überarbeitung)..."));
		sendToMenu.add(new JMenuItem("E-Mail-Empfänger (als Anlage)..."));
		sendToMenu.add(new JMenuItem("Verteilerempfänger..."));
		sendToMenu.add(new JMenuItem("Onlinebesprechungsteilnehmer"));
		sendToMenu.add(new JMenuItem("Exchange-Ordner..."));
		sendToMenu.add(new JMenuItem("Fax-Empfänger..."));
		sendToMenu.addSeparator();
		sendToMenu.add(new JMenuItem("Microsoft Powerpoint"));
		
		this.add(newItem);
		this.add(openItem);
		this.add(closeItem);
		this.addSeparator();
		this.add(saveItem);
		this.add(saveAsItem);
		this.add(saveAsWebsiteItem);
		this.add(searchItem);
		this.addSeparator();
		this.add(versionItem);
		this.addSeparator();
		this.add(websitePreviewItem);
		this.addSeparator();
		this.add(seiteEinrichtenItem);
		this.add(seitenansichtItem);
		this.add(printItem);
		this.add(sendToMenu);
		this.add(propertiesItem);
		this.addSeparator();
		this.add(quitItem);
		
		addActionListenerToItems(actionListener);
	}
	
	private void addActionListenerToItems(ActionListener actionListener){
		newItem.addActionListener(actionListener);
		openItem.addActionListener(actionListener);
		closeItem.addActionListener(actionListener);
		saveItem.addActionListener(actionListener);
		saveAsItem.addActionListener(actionListener);
		saveAsWebsiteItem.addActionListener(actionListener);
		searchItem.addActionListener(actionListener);
		versionItem.addActionListener(actionListener);
		websitePreviewItem.addActionListener(actionListener);
		seiteEinrichtenItem.addActionListener(actionListener);
		seitenansichtItem.addActionListener(actionListener);
		printItem.addActionListener(actionListener);
		propertiesItem.addActionListener(actionListener);
		quitItem.addActionListener(actionListener);
	}
	
}
