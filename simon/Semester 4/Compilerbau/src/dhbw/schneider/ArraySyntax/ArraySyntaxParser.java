package dhbw.schneider.ArraySyntax;

import java.util.ArrayList;

public class ArraySyntaxParser extends Parser{
	
	private TokenType[] elementTypes = {TokenType.NUMBER, TokenType.NAME, TokenType.FLOAT};
	
	public ArraySyntaxParser(ArrayList<Token> tokens) {
		super(tokens);
	}

	
	public boolean run(){
		this.startTree("Array");
		return this.parseArray();
	}
	
	public boolean parseArray(){
		if(!this.parseLSBR()) return false;
		this.addSubTree("LSBR", false);	
		
		
		if(!this.parseElement()) return false;		
		
		this.pauseRemember();

		while(true){

			if(!this.parseComma())
				break;
			
			if(!this.parseElement())
				break;				
			

			this.hardRemember();
						
		}
		this.unpauseRemember();
	
		if(!this.parseRSBR()) return false;
		this.addSubTree("RSBR", false);	

		
		return true;
	}
	
	public boolean parseLSBR(){
		return this.parse(TokenType.LSBR);
	}
	
	public boolean parseElement(){
		this.setMaybeTree("Element");
		
		boolean parsed = this.parseOr(TokenType.NUMBER, TokenType.NAME, TokenType.FLOAT, TokenType.NULL);
		
		this.releaseMaybe(parsed);
		
		
		return parsed;
	}
	
	public boolean parseRSBR(){
		return this.parse(TokenType.RSBR);		
	}
	
	public boolean parseComma(){
		return this.parse(TokenType.COMMA);		
	}
	
	

}