package jp.skypencil.antlr;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

public class StatementTest {
	@Test
	public void testTomcatRuns() throws RecognitionException {
		CharStream input = new ANTLRStringStream("Tomcat runs");
		StatementLexer lexer = new StatementLexer(input);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(lexer);
		StatementParser parser = new StatementParser(tokens);

		parser.statement();
		assertThat(parser.getNumberOfSyntaxErrors(), is(0));
	}
}
