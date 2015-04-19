package click.schneider.lexluther2;

import java.text.RuleBasedCollator;
import java.util.ArrayList;

import click.schneider.lexluther2.Enum.CharacterType;
import click.schneider.lexluther2.Enum.StateType;
import click.schneider.lexluther2.Enum.TokenType;

public class DecisionBoard {

	public ArrayList<DecisionRule> rules;
	
	public DecisionRule addRule(String stateTypes, CharacterType characterType,
			StateType nextState, Boolean outputToken, TokenType nextTokenType){
		DecisionRule rule = new DecisionRule(stateTypes, characterType, nextState, outputToken, nextTokenType);
		
		this.rules.add(rule);
		
		return rule;
	}
	
	public void addRules() {
		rules = new ArrayList<DecisionRule>();
		
		String breakingStates = "LSBR,RSBR,COMMA,BACKSLASH_NOSTRING";
		
		
		this.addRule("*", CharacterType.WS, StateType.WS, true, TokenType.EMPTY);
		this.addRule("*", CharacterType.LSBR, StateType.LSBR, true, TokenType.LSBR);		
		this.addRule("*", CharacterType.RSBR, StateType.RSBR, true, TokenType.RSBR);
		this.addRule("*", CharacterType.COMMA, StateType.COMMA, true, TokenType.COMMA);
		this.addRule(breakingStates, CharacterType.DIGIT, StateType.NUMBER, true, TokenType.NUMBER);
		this.addRule(breakingStates, CharacterType.ALPHA, StateType.NAME, true, TokenType.NAME);
				
		this.addRule("NUMBER", 	CharacterType.DIGIT, StateType.NUMBER, false, TokenType.NUMBER);
		this.addRule("NUMBER", 	CharacterType.ALPHA, StateType.NAME, false, TokenType.NAME);
		this.addRule("NAME", 	CharacterType.ALPHANUMERIC, StateType.NAME, false, TokenType.NAME);
		this.addRule("NAME", 	CharacterType.DOT, StateType.DOT, true, TokenType.FLOAT);
		//NULL has an extra rule in the scanner
		
		this.addRule("NUMBER", 		CharacterType.DOT, StateType.DOT, false, TokenType.FLOAT);
		this.addRule("DOT,DECIMAL",	CharacterType.DIGIT, StateType.DECIMAL, false, TokenType.FLOAT);

		this.addRule("STRING",		CharacterType.BACKSLASH, StateType.BACKSLASH, false, TokenType.STRING); //Escaped Quotes
		this.addRule("*",			CharacterType.BACKSLASH, StateType.BACKSLASH_NOSTRING, true, TokenType.BACKSLASH); //Escaped Quotes
		this.addRule("BACKSLASH",	CharacterType.QUOTE, StateType.STRING, false, TokenType.STRING); //Escaped Quotes
	
		this.addRule("STRING",		CharacterType.QUOTE, StateType.QUOTE, true, TokenType.EMPTY); //End String
		this.addRule("*", 			CharacterType.QUOTE, StateType.QUOTE, true, TokenType.EMPTY); //Begin String
		this.addRule("QUOTE",		CharacterType._ANY,  StateType.STRING, true, TokenType.STRING); //Read String in
		this.addRule("STRING",		CharacterType._ANY,  StateType.STRING, false, TokenType.STRING); //Read String in
		
		/**
		 * Extra rules for invalid stuff (unknown characters, not existing rules)
		 */
		this.addRule("_VALID",		CharacterType.INVALID, StateType.INVALID, true, TokenType.INVALID);
		this.addRule("INVALID",		CharacterType.ALPHA, StateType.NAME, true, TokenType.NAME);
		this.addRule("INVALID",		CharacterType.DIGIT, StateType.NAME, true, TokenType.NUMBER);		
	}
	
	public DecisionRule decide(State state, LexCharacter character){
		
		for(DecisionRule rule : this.rules){
			Boolean applies = rule.appliesTo(state, character);
			
			if(applies == true) return rule;
		}
		
	
		try {
			throw new Exception("No valid or invalid rule found");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
}
