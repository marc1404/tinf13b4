package dhbw.schneider.ArraySyntax;

import java.util.ArrayList;

public class ParserTree {
	private static int indexCounter = 0;
	
	public String index;
	
	private ParserTree parent;
	
	
	private ParserTreeNode root;
	
	private int level;
	
	public ArrayList<ParserTree> subtrees = new ArrayList<ParserTree>();

	public ParserTree(String rootType){
		super();
		this.setRoot(rootType);
		init();
	}
	
	public ParserTree(Token root) {
		super();
		this.setRoot(root);
		init();
	}
	
	public void init(){
		this.indexCounter++;
		this.index = "n" + this.indexCounter;
	}
	
	public void setParent(ParserTree parent){
		this.parent = parent;
		this.level = parent.level++;
		
		for(ParserTree subTree : this.subtrees){
			subTree.setParent(this);
		}
	}
	
	public void setRoot(String rootType){
		this.root = new ParserTreeNode(rootType);
	}
	
	public void setRoot(Token root){
		this.root = new ParserTreeNode(root);
	}	
	
	
	public void addChild(ParserTree subTree){
		subTree.setParent(this);
		this.subtrees.add(subTree);
	}
	
	public void addChild(String nodeType){
		ParserTree subTree = new ParserTree(nodeType);
		this.addChild(subTree);
	}
	
	public String toString(){
		return this.toString(0);
	}
	
	public String toString(int level){
		String output = "";
		
		output += "[" + this.root.toString() + "] \n";
		
		level++;
		
		
		for(ParserTree tree : this.subtrees){
			for(int i = 0; i != level; i++){
				output += "\t";
			}
			
			output += level + tree.toString(level);
		}
		
		return output;
	}
	
	public String name(){
		return this.root.toString();
	}
	
	public String toDiGraph(){
		ArrayList<ParserTree> allTrees = this.allTrees();
		
		String output = "";
		
		output += "digraph { \n";
		
		for(ParserTree tree : allTrees){
			output += "\t" + tree.index + " \t [label=\""+ tree.name() + "\"] \n";
		}
		
		output += "\n";
		
		for(ParserTree parent : allTrees){
			for(ParserTree child : parent.subtrees){
				output += "\t" + parent.diGraphEdge(child) + "\n";
			}			
		}
		
		output += "\n}";
		
		return output;
	}
	
	private String diGraphEdge(ParserTree toTree){
		return this.index + " \t -> " + toTree.index;
	}
	
	public ArrayList<ParserTree> allTrees(){
		ArrayList<ParserTree> allTrees = new ArrayList<ParserTree>();
		
		allTrees.add(this);
		this.collectSubTrees(allTrees);
		
		return allTrees;
		
	}
	
	public void collectSubTrees(ArrayList<ParserTree> collection){
		for(ParserTree subtree : this.subtrees){
			collection.add(subtree);
			subtree.collectSubTrees(collection);
		}
	}
}
