package dhbw.schneider.SpracheX.Token;

import dhbw.schneider.SpracheX.TokenType;

public class FloatToken extends Token{

	public float value;
	
	public FloatToken(TokenType type, int yyline, int yycolumn, Object value) {		
		super(type, yyline, yycolumn, value);
		
		this.value = Float.parseFloat((String) value);
	}
	

	
	
}
