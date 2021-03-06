package jadx.tests.integration.arith;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

import jadx.NotYetImplemented;
import jadx.core.dex.nodes.ClassNode;
import jadx.tests.api.IntegrationTest;

public class TestArith2 extends IntegrationTest {

	public static class TestCls {

		public int test1(int a) {
			return (a + 2) * 3;
		}

		public int test2(int a, int b, int c) {
			return a + b + c;
		}
	}

	@Test
	public void test() {
		ClassNode cls = getClassNode(TestCls.class);
		String code = cls.getCode().toString();

		assertThat(code, containsString("return (a + 2) * 3;"));
		assertThat(code, not(containsString("a + 2 * 3")));
	}

	@Test
	@NotYetImplemented
	public void test2() {
		ClassNode cls = getClassNode(TestCls.class);
		String code = cls.getCode().toString();

		assertThat(code, containsString("return a + b + c;"));
		assertThat(code, not(containsString("return (a + b) + c;")));
	}
}
