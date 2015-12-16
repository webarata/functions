package link.arata.jsp.functions;

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
}
