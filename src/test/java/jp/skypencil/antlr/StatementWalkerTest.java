package jp.skypencil.antlr;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import jp.skypencil.antlr.StatementParser.statement_return;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StatementWalkerTest {
	private final String target;

	@Parameters
	public static Collection<Object[]> createParameter() {
		return Arrays.asList(new Object[][]{
				{ "Tomcat runs" },
				{ "Jenkins stays" }
		});
	}

	public StatementWalkerTest(String target) {
		this.target = target;
	}

	@Test
	public void testWalker() throws RecognitionException {
		CharStream input = new ANTLRStringStream(target);
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
		assertThat(st.getS(), is(equalTo(target.split(" ")[0])));
		assertThat(st.getV(), is(equalTo(target.split(" ")[1])));
	}
}
