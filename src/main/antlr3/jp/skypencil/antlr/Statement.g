grammar Statement;

options
{
	output = AST ;
}

@lexer::header {
package jp.skypencil.antlr;
}

@parser::header {
package jp.skypencil.antlr;
}

statement : S V;

S: ('A'..'Z') ('a'..'z')+;

V: ('a'..'z')+;