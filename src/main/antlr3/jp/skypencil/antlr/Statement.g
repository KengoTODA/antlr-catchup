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

S: 'Tomcat';

V: ('a'..'z')+;