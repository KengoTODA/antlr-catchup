package jp.skypencil.antlr;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.util.Map;

import jp.skypencil.antlr.StatementParser.statement_return;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.junit.Test;

public class StatementWalkerTest {
	@Test
	public void testTomcatRuns() throws RecognitionException {
		CharStream input = new ANTLRStringStream("Tomcat runs");
		StatementLexer lexer = new StatementLexer(input);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(lexer);
		StatementParser parser = new StatementParser(tokens);

		statement_return statement = parser.statement();
		CommonTree tree = (CommonTree) statement.getTree();
		CommonTreeNodeStream treeNodeStream = new CommonTreeNodeStream(tree);
		treeNodeStream.setTokenStream(tokens);

		StatementWalker walker = new StatementWalker(treeNodeStream);
		Map<String, String> map = walker.statement();
		assertThat(map.get("S"), is(equalTo("Tomcat")));
		assertThat(map.get("V"), is(equalTo("runs")));
	}
}
