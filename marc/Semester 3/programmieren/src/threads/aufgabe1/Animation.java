package threads.aufgabe1;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class Animation implements Runnable {

	private JComponent comp;
	private DancingString dancingString;
	
	public Animation(JComponent comp, String text){
		this.comp = comp;
		
		this.setText(text);
	}
	
	public void setText(String text){
		this.dancingString = new DancingString(text);
	}
	
	@Override
	public void run(){
		while(!Thread.interrupted()){
			dancingString.animate(comp.getHeight());
			
			SwingUtilities.invokeLater(new Runnable(){
				@Override
				public void run(){
					comp.repaint();
				}
			});
			
			try{
				Thread.sleep(Options.getSpeed());
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	public DancingString getDancingString(){
		return dancingString;
	}
	
}
