package dhbw.schneider.SpracheX.Token;

import dhbw.schneider.SpracheX.TokenType;

public class IntToken extends Token{

	public int value;
	
	public IntToken(TokenType type, int yyline, int yycolumn, Object value) {		
		super(type, yyline, yycolumn, value);
		
		this.value = Integer.parseInt((String) value);
	}
	

	
	
}
