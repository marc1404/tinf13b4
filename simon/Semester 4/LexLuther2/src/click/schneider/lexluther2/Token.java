package click.schneider.lexluther2;

import java.util.ArrayList;

import click.schneider.lexluther2.Enum.StateType;
import click.schneider.lexluther2.Enum.TokenType;

public class Token {

	
	public TokenType type;
	
	public String text;
	
	public TokenValue value;
	
	public StateType state;
	
	public int pointer;	
	
	public int startIndex;
	
	public SymbolTable symbolTable;
	
	public Symbol symbol;
	

	public Token(TokenType type, String text, StateType state, int pointer) {
		super();
		this.type = type;
		this.text = text;
		this.state = state;
		this.pointer = pointer;
		
		this.value = new TokenValue();
		this.symbolTable = this.getSymbolTable();
	}
	
	public SymbolTable getSymbolTable(){
		return SymbolTable.getBase();
	}
	
	public Token(Token token){			
		this(token.type, token.text, token.state, token.pointer);
	}
	
	
	
	public static Token createEmptyToken(){
		return new Token(TokenType.EMPTY, "", StateType.EMPTY, -1);
	}


	public boolean isEmpty(){
		
		return this.type == TokenType.EMPTY;
		
	}
	
	public boolean is(TokenType compare){
		return this.type == compare;
	}
	
	public String toString(){
		return "Token: " + this.type + " = '" + this.text + "' \t| id: " + this.getSymbolId()  + " at index " + this.startIndex;
	}
	
	public Object clone(){
        try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        
        return null;
    }
	
	public void readIn(LexCharacter character){
		
	}
	
	public void outputTo(ArrayList<Token> tokens){
		System.out.println("Output token: " + this.type);
		tokens.add(this);
		
		this.startIndex = this.pointer - this.text.length() + 1;
		
		Symbol symbol = this.symbolTable.addSymbol(this);
		this.symbol = symbol;		
	}
	
	public int getSymbolId(){
		if(this.symbol == null) return -1;
		
		return this.symbol.id;
		
	}
	
	
	
	
}
