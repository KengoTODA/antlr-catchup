package jp.skypencil.antlr;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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
		Statement st = walker.statement();
		assertThat(st.getS(), is(equalTo("Tomcat")));
		assertThat(st.getV(), is(equalTo("runs")));
	}
}
