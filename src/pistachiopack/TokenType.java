package pistachiopack;
/** This class is about the different types of tokens to be encountered */
public enum TokenType {
	
	/** Absolutely nothing */
	EMPTY,
	
	/** A token, for example,()= , */
	TOKEN,
	
	/** First character is a letter, any proceeding characters are letters or numbers */
	IDENTIFIER,
	
	/** A number */
	INTEGER_LITERAL,
	
	/** Anything enclosed in double quotes. "Hello" "1" */
	STRING_LITERAL,
	
}
