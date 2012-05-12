tree grammar StatementWalker;

options
{
	ASTLabelType = CommonTree ;
	tokenVocab = Statement;
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
