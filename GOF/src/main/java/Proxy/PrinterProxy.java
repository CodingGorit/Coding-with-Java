package Proxy;

/**
 * @Author Gorit
 * @Date 2021/11/27
 * Proxy 模式的核心
 * “代理人”的 角色的类
 **/
public class PrinterProxy implements Printerable{
    private String name;        // 名字
    private Printer real;       // 本人
    public PrinterProxy() {
    }

    public PrinterProxy(String name) {
        this.name = name;
    }

    public synchronized void setPrinterName (String name) {     // 设置名字
        if (real != null) {
            real.setPrinterName(name);                          // 同时设置本人的名字
        }
        this.name = name;
    }

    public String getPrinterName() {                            // 获取名字
        return name;
    }

    public void print(String string) {                         // 本人会被 this 调用，只有执行了该方法，PrinterProxy 类才会生成 Printer 类的实例
        realize();
        real.print(string);
    }

    private void realize() {                                    // 生成本人
        if (real == null) {
            real = new Printer(name);
        }
    }
}
