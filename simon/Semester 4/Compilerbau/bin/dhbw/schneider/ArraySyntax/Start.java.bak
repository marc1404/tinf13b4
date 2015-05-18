package dhbw.schneider.ArraySyntax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import java_cup.runtime.Symbol;

public class Start {

	public static void main(String[] args) throws IOException {
		FileInputStream in = new FileInputStream(new File("txt/testAS1.txt"));
		
		ArraySyntaxLex lexer = new ArraySyntaxLex(in);
		
		ArrayList<Token> tokens = new ArrayList<Token>();
		
		Token s;
		
		while(true){
			s = lexer.yylex();
			System.out.println(s);
			
			tokens.add(s);
			
			if(s == null || s.isEOF()) break;
		}
		
		System.out.println("- scanning done");
		
		
		ArraySyntaxParser parser = new ArraySyntaxParser(tokens);		
		boolean parsed = parser.run();		
		System.out.println("Parsed " + parsed);

		System.out.println(parser);
		
		System.out.println(parser.tree.toDiGraph());

	}

}
