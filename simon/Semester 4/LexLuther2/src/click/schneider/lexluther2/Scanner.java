package click.schneider.lexluther2;

import java.util.ArrayList;

import click.schneider.lexluther2.Enum.CharacterType;
import click.schneider.lexluther2.Enum.StateType;
import click.schneider.lexluther2.Enum.TokenType;

public class Scanner {

	public ArrayList<Token> tokens = new ArrayList<Token>();
	
	public Token token;
	
	private Token tokenSafe;
	
	public String input;
	
	public State state;
	
	public char[] inputChars;
	
	public int pointer = -1;
	
	public boolean endReached = false;
	
	public LexCharacter currentCharacter;

	public String currentRead;
	
	public Scanner(String input) {
		super();
		this.input = input;
		this.inputChars = input.toCharArray();
		
		
		this.runScan();
	}
	
	public void runScan(){
		
		this.state = State.createEmpty();	
		this.token = Token.createEmptyToken();
		
		while(this.token != null){			
			this.token = this.nextToken();
			
			if(this.token == null) break;
			else 			System.out.println("======== " + this.token.type);

			
			this.tokens.add(this.token);
		}
		
		System.out.println("===");
		System.out.println("IN: " + this.input);
		System.out.println("OUT: ");
		
		for(Token token : this.tokens){
			System.out.println(token);
		}
		
	}
	

	public Token nextToken(){
		if(this.endReached) return null;
		
		while(true){
			LexCharacter character = this.nextCharacter();		
		
			if(character.isEmpty()) {
				this.endReached = true;
				return this.tokenSafe;
			}
			
			StateType oldState = this.state.type;
			
			Token returnToken = Token.createEmptyToken();
			
			TokenType nextTokenType = TokenType.EMPTY;
			boolean outputToken = false;
			
			if(state.isAny() && character.hasType(CharacterType.WS) ){
				this.changeState(StateType.WS);
			}
			else if(state.isAny() && character.hasType(CharacterType.RSBR)){
				this.changeState(StateType.RSBR);
				nextTokenType = TokenType.RSBR;
				outputToken = true;
			}
			else if(state.isAny() && character.hasType(CharacterType.LSBR)){
				this.changeState(StateType.LSBR);
				nextTokenType = TokenType.LSBR;
				outputToken = true;
			}
			else if(state.isAny() && character.hasType(CharacterType.COMMA)){
				this.changeState(StateType.COMMA);
				nextTokenType = TokenType.COMMA;
				outputToken = true;
			} else if(state.is("LSBR,RSBR,COMMA") && character.hasType(CharacterType.DIGIT) ){
				this.changeState(StateType.NUMBER);
				nextTokenType = TokenType.NUMBER;
				outputToken = true;
			} else if(state.is("NUMBER") && character.hasType(CharacterType.DIGIT) ){
				this.changeState(StateType.NUMBER);
				nextTokenType = TokenType.NUMBER;
			} else if(state.is("LSBR,RSBR,COMMA") && (character.hasType(CharacterType.ALPHA)) ){
				this.changeState(StateType.NAME);
				nextTokenType = TokenType.NAME;
				outputToken = true;
			} else if(state.is("NAME,NUMBER") && character.hasType(CharacterType.ALPHANUMERIC) ){
				this.changeState(StateType.NAME);
				nextTokenType = TokenType.NAME;
			} 
			else if(state.is("DECIMAL") && character.hasType(CharacterType.ALPHA)){
				this.changeState(StateType.NAME);
				nextTokenType = TokenType.NAME;
				outputToken = true;
			}
			else if(state.is("FLOAT") && character.hasType(CharacterType.ALPHA) ){
				this.changeState(StateType.NAME);
				nextTokenType = TokenType.NAME;
				outputToken = true;
			}
			else if(state.is("NUMBER") && character.hasType(CharacterType.DOT)){
				this.changeState(StateType.DOT);
				nextTokenType = TokenType.FLOAT;
			}
			
			else if(state.is("NUMBER") && character.hasType(CharacterType.ALPHA)){
				this.changeState(StateType.NAME);
				nextTokenType = TokenType.NAME;
			}
			else if(state.is(StateType.DOT) && character.hasType(CharacterType.DIGIT)){
				this.changeState(StateType.DECIMAL);
				nextTokenType = TokenType.FLOAT;
			}
			else if(state.is(StateType.DECIMAL) && character.hasType(CharacterType.DIGIT)){
				this.changeState(StateType.DECIMAL);
				nextTokenType = TokenType.FLOAT;
			}
			else if(state.is(StateType.INVALID)){
				nextTokenType = TokenType.INVALID;
			}
			else{
				this.changeState(StateType.INVALID);
				nextTokenType = TokenType.INVALID;
				outputToken = true;
			}
			
						
			if(outputToken && this.tokenSafe != null){				
				returnToken = new Token(this.tokenSafe);
				this.clearTokenSafe();
				
			}
			
			this.fillTokenSafe(nextTokenType, character);		
			
			StateType newState = this.state.type;
			
			System.out.println("Character '" + character.getChar() + "' " + oldState + "->" + newState);			

			
			
			if(this.currentRead.equals("NULL")){
				this.changeTokenSafe(TokenType.NULL);
			}
			
			
			if(!returnToken.isEmpty())
				return returnToken;
		}		

	}
	
	public void fillTokenSafe(TokenType newType, LexCharacter characterToAdd){
		String read = "";
		
		if(this.tokenSafe != null) 	read += this.tokenSafe.text;		
		if(characterToAdd != null)	read += characterToAdd.getChar();
		
		this.currentRead = read;
		
		this.tokenSafe = new Token(
				newType, read, this.state.type, this.pointer
				);
	}
	
	public void changeTokenSafe(TokenType updateType){
		this.tokenSafe.type = updateType;
	}
	
	public void clearTokenSafe(){
		this.tokenSafe = null;
	}
	
	public void changeState(StateType newType){
		this.state.type = newType;
	}
	
	public LexCharacter nextCharacter(){
		this.movePointer();
			
		LexCharacter character = this.characterAt(this.pointer);
		
		
		this.currentCharacter = character;
		
		return character;
	}
	
	public LexCharacter characterAt(int position){
			
		LexCharacter character = LexCharacter.splitFromString(this.input, this.pointer);
		
		return character;
	}
	
	
	
	public void movePointer(){
		this.pointer++;
	}
	
	
}
