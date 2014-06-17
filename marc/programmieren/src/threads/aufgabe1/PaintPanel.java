package threads.aufgabe1;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PaintPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Animation animation;
	
	public PaintPanel(final JTextField textField){
		this.animation = new Animation(this, textField.getText());
		
		this.setDoubleBuffered(true);
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
	
		executor.submit(animation);
		
		textField.getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void changedUpdate(DocumentEvent e){
				update();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e){
				update();
			}
			
			@Override
			public void removeUpdate(DocumentEvent e){
				update();
			}
			
			private void update(){
				animation.setText(textField.getText());
			}
		});
	}
	
	@Override
	public void paint(Graphics g){
		int fontSize = this.getHeight() / 3;
		
		g.setFont(new Font(Options.getFont(), Font.BOLD, fontSize));
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		DancingString dancingString = animation.getDancingString();
		DancingChar[] chars = dancingString.getDancingChars();
		FontMetrics fontMetrics = g.getFontMetrics();
		int xOffset = 10;
		
		for(int i = 0; i < chars.length; i++){
			DancingChar dc = chars[i];
			char c = dc.getChar();
			
			g.setColor(dc.getColor());
			g.drawString("" + c, xOffset + 5, this.getHeight() / 2 + fontSize / 2 + dc.getOffset());
			
			xOffset += fontMetrics.charWidth(c);
		}
	}
	
}
