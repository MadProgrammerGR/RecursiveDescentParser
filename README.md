# RecursiveDescentParser
A simple yet fully functional parser for arithmetic expressions.


```sh
Using this grammar:
<expression> ::= <product> ( '+' <expression> | '-' <expression> | e )
<product> ::= <factor> ( '*' <product> | '/' <product> | '%' <product> | e )
<factor> ::= <number> ( '^' <factor> | e )
<number> ::= n | '(' <expression> ')' | '-' <number>
```

(See [test](https://github.com/MadProgrammerGR/RecursiveDescentParser/blob/master/src/Test.java) for usage and capabilities)
