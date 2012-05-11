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

statement returns [java.util.Map<String, String> map = new java.util.HashMap<String, String>();]
	: (s=S v=V)
	{
		$map.put("S", s.getText());
		$map.put("V", v.getText());
	};

	