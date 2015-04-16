package click.schneider.lexluther2;

import java.util.ArrayList;

import click.schneider.lexluther2.Enum.CharacterType;
import click.schneider.lexluther2.Enum.StateType;
import click.schneider.lexluther2.Enum.TokenType;

public class LexCharacter {
	
	private char character;

	private ArrayList<CharacterType> types = new ArrayList<CharacterType>();
	
		
	public LexCharacter(char character) {
		this.character = character;
		this.types = this.detectTypes();
		
	}
	
	public LexCharacter(){
		this.types.add(CharacterType.EMPTY);
		
	}
	
	public ArrayList<CharacterType> detectTypes(){
		ArrayList<CharacterType> detectedTypes = new ArrayList<CharacterType>();
		
		
		
		if(this.is('[')){
			detectedTypes.add(CharacterType.LSBR);
		}
		
		if(this.is(']')){
			detectedTypes.add(CharacterType.RSBR);
		}
		
		if(this.is(',')){
			detectedTypes.add(CharacterType.COMMA);
		}
		
		if(this.is('.')){
			detectedTypes.add(CharacterType.DOT);
		}
		
		if(this.is(' ')){
			detectedTypes.add(CharacterType.WS);
		}
		
		boolean isAlphaNumeric = false;
		if(Character.isAlphabetic(this.character)){
			detectedTypes.add(CharacterType.ALPHA);
			isAlphaNumeric = true;
		}
		
		if(Character.isDigit(this.character)){
			detectedTypes.add(CharacterType.DIGIT);
			isAlphaNumeric = true;
		}		
		
		if(isAlphaNumeric){
			detectedTypes.add(CharacterType.ALPHANUMERIC);
		}
					
		return detectedTypes;
	}
	
	public boolean is(char compare){
		return compare == this.character;
	}
	
	public boolean hasOne(CharacterType[] characterTypes){
		for(CharacterType characterType : characterTypes){
			if(this.hasType(characterType)) return true;
		}
		
		return false;
	}

	public void addType(CharacterType characterType){
		this.types.add(characterType);
	}
	
	public boolean hasType(CharacterType characterType){
		return this.types.contains(characterType);
	}
	
	public boolean isEmpty(){
		return this.hasType(CharacterType.EMPTY);
	}
	
	public static LexCharacter splitFromString(String input, int pointer) {
		char[] chars = input.toCharArray();
		
		char character;
		
		Boolean isValid = true;
		
		if(pointer >= chars.length){
			isValid = false;
		}
		
		if(pointer < 0){
			isValid = false;
		}
		
		if(isValid){
			return new LexCharacter(chars[pointer]);
		} else {
			return LexCharacter.createEmptyCharacter();
			
		}
	}
	
	public static LexCharacter createEmptyCharacter(){
		return new LexCharacter();
	}
	
	public char getChar(){
		return this.character;
	}
	
	public String toString(){
		String types = "";
		
		for (CharacterType characterType : this.types) {
			types += characterType.name() + " ";
		}
		
		return this.character + " : " + types;
	}
	
	public StateType guessStateType(){
		StateType type = StateType.INVALID;
		if(this.hasType(CharacterType.ALPHA)) type = StateType.NAME;
		if(this.hasType(CharacterType.DIGIT)) type = StateType.NUMBER;

		return type;
	}

	
	public TokenType guessTokenType(){
		TokenType type = TokenType.INVALID;
		if(this.hasType(CharacterType.ALPHA)) type = TokenType.NAME;
		if(this.hasType(CharacterType.DIGIT)) type = TokenType.NUMBER;

		return type;
	}

}
