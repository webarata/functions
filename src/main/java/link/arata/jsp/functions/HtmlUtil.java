package link.arata.jsp.functions;

/**
 * HTML操作関連のユーティリティークラス
 * 
 * @author arata
 * 
 */
public abstract class HtmlUtil {
    /**
     * 文字列をHTMLエスケープする
     * 
     * @param value
     *            エスケープする文字列
     * @return HTMLエスケープしたあとの文字列
     */
    public static String escape(String value) {
        return value.replace("&", "&amp;").replace("<", "&lt;")
                .replace(">", "&gt;").replace("\"", "&quot;")
                .replace("'", "&#39;");
    }

    /**
     * 改行コードを&lt;br&gt;に変換する。
     * 
     * @param value
     *            変換する文字列
     * @return 変換後の文字列
     */
    public static String lineBreakToBr(String value) {
        return value.replace("\r\n", "<br>").replace("\n", "<br>").replace("\r",
                "<br>");
    }

    /**
     * 半角スペースを&amp;nbsp;に変換する。<br>
     * ただし、連続する半角スペースの先頭は変換しない。（折り返しが効かなくなるため）
     * 
     * @param value
     *            変換する文字列
     * @return 変換後の文字列
     */
    public static String blankToNbsp(String value) {
        return value.chars()
                .mapToObj(ch -> Character.valueOf((char) ch).toString())
                .reduce("", (c1, c2) -> (c1.endsWith(" ") && c2.equals(" "))
                        ? c1 + "&nbsp;"
                        : c1 + c2);
    }

    /**
     * 文字列中のURLをHTMLのアンカーに変換する
     * 
     * @param value
     *            変換する文字列
     * @return 変換後の文字列
     */
    public static String urlToHref(String value) {
        return value.replaceAll(
                "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?",
                "<a href=\"$0\">$0</a>");
    }
}
