package ArithmeticExpressionParser;

public class Node {
	
	Lexeme symbol;
	double value;
	Node left;
	Node right;
	
	public Node(Lexeme symbol) {
		this.symbol = symbol;
	}
	
	public String toString() {
		if(symbol == Lexeme.NUM)
			return "[ '"+symbol+"' , "+value+" ]";
		else
			return "[ '"+symbol+"' ]";
	}
	
}
