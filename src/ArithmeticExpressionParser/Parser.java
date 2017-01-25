package ArithmeticExpressionParser;

public class Parser {
	
	Lexer lex;
	
	public Parser(Lexer lex) {
		this.lex = lex;
	}
	
	public Node parse() throws RuntimeException, NumberFormatException, ArithmeticException, Exception {
		Node root = expression();
		if(lex.token != Lexeme.END)
			throw new RuntimeException("Invalid expression.");
		return root;
	}

	// <E> ::= <P> ( '+' <E> | '-' <E> | e )
	private Node expression() {
		Node temp = product();
		Node node;
		switch(lex.token){
		case PLUS:
			lex.read(Lexeme.PLUS);
			node = new Node(Lexeme.PLUS);
			node.left = temp;
			node.right = expression();
			return node;
		case MINUS:
			lex.read(Lexeme.MINUS);
			node = new Node(Lexeme.MINUS);
			node.left = temp;
			node.right = expression();
			return node;
		default:
			return temp;
		}
	}

	// <P> ::= <F> ( '*' <P> | '/' <P> | '%' <P> | e )
	private Node product() {
		Node temp = factor();
		Node node;
		switch(lex.token){
		case MUL:
			lex.read(Lexeme.MUL);
			node = new Node(Lexeme.MUL);
			node.left = temp;
			node.right = product();
			return node;
		case DIV:
			lex.read(Lexeme.DIV);
			node = new Node(Lexeme.DIV);
			node.left = temp;
			node.right = product();
			return node;
		case MOD:
			lex.read(Lexeme.MOD);
			node = new Node(Lexeme.MOD);
			node.left = temp;
			node.right = product();
			return node;
		default:
			return temp;
		}
	}

	// <F> ::= <N> ( '^' <F> | e )
	private Node factor() {
		Node temp = number();
		switch(lex.token){
		case POW:
			lex.read(Lexeme.POW);
			Node node = new Node(Lexeme.POW);
			node.left = temp;
			node.right = factor();
			return node;
		default:
			return temp;
		}
	}

	// <N> ::= n | '(' <E> ')' | '-' <N>
	private Node number() {
		Node node;
		switch(lex.token){
		case NUM:
			lex.read(Lexeme.NUM);
			node = new Node(Lexeme.NUM);
			node.value = lex.token_value;
			return node;
		case LP:
			lex.read(Lexeme.LP);
			//if its minus then multiply by -1
			if(lex.token == Lexeme.MINUS){
				lex.read(Lexeme.MINUS);
				node = new Node(Lexeme.MUL);
				node.left = number();
				node.right = new Node(Lexeme.NUM);
				node.right.value = -1;
			}else{
				node = expression();				
			}
			lex.read(Lexeme.RP);
			return node;
		default:
			throw fail();
		}
	}

	private RuntimeException fail() {
		return new RuntimeException("Unexpected character '"+lex.token+"'");
	}
	
}
