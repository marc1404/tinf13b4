package dhbw.schneider.SpracheX;

import dhbw.schneider.SpracheX.Token.Token;

public class ParserTreeNode {
	private Token token;
	
	private String type;
	
	public ParserTreeNode(String type){
		this.token = null;
		this.type = type;
	}
	
	public ParserTreeNode(Token token){
		this.token = token;
		this.type = token.type.name();
	}
	
	public ParserTreeNode(Token token, String type){
		this.token = token;
		this.type = type;
	}
	
	public String toString(){
		return this.type;
	}
	
	public boolean is(String compare){
		return this.type.equals(compare);
	}
}
