tree grammar StatementWalker;

options
{
	ASTLabelType = CommonTree ;
}

tokens
{
	S = 'Tomcat';
	V = 'runs';
}

@header
{
	package jp.skypencil.antlr;
}

statement returns [Statement st = new Statement();]
	: (s=S v=V)
	{
		$st.setS(s.getText());
		$st.setV(v.getText());
	};

	