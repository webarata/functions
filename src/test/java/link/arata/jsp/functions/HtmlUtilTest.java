package link.arata.jsp.functions;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class HtmlUtilTest {
	@Test
	public void escapeメソッドの値が変わらないこと() {
		assertThat(HtmlUtil.escape("あいうえお"), is("あいうえお"));
	}

	@Test
	public void escapeメソッドでltがエスケープされること() {
		assertThat(HtmlUtil.escape("<"), is("&lt;"));
	}

	@Test
	public void escapeメソッドで複数のltがエスケープされること() {
		assertThat(HtmlUtil.escape("<<"), is("&lt;&lt;"));
	}

	@Test
	public void escapeメソッドでgtがエスケープされること() {
		assertThat(HtmlUtil.escape(">"), is("&gt;"));
	}

	@Test
	public void escapeメソッドで複数のgtがエスケープされること() {
		assertThat(HtmlUtil.escape(">>"), is("&gt;&gt;"));
	}

	@Test
	public void escapeメソッドでダブルクォートがエスケープされること() {
		assertThat(HtmlUtil.escape("\""), is("&quot;"));
	}

	@Test
	public void escapeメソッドで複数のダブルクォートがエスケープされること() {
		assertThat(HtmlUtil.escape("\"\""), is("&quot;&quot;"));
	}

	@Test
	public void escapeメソッドでアンドがエスケープされること() {
		assertThat(HtmlUtil.escape("&"), is("&amp;"));
	}

	@Test
	public void escapeメソッドで服薄のアンドがエスケープされること() {
		assertThat(HtmlUtil.escape("&&"), is("&amp;&amp;"));
	}

	@Test
	public void escapeメソッドで複数の文字列が正しくエスケープされること() {
		assertThat(HtmlUtil.escape("<>\"&"), is("&lt;&gt;&quot;&amp;"));
	}

	@Test
	public void escapeメソッドで通常の文字列も含んだ() {
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

	@Test
	public void urlToHrefメソッドでHTTPのURLが正しくアンカーに変換されること() {
		assertThat(HtmlUtil.urlToHref("http://hoge.com"), is("<a href=\"http://hoge.com\">http://hoge.com</a>"));
	}

	@Test
	public void urlToHrefメソッドでHTTPSのURLが正しくアンカーに変換されること() {
		assertThat(HtmlUtil.urlToHref("https://hoge.com"), is("<a href=\"https://hoge.com\">https://hoge.com</a>"));
	}

	@Test
	public void urlToHrefメソッドで複数のHTTPのURLが正しくアンカーに変換されること() {
		assertThat(HtmlUtil.urlToHref("http://hoge.comあいうえおhttp://foo.com"), is(
				"<a href=\"http://hoge.com\">http://hoge.com</a>あいうえお<a href=\"http://foo.com\">http://foo.com</a>"));
	}

}
