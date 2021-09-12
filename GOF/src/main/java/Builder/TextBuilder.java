package Builder;

/**
 * @Author Gorit
 * @Date 2021/9/12
 * 使用纯文本编写文档
 **/
public class TextBuilder extends Builder{
    private StringBuffer buffer = new StringBuffer();       // 文档内容保存在该字段中
    public void makeTtile(String title) {
        buffer.append("============================="); // 装饰线
        buffer.append("[" + title + "]\n");
        buffer.append("\n");
    }

    public void makeString(String str) {            // 纯文本字符串
        buffer.append('■' + str + '\n');
        buffer.append('\n');
    }

    public void makeTimes(String[] items) {
        for (int i = 0; i < items.length; i++) {
            buffer.append("  '"+ items[i] + "\n");
        }
        buffer.append("\n");
    }

    public void close() {
        buffer.append("=============================");
    }

    public String getResult() {                     // 编辑完成的文档
        return buffer.toString();                   // 将 StringBuffer 转换成 String
    }
}
