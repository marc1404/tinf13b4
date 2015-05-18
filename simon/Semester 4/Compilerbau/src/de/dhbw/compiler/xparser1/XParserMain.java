/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Übungsbeispiel AS-SCanner 5
 * 
 * **********************************************
 */

package de.dhbw.compiler.xparser1;

import java.io.FileInputStream;
import java.io.PrintWriter;

import de.dhbw.compiler.jflexxscanner.JFlexXScanner;


public class XParserMain {
	
	public static void main(String[] args) throws Exception {
		
		JFlexXScanner lexer = new JFlexXScanner(new FileInputStream("txt/spracheX_example1.txt"));
		TokenReader reader = new TokenReader(lexer);
		
		XParser parser = new XParser(reader);

		
		Tree tree = parser.parseProgram();
		
		System.out.println("Hllo");


		
		PrintWriter writer = new PrintWriter("graph/digraph.dot", "UTF-8");
		writer.print(tree.toGraphvizDot());
		writer.close();
		
		System.out.println("Hllo");
		
		

	}

}
