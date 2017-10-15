package pistachio.me;
import Block.Class;
import pistachiopack.Tokenizer;
import Block.Block;

public class ClassParser extends Parser<Class> {

	@Override
	public boolean shouldParse(String line) {
		return line.matches("class [a-zA-Z][a-zA-Z0-9]*");
	}

	@Override
	public Class parse(Block superBlock, Tokenizer tokenizer) {
		tokenizer.nextToken(); //Skip class token
		
		String name = tokenizer.nextToken().getToken();
		
		return new Class(name);
	}
}


