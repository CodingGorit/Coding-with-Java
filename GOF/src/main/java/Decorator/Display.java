package Decorator;

/**
 * @Author Gorit
 * @Date 2021/10/17
 * @desc 用于显示多行字符串的抽象类
 *
 **/
public abstract class Display {
    public abstract int getColumns();   // 获取横向字符数
    public abstract int getRows();  // 获取纵向行数 Template Method
    public abstract String getRowText(int row);  // 获取第 row 行字符串 Template Method

    public final void show () {     // 全部显示
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
