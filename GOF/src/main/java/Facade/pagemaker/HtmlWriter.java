package Facade.pagemaker;

import java.io.IOException;
import java.io.Writer;

/**
 * @Author Gorit
 * @Date 2021/11/20
 * 该类用于编写简单的 web 页面
 **/
public class HtmlWriter {
    private Writer writer;  // 生成 HtmlWriter 类实例时，赋予 Writer，使用 Writer 输出 HTML

    public HtmlWriter(Writer writer) {
        this.writer = writer;
    }

    // title 表示 HTML 的标题
    public void title(String title) throws IOException {
        writer.write("<html>");
        writer.write("  <head>\n");
        writer.write("      <title>" + title + "</title>\n");
        writer.write("  </head>");
        writer.write("<body>\n");
        writer.write("<h1>" + title + "</h1>\n");
    }

    // 输出段落
    public void paragraph(String msg) throws IOException {
        writer.write("<p>" + msg + "</p>\n");
    }

    // 输出超链接
    public void link(String href, String caption) throws IOException {
        paragraph("<a href=\"" + href + "\">" + caption + "</a>\n");
    }

    // 输出邮件地址
    public void mailto(String mailaddr, String username) throws IOException {
        link("mailto:" + mailaddr, username);
    }

    // 结束输出 HTML
    public void close() throws IOException {
        writer.write("</body>\n");
        writer.write("</html>");
        writer.close();
    }

}
