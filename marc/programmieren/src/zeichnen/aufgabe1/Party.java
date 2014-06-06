package zeichnen.aufgabe1;

import java.awt.Color;

public class Party {

	private String name;
	private Color color;
	private double percent;
	
	public Party(String name, Color color, double percent){
		this.name = name;
		this.color = color;
		this.percent = percent;
	}
	
	public String getName(){
		return name;
	}

	public Color getColor(){
		return color;
	}

	public double getPercent(){
		return percent;
	}
	
}
