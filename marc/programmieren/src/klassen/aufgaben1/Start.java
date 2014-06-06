package klassen.aufgaben1;

public class Start {

	private static final Radio radio1 = new Radio();
	private static final Radio radio2 = new Radio(true, 7, 107.56);
	
	public static void main(String[] args){
		printRadios();
		
		radio1.leiser();
		radio2.leiser();
		printMethodNameAndRadios("leiser");
		
		radio1.lauter();
		radio1.lauter();
		radio2.lauter();
		radio2.lauter();
		printMethodNameAndRadios("lauter");
		
		radio1.aus();
		radio2.aus();
		printMethodNameAndRadios("aus");
		
		radio1.an();
		radio2.an();
		printMethodNameAndRadios("an");
		
		radio1.waehleSender(56);
		radio2.waehleSender(97.56);
		printMethodNameAndRadios("waehleSender");
	}
	
	private static void printMethodNameAndRadios(String methodName){
		System.out.println("--- " + methodName + "() ---");
		printRadios();
	}
	
	private static void printRadios(){
		System.out.println("radio1.toString() = " + radio1);
		System.out.println("radio2.toString() = " + radio2);
		System.out.println();
	}
	
}
