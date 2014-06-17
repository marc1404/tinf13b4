package threads.aufgabe1;

import java.awt.Color;
import java.util.Random;

public class DancingChar {

	private Random rand = new Random();
	private char c;
	private int offset = 0;
	private Color color;
	
	public DancingChar(char c){
		this.c = c;
	}
	
	public void animate(int height){
		int halfOffset = height / 4;
		this.offset = -halfOffset + rand.nextInt(halfOffset + 1);
		this.color = getRandomColor();
	}
	
	public char getChar(){
		return c;
	}
	
	public int getOffset(){
		return offset;
	}
	
	public Color getColor(){
		return color;
	}
	
	private Color getRandomColor(){
		float hue = rand.nextFloat();
		float saturation = 1;
		float brightness = 1;
		
		return Color.getHSBColor(hue, saturation, brightness);
	}
	
}
