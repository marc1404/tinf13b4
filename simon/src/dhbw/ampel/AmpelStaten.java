package dhbw.programmierern.ampel;

import java.awt.Color;

public enum AmpelStaten {
	GRUEN("Grün", 1000, Color.green),
	GELB("Gelb", 500, Color.yellow),
	ROT("Rot", 3000, Color.red);
	



	String title;
	int duration;
	Color color;
	
	
	private AmpelStaten(String title, int duration, Color color) {
		this.title = title;
		this.duration = duration;
		this.color = color;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public AmpelStaten getNext(){
		if(this == GRUEN)
			return GELB;
		if(this == GELB)
			return ROT;
		if(this == ROT)
			return GRUEN;
		
		System.out.println("FAIL");
		
		return null;
	}
	
	
}
