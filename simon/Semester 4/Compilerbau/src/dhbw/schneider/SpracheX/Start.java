package dhbw.schneider.SpracheX;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import dhbw.schneider.SpracheX.Token.Token;
import java_cup.runtime.Symbol;

public class Start {

	public static void main(String[] args) throws IOException {
		FileInputStream in = new FileInputStream(new File("txt/spracheX_example1.txt"));
		
		SpracheXLex lexer = new SpracheXLex(in);
		
		Token s;
		
		while(true){
			s = lexer.yylex();
			System.out.println(s);
			
			if(s == null || s.isEOF()) break;
		}
		
		System.out.println("- scanning done");

	}

}
