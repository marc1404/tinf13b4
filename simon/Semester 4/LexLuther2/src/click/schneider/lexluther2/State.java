package click.schneider.lexluther2;

import java.util.ArrayList;

import click.schneider.lexluther2.Enum.CharacterType;
import click.schneider.lexluther2.Enum.StateType;

public class State {
	public StateType type;
	
	public State(StateType type){
		this.type = type;
	}
	
	public boolean isAny(){
		return true;
	}
	
	public boolean isEmpty(){
		return this.type == StateType.EMPTY;
	}
	
	public boolean is(String string){
		return this.is(this.stringToTypes(string));
	}
	
	public ArrayList<StateType> stringToTypes(String string){
		String[] stateStrings = string.split(",");
		
		ArrayList<StateType> types = new ArrayList<StateType>();
		
		int i = 0;
		for(String stateString : stateStrings){
			types.add(StateType.valueOf(stateString));
		}

		return types;
	}
	
	public boolean is(StateType compare){
		return this.type == compare;
	}
	
	public boolean is(StateType[] stateTypes){		
		for(StateType stateType : stateTypes){
			if(this.is(stateType)) return true;
		}
		
		return false;
	}
	
	public boolean is(ArrayList<StateType> stateTypes){		
		for(StateType stateType : stateTypes){
			if(this.is(stateType)) return true;
		}
		
		return false;
	}
	
	
	
	public static State createEmpty(){
		return new State(StateType.EMPTY);
	}
	
	public static State fromCharacter(LexCharacter character){
		StateType type = StateType.EMPTY;
		if(character.hasType(CharacterType.ALPHA)) type = StateType.NAME;
		
		return new State(type);
	}
}
