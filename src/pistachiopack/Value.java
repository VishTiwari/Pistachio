package pistachiopack;
/**
 * Represents a value.
 */
public class Value {

	private Type type;
	
	public Value(Type type,Object value){
		this.type = type;
		this.value = value;
	}
	public Type getType(){
		return type;
	}
	private Object value;
	
	public Object getValue(){
		return value;
	}
	
	public void setValue(Object value){
		this.value = value;
	}
}
