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
}
