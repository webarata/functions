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
     * @return 返還後の文字列
     */
    public static String newLineToBr(String value) {
        value = value.replace("\r\n", "<br>");
        value = value.replace("\n", "<br>");
        value = value.replace("\r", "<br>");

        return value;
    }
}
