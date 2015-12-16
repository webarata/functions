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
    public void escapeメソッドでgtがエスケープされることのテスト() {
        assertThat(HtmlUtil.escape(">"), is("&gt;"));
    }

    @Test
    public void escapeメソッドでダブルクォートがエスケープされることのテスト() {
        assertThat(HtmlUtil.escape("\""), is("&quot;"));
    }

    @Test
    public void escapeメソッドでアンドがエスケープされることのテスト() {
        assertThat(HtmlUtil.escape("&"), is("&amp;"));
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
    public void newLineToBrメソッドで￥r￥nが正しく変換されること() {
        assertThat(HtmlUtil.newLineToBr("\r\n"), is("<br>"));
    }
}
