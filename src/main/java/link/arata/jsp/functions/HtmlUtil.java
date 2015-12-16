package link.arata.jsp.functions;

public abstract class HtmlUtil {
    public static String escape(String value) {
        value = value.replace("&", "&amp;");
        value = value.replace("<", "&lt;");
        value = value.replace(">", "&gt;");
        value = value.replace("\"", "&quot;");

        return value;
    }
}
