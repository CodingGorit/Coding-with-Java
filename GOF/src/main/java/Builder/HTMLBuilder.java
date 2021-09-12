package Builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @Author Gorit
 * @Date 2021/9/12
 * 使用 HTML 编写文档
 **/

public class HTMLBuilder extends Builder{
    private String filename;
    private PrintWriter writer;

    public void makeTtile(String title) {
        filename = title + ".html";
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println("<html><head><title>" + title + "</title></head><body>");
        writer.println("<h1>" + title + "</h1>");// 输出标题
    }

    public void makeString(String str) {                // HTML 中文档的字符串
        writer.println("<p>" + str + "</p>");           // 使用 <p> 标签输出
    }

    public void makeTimes(String[] items) {             // 使用 ul 和  li 标签输出
        writer.println("<ul>");
        for (int i = 0; i < items.length; i++) {
            writer.println("<li>" + items[i] + "</li>");
        }
        writer.println("</ul>");
    }

    public void close() {                               // 文档完成
        writer.println("</body></html>");
        writer.close();
    }

    public String getResult () {                        // 编写完成的文档
        return filename;                                // 返回文件名
    }
}