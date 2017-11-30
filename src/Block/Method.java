package Block;

import pistachiopack.Type;
import pistachiopack.Value;
import pistachiopack.Parameter;
import pistachiopack.Variable;

public class Method extends Block{

	private String name;
	private Type type;
	private Parameter[] params;
	private Value returnValue;
	
	public Method(Block superBlock, String name,Type type, Parameter [] paramas) {
		super(superBlock);
		
		this.name = name;
		this.type = type;
		this.params = params;
	}

	@Override
	public void run() {
		invoke();
		
	}
	
	public Value invoke(Value...values){
		//Invoke the method with the supplied values
		
		if (values.length != params.length){
			throw new IllegalArgumentException("Wrong number of values for parmeters");
		}
		
		for(int i = 0; i < values.length && i < params.length; i++){
			Parameter p = params[i];
			Value v = values[i];
			
			if(p.getType() != v.getType()){
				throw new IllegalStateException("Parameter " + p.getName() + " Should be " + p.getType() + ". Got" + v.getType());
			}
			addVariable(new Variable(this, p.getType(), p.getName(), v.getValue()));
		}
		
		for(Block b : getSubBlocks()){
			b.run();
			if(returnValue != null){
				break;
			}
		}
		
		if(returnValue == null && type != Type.VOID){
			throw new IllegalStateException("Expected return value, got none.");
		}
		
		Value localReturnValue = returnValue;
		returnValue = null;
		return localReturnValue;
	}

}