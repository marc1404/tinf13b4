package click.schneider.lexluther2;

import click.schneider.lexluther2.Enum.CharacterType;
import click.schneider.lexluther2.Enum.StateType;
import click.schneider.lexluther2.Enum.TokenType;

public class DecisionRule {

	public String stateTypes;
	
	public CharacterType characterType;
	
	public StateType nextState;
	
	public Boolean outputToken;
	
	TokenType nextTokenType;

	public DecisionRule(String state, CharacterType characterType,
			StateType nextState, Boolean outputToken, TokenType nextTokenType) {
		super();
		this.stateTypes = state;
		this.characterType = characterType;
		this.nextState = nextState;
		this.outputToken = outputToken;
		this.nextTokenType = nextTokenType;
	}

	public Boolean appliesTo(State state, LexCharacter character) {

		if(!state.is(this.stateTypes) ){
			return false;
		}
		
		if(!character.hasType(this.characterType) ){
			return false;
		}
		
		return true;
		
	}
	
	public static DecisionRule invalidRule(){
		return new DecisionRule("*", CharacterType.EMPTY, StateType.INVALID, false, TokenType.INVALID);
	}

	
	
	
	
}
