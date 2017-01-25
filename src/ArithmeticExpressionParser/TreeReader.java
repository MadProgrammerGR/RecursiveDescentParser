package ArithmeticExpressionParser;

public class TreeReader {
	
	public static double read(Node node) {
		if (node == null) return 0;
		switch(node.symbol){
		case NUM:
			return node.value;
		case PLUS:
			return read(node.left) + read(node.right);
		case MINUS:
			return read(node.left) - read(node.right);
		case MUL:
			return read(node.left) * read(node.right);
		case DIV:
			return read(node.left) / read(node.right);
		case MOD:
			return read(node.left) % read(node.right);
		case POW:
			return Math.pow(read(node.left), read(node.right));
		default:
			return 0;
		}
	}

}
