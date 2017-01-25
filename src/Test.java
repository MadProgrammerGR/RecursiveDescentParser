import ArithmeticExpressionParser.Lexer;
import ArithmeticExpressionParser.Node;
import ArithmeticExpressionParser.Parser;
import ArithmeticExpressionParser.TreeReader;

public class Test {

	public static void main(String[] args) throws Exception{
		test("1+1");
		test("2*3 + 1");
		test("2 * (3+1)");
		test("1.5 * 2 / 3");
		test("5 ^ (3-1) + 0.35");
		test("415 % 3 - 10");
		test("2*(-3)");
		test("2*(-(1+2))");
	}
	
	
	private static void test(String s) throws Exception{
		Lexer lexer = new Lexer(s);
		Parser parser = new Parser(lexer);
		Node root = parser.parse();
		double result = TreeReader.read(root);
		System.out.println(s.trim()+" = "+result);	
	}

}
