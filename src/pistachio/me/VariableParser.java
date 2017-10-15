package pistachio.me;

import Block.Block;
import pistachiopack.Tokenizer;
import pistachiopack.Token;
import pistachiopack.Type;
import pistachiopack.Variable;
import pistachiopack.TokenType;


public class VariableParser extends Parser<Block> {
	
	@Override
	public boolean shouldParse(String line) {
		
		return line.matches("var [a-zA-Z] + [a-zA-Z]+ = \"?[a-zA-Z0-9]\"?");
	}

	public Block parse(Block superBlock, Tokenizer tokenizer){
		tokenizer.nextToken(); //skip the var token
		
		Type type =Type.valueOf(tokenizer.nextToken().getToken().toUpperCase());
		
		if (type == Type.VOID){
			throw new IllegalStateException("Cannot declare variables of type void.");
		}
		
		String name = tokenizer.nextToken().getToken();
		
		tokenizer.nextToken(); //skip the = token
		
		Token v = tokenizer.nextToken();
		Object value = null;
		
		if(v.getType()== TokenType.INTEGER_LITERAL){
			value = Integer.valueOf(v.getToken());
		}
		else if (v.getType()== TokenType.STRING_LITERAL){
			value = v.getToken();
		}
		else/*If it's an identifier */{
			value = superBlock.getVariable(v.getToken()).getValue();
		}
	
		superBlock.addVariable(new Variable(superBlock, type, name,value));
		return null;
	} 
	
}
