package dhbw.schneider.ArraySyntax;

import java.util.ArrayList;

public class Parser {
	ArrayList<Token> tokens;
	
	int position = -1;
	
	int remember = 0;
	
	boolean rememberPaused = false;
	
	public int counter = 0;
	
	protected ParserTree tree;	
	protected ParserTree currentTree;
	protected ParserTree maybeTree;
	
	public Parser(ArrayList<Token> tokens){
		this.tokens = tokens;
		
	}
	
	public boolean run(){
		return true;
	}

	public boolean parse(TokenType tokenType){
		return this.parse(tokenType, true, null);
	}
	
	public boolean parse(TokenType tokenType, boolean remember, Token token){
		if(token == null) token = this.next();
		
		System.out.println("Parse: " + tokenType.name() );
		
		this.countUp(tokenType);
		if(remember) remember();
		
		if(token.type == tokenType){
			return true;
		}
		
		if(remember) reset();
		return false;
		
	}
	
	public Token next(){
		this.move();		
		return this.current();
	}
	
	public Token current(){
		return this.tokens.get(this.position);

	}
	
	public void move(){
		this.position++;
	}
	
	public void remember(){
		if(this.rememberPaused) return;
		
		this.hardRemember();
	}
	
	public void hardRemember(){
		this.remember = this.position;

	}
	
	public void reset(){
		this.position = this.remember;
	}
	
	private void countUp(TokenType type){
		this.counter++;
	}
	
	public boolean parseOr(TokenType... types){	
		//Only check one token and do not move on to the next if remember is paused
		Token token = this.next();			
		this.remember();
		
		for(TokenType type : types){
			if(this.parse(type, false, token)){
				this.addToMaybe(type.name());
				return true;
			}
		}
		
		this.reset();
		
		return false;
	}
		

	public boolean connectedParse(TokenType...types){
		this.remember();		
				
		for(TokenType type : types){
			if(!this.parse(type, false, null)){
				this.reset();
				return false;
			}
		}
		
		return true;
	}
	
	public void pauseRemember(){
		this.rememberPaused = true;
	}
	
	public void unpauseRemember(){
		this.rememberPaused = false;
	}
	
	public void startTree(String tokenType){
		this.tree = new ParserTree(tokenType);
		this.currentTree = this.tree;
	}
	
	public ParserTree addSubTree(String nodeType, boolean jumpInto){
		ParserTree subTree = new ParserTree(nodeType);
		
		return this.addSubTree(subTree, jumpInto);
	}
	
	public ParserTree addSubTree(ParserTree subTree, boolean jumpInto){
		
		this.currentTree.addChild(subTree);
		
		if(jumpInto){
			this.currentTree = subTree;
		}
		
		subTree.setParent(this.currentTree);
		
		
		return subTree;
	}
	
	public ParserTree setMaybeTree(String nodeType){
		ParserTree maybeTree = new ParserTree(nodeType);
		
		this.maybeTree = maybeTree;
		
		return maybeTree;
	}
	
	public void addToMaybe(String nodeType){
		this.maybeTree.addChild(nodeType);
	}
	
	public void releaseMaybe(boolean successfull){
		if(successfull){
			this.addSubTree(this.maybeTree, false);
		}
		
		this.maybeTree = null;
	}
	
	public String toString(){
		return this.tree.toString();
	}
}
