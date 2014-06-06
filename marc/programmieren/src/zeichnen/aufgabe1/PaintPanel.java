package zeichnen.aufgabe1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private VotingResults results;
	private Party highest;
	private int width;
	private int height;
	
	public PaintPanel(VotingResults results){
		this.results = results;
		this.highest = results.getHighestParty();
		
		this.setDoubleBuffered(true);
	}
	
	@Override
	public void paintComponent(Graphics g){
		this.width = this.getWidth();
		this.height = this.getHeight();
		
		paintBackground(g);
		paintBackgroundLines(g);
		paintTitle(g);
		paintParties(g);
	}
	
	private void paintBackground(Graphics g){
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, width, height);
	}
	
	private void paintBackgroundLines(Graphics g){
		int lines = (int)Math.floor(height / 50d) - 1;
		
		g.setColor(Color.GRAY);
		
		for(int i = 0; i < lines; i++){
			int y = height - (i + 1) * 50;
			
			g.drawLine(0, y, width, y);
		}
	}
	
	private void paintTitle(Graphics g){
		g.setColor(Color.BLUE);
		g.drawString(results.getName() + " " + results.getYear(), 10, 20);
	}
	
	private void paintParties(Graphics g){
		int backgroundX = 5;
		int backgroundY = height - 45;
		int backgroundWidth = width - 10;
		int backgroundHeight = 45;
		
		g.setColor(Color.GRAY);
		g.fillRect(backgroundX, backgroundY, backgroundWidth, backgroundHeight);
		
		Party[] parties = results.getParties();
		int partyWidth = backgroundWidth / 2 / parties.length;
		
		if(partyWidth > 100){
			partyWidth = 100;
		}else if(partyWidth < 60){
			partyWidth = 60;
		}
		
		int marginX = (backgroundWidth - (partyWidth * parties.length)) / (parties.length + 1);
		
		for(int i = 0; i < parties.length; i++){
			int x = backgroundX + marginX + (partyWidth + marginX) * i;
			int y = backgroundY + 5;
			int height = backgroundHeight - 10;
			
			g.setColor(Color.WHITE);
			g.fillRect(x, y, partyWidth, height);
			
			Party party = parties[i];
			
			g.setColor(party.getColor());
			g.fillRect(x + 1, y + 1, partyWidth - 2, height - 2);
			
			double percent = party.getPercent() / highest.getPercent();
			int barHeight = (int)Math.floor((this.height - 100) * percent);
			
			g.fillRect(x, this.height - 50 - barHeight, partyWidth, barHeight);
			
			g.setColor(Color.WHITE);
			g.drawString(party.getName(), x + 5, y + 15);
			g.drawString("" + party.getPercent(), x + 5, y + 30);
		}
	}
	
}
