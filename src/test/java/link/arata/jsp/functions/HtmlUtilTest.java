package link.arata.jsp.functions;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class HtmlUtilTest {
	@Test
	public void escapeメソッドの値が変わらないことのテスト() {
		assertThat(HtmlUtil.escape("あいうえお"), is("あいうえお"));
	}

	@Test
	public void escapeメソッドでltがエスケープされることのテスト() {
		assertThat(HtmlUtil.escape("<"), is("&lt;"));
	}

	@Test
	public void escapeメソッドで複数のltがエスケープされることのテスト() {
		assertThat(HtmlUtil.escape("<<"), is("&lt;&lt;"));
	}

	@Test
	public void escapeメソッドでgtがエスケープされることのテスト() {
		assertThat(HtmlUtil.escape(">"), is("&gt;"));
	}

	@Test
	public void escapeメソッドで複数のgtがエスケープされることのテスト() {
		assertThat(HtmlUtil.escape(">>"), is("&gt;&gt;"));
	}

	@Test
	public void escapeメソッドでダブルクォートがエスケープされることのテスト() {
		assertThat(HtmlUtil.escape("\""), is("&quot;"));
	}

	@Test
	public void escapeメソッドで複数のダブルクォートがエスケープされることのテスト() {
		assertThat(HtmlUtil.escape("\"\""), is("&quot;&quot;"));
	}

	@Test
	public void escapeメソッドでアンドがエスケープされることのテスト() {
		assertThat(HtmlUtil.escape("&"), is("&amp;"));
	}

	@Test
	public void escapeメソッドで服薄のアンドがエスケープされることのテスト() {
		assertThat(HtmlUtil.escape("&&"), is("&amp;&amp;"));
	}

	@Test
	public void escapeメソッドで複数の文字列が正しくエスケープされることのテスト() {
		assertThat(HtmlUtil.escape("<>\"&"), is("&lt;&gt;&quot;&amp;"));
	}

	@Test
	public void escapeメソッドで通常の文字列も含んだテスト() {
		assertThat(HtmlUtil.escape("<div>\"drag&drop\"</div>"), is("&lt;div&gt;&quot;drag&amp;drop&quot;&lt;/div&gt;"));
	}

	@Test
	public void lineBreakToBrメソッドで￥r￥nが正しく変換されること() {
		assertThat(HtmlUtil.lineBreakToBr("\r\n"), is("<br>"));
	}

	@Test
	public void lineBreakTToBrメソッドで￥nが正しく変換されること() {
		assertThat(HtmlUtil.lineBreakToBr("\n"), is("<br>"));
	}

	@Test
	public void lineBreakTToBrメソッドで￥rが正しく変換されること() {
		assertThat(HtmlUtil.lineBreakToBr("\r"), is("<br>"));
	}

	@Test
	public void lineBreakTToBrメソッドで改行コード混ざった場合正しく変換されること() {
		assertThat(HtmlUtil.lineBreakToBr("\r\n\r\r\n\n"), is("<br><br><br><br>"));
	}

	@Test
	public void blankToNbspメソッドで半角スペースが正しく変換されること() {
		assertThat(HtmlUtil.blankToNbsp("  "), is(" &nbsp;"));
	}

	@Test
	public void blankToNbspメソッドで複数行の場合に半角スペースが正しく変換されること() {
		assertThat(HtmlUtil.blankToNbsp("  \n  "), is(" &nbsp;\n &nbsp;"));
	}

	@Test
	public void blankToNbspメソッドで文字列混在の場合に半角スペースが正しく変換されること() {
		assertThat(HtmlUtil.blankToNbsp("  \n  あいうえ テスト  テスト"), is(" &nbsp;\n &nbsp;あいうえ テスト &nbsp;テスト"));
	}
}
