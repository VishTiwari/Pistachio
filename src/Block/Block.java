package Block;

import java.util.ArrayList;

import pistachiopack.Variable;

/**
 * Represents a block of code
 */

public abstract class Block {

	private Block superBlock;
	private ArrayList<Block> subBlocks;	
	private ArrayList<Variable> variables;
	
	public Block(Block superBlock){
		this.superBlock = superBlock;
		this.subBlocks = new ArrayList<>();
		this.variables =  new ArrayList<>();
	}
	
	public Block getSuperblock() {
		return superBlock;
	}
	
	public Block[] getSubBlocks(){
		return subBlocks.toArray(new Block[subBlocks.size()]);
	}
	
	public void addBlock(Block block){
		subBlocks.add(block);
	}
	
	public Variable getVariable(String name){
		// Check the superBlocks first.
		for(Variable v : variables){
			if(v.getName().equals(name)){
				return v;
			}
		}
		return null;
	}
	
	public void addVariable(Variable v){
		variables.add(v);
	}
	
	public abstract void run();
	}
	
