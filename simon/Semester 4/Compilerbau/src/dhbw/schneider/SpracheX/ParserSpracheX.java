package dhbw.schneider.SpracheX;

import java.util.ArrayList;

import dhbw.schneider.SpracheX.Token.Token;

public class ParserSpracheX extends Parser{
	
	private TokenType[] elementTypes = {TokenType.NUMBER, TokenType.NAME, TokenType.FLOAT};
	
	public ParserSpracheX(ArrayList<Token> tokens) {
		super(tokens);
	}

	
	public boolean run(){
		this.startTree("Programm");
		
		ParserTree program = this.parseAndAdd(TokenType.PROGRAM);
		if(!program.isValid()) return false;			
		
		ParserTree id = this.parseAndAdd(TokenType.VARIABLE);
		if(!id.isValid()) return false;		
		
		ParserTree semicolon = this.parseAndAdd(TokenType.SEMICOLON);
		if(!semicolon.isValid()) return false;	
		
		// { decl }
		while(true){
			this.parentRemember();
			
			ParserTree decl = this.parseDecl();			
			if(!decl.isValid()){
				this.resetToParent();
				break;
			}
			
			this.addSubTree(decl, false);
		}
		
		
		return true;		
	}
	
	public ParserTree parseDecl(){
		ParserTree decl = new ParserTree("decl");
		
		ParserTree readOrPrint = this.parseOr(TokenType.READ, TokenType.PRINT);
		if(!readOrPrint.isValid()) return ParserTree.invalid();		
		decl.addChild(readOrPrint);
		
		ParserTree id = this.parse(TokenType.VARIABLE);
		if(!id.isValid()) return ParserTree.invalid();		
		decl.addChild(id);
		
		ParserTree colon = this.parse(TokenType.COLON);
		if(!colon.isValid()) return ParserTree.invalid();		
		decl.addChild(colon);
		
		ParserTree type = this.parse(TokenType.TYPE);
		if(!type.isValid()) return ParserTree.invalid();		
		decl.addChild(type);
		
		ParserTree semicolon = this.parse(TokenType.SEMICOLON);
		if(!semicolon.isValid()) return ParserTree.invalid();		
		decl.addChild(semicolon);
		
		return decl;
	}
	
	

}