package Decorator;

/**
 * @Author Gorit
 * @Date 2021/10/17
 * 字符串左右加修饰，SliderBorder 类中可以指定边框字符，FullSlider 类中边框字符是固定的
 **/
public class FullBorder extends Border {

    public FullBorder(Display display) {
        super(display);
    }
    public int getColumns() {           // 字符数为被装饰的字符数加上两侧边框的字符数
        return 1 + display.getColumns() + 1;
    }
    public int getRows() {              // 行为被装饰物的行数加上上下边框的行数
        return 1 + display.getRows() +1;
    }

    public String getRowText(int row) { // 指定的那一行字符串
        if (row == 0) {                 // 下边框
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else if (row == display.getRows() + 1) { // 上边框
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else {                        // 其他边框
            return "|" + display.getRowText(row - 1) + "|";
        }
    }
    // 生成一个重复 count 次字符 ch 的字符串
    private String makeLine(char ch, int count) {
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            bf.append(ch);
        }
        return bf.toString();
    }
}
