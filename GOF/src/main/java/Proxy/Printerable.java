package Proxy;

/**
 * @Author Gorit
 * @Date 2021/11/27
 * 使 Printer 类 和 Printerable 具备一致性
 **/
public interface Printerable {
    public abstract void setPrinterName(String name);   // 设置打印机名字
    public abstract String getPrinterName();            // 获取打印机名字
    public abstract void print(String string);          // 显示文字（打印输出）
}
