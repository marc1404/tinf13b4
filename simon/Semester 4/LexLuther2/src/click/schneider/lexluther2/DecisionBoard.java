package click.schneider.lexluther2;

import java.text.RuleBasedCollator;
import java.util.ArrayList;

import click.schneider.lexluther2.Enum.CharacterType;
import click.schneider.lexluther2.Enum.StateType;
import click.schneider.lexluther2.Enum.TokenType;

public class DecisionBoard {

	public ArrayList<DecisionRule> rules;
	
	public DecisionRule addRule(String state, CharacterType characterType,
			StateType nextState, Boolean outputToken, TokenType nextTokenType){
		DecisionRule rule = new DecisionRule(state, characterType, nextState, outputToken, nextTokenType);
		
		this.rules.add(rule);
		
		return rule;
	}
	
	public void addRules() {
		rules = new ArrayList<DecisionRule>();
		
		
		this.addRule("*", CharacterType.WS, StateType.WS, true, TokenType.EMPTY);
		this.addRule("*", CharacterType.LSBR, StateType.LSBR, true, TokenType.LSBR);		
		this.addRule("*", CharacterType.RSBR, StateType.RSBR, true, TokenType.RSBR);
		this.addRule("*", CharacterType.COMMA, StateType.COMMA, true, TokenType.COMMA);
		this.addRule("LSBR,RSBR,COMMA", CharacterType.DIGIT, StateType.NUMBER, true, TokenType.NUMBER);
		this.addRule("LSBR,RSBR,COMMA", CharacterType.ALPHA, StateType.NAME, true, TokenType.NAME);
				
		this.addRule("NUMBER", CharacterType.DIGIT, StateType.NUMBER, false, TokenType.NUMBER);
		this.addRule("NUMBER", CharacterType.ALPHA, StateType.NAME, false, TokenType.NAME);
		this.addRule("NAME", CharacterType.ALPHANUMERIC, StateType.NAME, false, TokenType.NAME);
	}
	
	public DecisionRule decide(State state, LexCharacter character){
		
		for(DecisionRule rule : this.rules){
			Boolean applies = rule.appliesTo(state, character);
			
			if(applies == true) return rule;
		}
		
		return DecisionRule.invalidRule();
		
	}
	
	
	
}
