package dhbw.schneider.SpracheX.Token;


import dhbw.schneider.SpracheX.*;

public class Token {
	public TokenType type;
	int yyline;
	int yycolumn;
	public Object value;
	
	public SymbolTable symbolTable;
	
	public Symbol symbol;

	
	public Token(TokenType type, int yyline, int yycolumn, Object value) {
		super();
		this.type = type;
		this.yyline = yyline;
		this.yycolumn = yycolumn;
		this.value = value;
		this.symbolTable = this.getSymbolTable();
		
		this.addToTable();
	}
	
	public SymbolTable getSymbolTable(){
		return SymbolTable.getBase();
	}
	
	public String toString(){
		
		return "["+ this.type + ":" + this.symbol.type + "] \"" + this.value + "\" \t\t @ "
				+ this.yyline +","+ this.yycolumn + " \t\t - id:" + this.getSymbolId();
		
	}
	
	public boolean isEOF(){
		return this.type == TokenType._EOF;
	}
	
	public static Token tokenize(TokenType type, int yyline, int yycolumn, Object value){
		if(type == TokenType.NUMBER)
			return new IntToken(type, yyline, yycolumn, value);
		
		
		return new Token(type, yyline, yycolumn, value);
	}
	 
	public Symbol addToTable(){
		Symbol symbol = this.symbolTable.addSymbol(this);
		this.symbol = symbol;
		return symbol;
	}
	
	public int getSymbolId(){
		if(this.symbol == null) return -1;
		
		return this.symbol.id;
		
	}
}
