package ArithmeticExpressionParser;

public enum Lexeme {
	NUM("number"), 
	PLUS("+"), 
	MINUS("-"), 
	MUL("*"), 
	DIV("/"), 
	MOD("%"), 
	POW("^"), 
	LP("("), 
	RP(")"), 
	END("END");
	
	String s;
	private Lexeme(String s){
		this.s = s;
	}
	
	public String toString(){
		return s;
	}
}
