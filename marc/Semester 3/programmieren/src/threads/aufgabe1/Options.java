package threads.aufgabe1;

public class Options {

	private static int speed = 500;
	private static String font = "Helvetica";
	
	public static void setSpeed(int speed){
		Options.speed = speed;
	}
	
	public static int getSpeed(){
		return speed;
	}
	
	public static void setFont(String font){
		Options.font = font;
	}
	
	public static String getFont(){
		return font;
	}
	
}
