package Decorator;

/**
 * @Author Gorit
 * @Date 2021/10/17
 * 代表核心的被装饰物
 **/
public class StringDisplay extends Display {
    private String string;      // 要显示的字符串

    public StringDisplay(String string) {       // 通过参数传入要显示的字符串
        this.string = string;
    }

    public int getColumns() {           // 获取字符数
        return string.getBytes().length;
    }

    public int getRows() {              // 默认只显示 1 行
        return 1;
    }

    public String getRowText(int row) {    // 仅当 row 为 0时，返回
        if (row == 0) {
            return string;
        } else  {
            return null;
        }
    }
}
