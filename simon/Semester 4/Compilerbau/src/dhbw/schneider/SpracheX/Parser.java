package dhbw.schneider.SpracheX;

import java.util.ArrayList;

import dhbw.schneider.SpracheX.Token.Token;

public class Parser {
	ArrayList<Token> tokens;
	
	int position = -1;
	
	int remember = 0;
	
	int parentRemember = 0;

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

	public ParserTree parse(TokenType tokenType){
		return this.parse(tokenType, true, null);
	}
	
	public ParserTree parse(TokenType tokenType, boolean remember, Token token){
		if(token == null) token = this.next();
		
		System.out.println("Parse: " + tokenType.name() );
		
		this.countUp(tokenType);
		remember();
		
		if(token.type == tokenType){
			return new ParserTree(tokenType);
		}
		
		reset();
		return ParserTree.invalid();
		
	}
	
	public ParserTree parseAndAdd(TokenType tokenType){
		ParserTree parse = this.parse(tokenType);
		
		if(!parse.isValid()) return parse;
		
		this.addSubTree(parse, false);
		
		return parse;
		
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
		this.remember = this.position;

	}
	
	public void parentRemember(){
		this.parentRemember = this.position;
	}
	
	public void reset(){
		this.resetTo(this.remember);
	}
	
	public void resetTo(int to){
		this.position = to;
	}
	
	public void resetToParent(){
		this.resetTo(this.parentRemember);
	}
	
	private void countUp(TokenType type){
		this.counter++;
	}
	
	public ParserTree parseOr(TokenType... types){	
		//Only check one token and do not move on to the next if remember is paused
		Token token = this.next();			
		this.remember();
		
		for(TokenType type : types){
			if(this.parse(type, false, token).isValid()){
				return new ParserTree(type);
			}
		}
		
		this.reset();
		
		return ParserTree.invalid();
	}
		

	public ParserTree connectedParse(TokenType...types){
		this.parentRemember();	
		
		ParserTree connection = new ParserTree("Group");
		
		for(TokenType type : types){
			if(!this.parse(type, false, null).isValid()){
				this.resetToParent();
				return ParserTree.invalid();
			}
			
			connection.addChild(new ParserTree(type));
		}
		
		return connection;
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
