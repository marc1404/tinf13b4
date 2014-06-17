package threads.aufgabe1;

public class DancingString {

	private DancingChar[] chars;
	
	public DancingString(String s){
		this.chars = new DancingChar[s.length()];
		
		for(int i = 0; i < chars.length; i++){
			this.chars[i] = new DancingChar(s.charAt(i));
		}
	}
	
	public void animate(int height){
		for(DancingChar dc:chars){
			dc.animate(height);
		}
	}
	
	public DancingChar[] getDancingChars(){
		return chars;
	}
	
}
