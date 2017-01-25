package ArithmeticExpressionParser;

public class Lexer {

	String s;
	int pos = 0;
	Lexeme token;
	double token_value;
	
	public Lexer(String s) {
		this.s = s;
		next();
	}
	

	public void read(Lexeme token) {
		if(this.token == token){
			next();
		}else{
			throw new RuntimeException("Got: "+this.token+", expected: "+token);
		}
	}
	
	private void next() {
		while(pos < s.length() && Character.isWhitespace(s.charAt(pos)))
			pos++;
		
		if(pos == s.length()){
			token = Lexeme.END;
			return;
		}
		
		switch(s.charAt(pos)){
		case '+':
			pos++;
			token = Lexeme.PLUS;
			return;
		case '-':
			pos++;
			token = Lexeme.MINUS;
			return;
		case '*':
			pos++;
			token = Lexeme.MUL;
			return;
		case '/':
			pos++;
			token = Lexeme.DIV;
			return;
		case '%':
			pos++;
			token = Lexeme.MOD;
			return;
		case '^':
			pos++;
			token = Lexeme.POW;
			return;
		case '(':
			pos++;
			token = Lexeme.LP;
			return;
		case ')':
			pos++;
			token = Lexeme.RP;
			return;
		}
		
		if(!Character.isDigit(s.charAt(pos)))
			throw new RuntimeException("Unexpected character: '"+s.charAt(pos)+"'");
		
		String n = "";
		while(pos < s.length() && (Character.isDigit(s.charAt(pos)) || s.charAt(pos) == '.')){
			n += s.charAt(pos);
			pos++;
		}
		token = Lexeme.NUM;
		token_value = Double.parseDouble(n);
	}

	
}
