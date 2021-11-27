package Proxy;

/**
 * @Author Gorit
 * @Date 2021/11/27
 * 表示 ”本人“ 的类
 **/
public class Printer implements Printerable {
    private String name;

    /**
     * 在构造函数中，我们让 “本人” 干一些重活
     */
    public Printer() {
        heavyJob("Printer 实例生成中");
    }

    public Printer(String name) {
        this.name = name;
        heavyJob("Printer 实例生成中 (" + name + ")");
    }

    public void setPrinterName(String name) {
        this.name = name;
    }

    public String getPrinterName() {            // 获取打印机的名字
        return name;
    }

    public void print(String string) {          // 显示带打印机名字的文字
        System.out.println("=== " + name + " ===");
        System.out.println(string);
    }

    private void heavyJob(String msg) {         // 干 5 秒 重活的方法，用 ”.“ 显示进度
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }
        System.out.println("结束");
    }
}
