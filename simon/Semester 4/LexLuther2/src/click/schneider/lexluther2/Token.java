package click.schneider.lexluther2;

import click.schneider.lexluther2.Enum.StateType;
import click.schneider.lexluther2.Enum.TokenType;

public class Token {

	
	
	public TokenType type;
	
	public String text;
	
	public TokenValue value;
	
	public StateType state;
	
	public int pointer;	
	

	public Token(TokenType type, String text, StateType state, int pointer) {
		super();
		this.type = type;
		this.text = text;
		this.state = state;
		this.pointer = pointer;
		
		this.value = new TokenValue();
	}
	
	public Token(Token token){
		this.type = token.type;
		this.text = token.text;
		this.state = token.state;
		this.pointer = token.pointer;
		this.value = token.value;
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
		return "Token: " + this.type + " = '" + this.text + "' at index " + this.pointer;
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
	
	
	
	
	
}
