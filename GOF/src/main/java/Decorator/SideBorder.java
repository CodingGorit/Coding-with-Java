package Decorator;

import javafx.geometry.Side;

/**
 * @Author Gorit
 * @Date 2021/10/17
 * 具体的装饰边框
 **/
public class SideBorder extends Border {

    private char borderChar;            // 表示装饰边框的字符
    public SideBorder(Display display, char ch) {
        super(display);
        this.borderChar = ch;           // 具体的边框
    }

    public int getColumns() {       // 字符数为字符串字符数列加上两侧边框字符数
        return 1 + display.getColumns() + 1;
    }

    public int getRows() {
        return display.getRows();    // 行数，即被修饰的行数
    }

    public String getRowText(int row) {     // 指定的那一行的字符串为被装饰物字符串， 加上两侧的边框字符
        return borderChar + display.getRowText(row) + borderChar;
    }
}
