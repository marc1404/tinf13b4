package dhbw.schneider.SpracheX;

import dhbw.schneider.SpracheX.SymbolType;
import dhbw.schneider.SpracheX.TokenType;
import dhbw.schneider.SpracheX.Token.*;

public class Symbol {
	public int id;
	
	public String text;

	public Object value;
	private int intValue;
	private Float floatValue;
	private String stringValue;
	
	public SymbolType type;
	
	private Token token;
	
	public Symbol(int id, Token token) {
		super();
		this.id = id;
		this.text = (String) token.value;
		this.token = token;
		
		this.parse();
	}
	
	private void parse(){
		switch(token.type){
		case NUMBER:
			this.parseInt();
			break;
		case FLOAT:
			this.parseFloat();
			break;
		default:
			this.parseString();
			break;		
		}
	}
	
	private void parseInt(){
		this.intValue = Integer.parseInt(this.text);
		this.value = this.intValue;
		this.type = SymbolType.INTEGER;
	}
	
	private void parseFloat(){
		this.floatValue = Float.parseFloat(this.text);
		this.value = this.floatValue;
		this.type = SymbolType.FLOAT;
	}
	
	private void parseString(){
		this.stringValue = String.valueOf(this.text);		
		this.value = this.stringValue;
		this.type = SymbolType.STRING;		
	}
	
	public boolean is(String compare){
		return text.equals(compare);
	}
	
	public String toString(){
		return id + ": \"" + this.value + "\" [" + this.type +"]";
	}
}
