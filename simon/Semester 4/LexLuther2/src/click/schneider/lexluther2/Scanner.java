package click.schneider.lexluther2;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import click.schneider.lexluther2.Enum.CharacterType;
import click.schneider.lexluther2.Enum.StateType;
import click.schneider.lexluther2.Enum.TokenType;

public class Scanner {

	public ArrayList<Token> tokens = new ArrayList<Token>();
	
	public Token token;
	
	private Token tokenSafe;
	
	public String input;
	
	public BufferedReader inputReader;
	
	public State state;
	
	public char[] inputChars;
	
	public int pointer = -1;
	
	public boolean endReached = false;
	
	public LexCharacter currentCharacter;

	public String currentRead;
	
	private DecisionBoard decisionBoard;
	
	public Scanner(String input) {
		super();
		this.input = input;
		this.inputChars = input.toCharArray();
		
		this.decisionBoard = new DecisionBoard();
		this.decisionBoard.addRules();
		
		
		this.runScan();
	}
	
	public Scanner(BufferedReader reader){
		this("");
		this.inputReader = reader;
	}
		
	public void runScan(){
		
		this.state = State.createEmpty();	
		this.token = Token.createEmptyToken();
		
		while(this.token != null){			
			this.token = this.nextToken();
			
			if(this.token == null) break;
			
			this.token.outputTo(this.tokens);
		}
		
		System.out.println("===");
		System.out.println("IN: " + this.input);
		System.out.println("OUT: ");
		
		for(Token token : this.tokens){
			System.out.println(token);
		}
		
		System.out.println("\r\nSymboltable:");		
		System.out.println(SymbolTable.getBase());
		
	}
	
	public void runReaderScan(){
		int c;
		/*while(c = this.inputReader.read() != -1){
			
		}
		*/
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
			
			/**
			 * Decide which rule applies to the current state and read character
			 */			
			DecisionRule applyingRule = decisionBoard.decide(this.state, character);
			this.changeState(applyingRule.nextState.type);
			
			if(applyingRule.nextState.isInvalid()){
				System.out.println("INVALID");
				System.out.println(character);
			}

			/**
			 * Output the token of the rules tells us to
			 */
			if(applyingRule.outputToken && this.tokenSafe != null){				
				returnToken = new Token(this.tokenSafe);
				this.clearTokenSafe();
				
			}
			
			/**
			 * Change the currently saved token
			 */			
			this.fillTokenSafe(applyingRule.nextTokenType, character);		
			
			/**
			 * For console output
			 */
			StateType newState = this.state.type;			
			System.out.println("Character '" + character.getChar() + "' " + oldState + "->" + newState);			
		
			/**
			 * Extra rule for NULL
			 */
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
