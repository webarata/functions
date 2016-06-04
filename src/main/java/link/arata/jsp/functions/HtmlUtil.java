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
        value = value.replace("&", "&amp;");
        value = value.replace("<", "&lt;");
        value = value.replace(">", "&gt;");
        value = value.replace("\"", "&quot;");

        return value;
    }

    /**
     * 改行コードを&lt;br&gt;に変換する。
     * 
     * @param value
     *            変換する文字列
     * @return 変換後の文字列
     */
    public static String lineBreakToBr(String value) {
        value = value.replace("\r\n", "<br>");
        value = value.replace("\n", "<br>");
        value = value.replace("\r", "<br>");

        return value;
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
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == ' ') {
                if (first) {
                    sb.append(' ');
                    first = false;
                } else {
                    sb.append("&nbsp;");
                }
            } else {
                first = true;
                sb.append(value.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 文字列中のURLをHTMLのアンカーに変換する
     * 
     * @param value
     *            変換する文字列
     * @return 変換後の文字列
     */
    public static String urlToHref(String value) {
        return value.replaceAll("http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?", "<a href=\"$0\">$0</a>");
    }
}
