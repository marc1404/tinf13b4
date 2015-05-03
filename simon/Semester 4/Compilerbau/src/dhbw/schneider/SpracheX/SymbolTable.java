package dhbw.schneider.SpracheX;

import java.util.ArrayList;

import dhbw.schneider.SpracheX.Token.Token;

public class SymbolTable {
	private static SymbolTable base;	
	
	public ArrayList<Symbol> symbols = new ArrayList<Symbol>();
	
	public int latestIndex = -1;
	
		
	public static SymbolTable getBase(){
		if(SymbolTable.base == null){
			SymbolTable.base = new SymbolTable();
		}
		
		return SymbolTable.base;		
		
	}
	
	public Symbol getSymbol(Token token){
		String text = (String) token.value;
		
		for(Symbol symbol : this.symbols){
			if(symbol.is(text)) return symbol;
		}
		
		return null;
	}
	
	public Symbol getSymbolAt(int id){
		if(id >= this.symbols.size() || id < 0){
			return null;
		}
		
		return this.symbols.get(id);
	}
	
	public Symbol addSymbol(Token token){
		Symbol found = this.getSymbol(token);		
		if(found != null) return found;
		
		return this.saveNewSymbol(token);
	}
	
	private Symbol saveNewSymbol(Token token){
		this.latestIndex++;
		Symbol newSymbol = new Symbol(this.latestIndex, token);
		
		symbols.add(this.latestIndex, newSymbol);
		
		return newSymbol;
	}

	
	public String toString(){
		return this.symbols.toString();
	}

}
