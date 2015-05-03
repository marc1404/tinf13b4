package click.schneider.lexluther2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		String fileName = "C:\\Users\\Simon\\Studium\\compilerbau_1.code";
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName), Charset.forName("UTF-8")));
				
		
		String input = "[123,12.05,asd,asd,asd \"hal\\\"lo\"]";
		
	
		Scanner lexer = new Scanner(input);	

	}

}
