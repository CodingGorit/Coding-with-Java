package Proxy;

/**
 * @Author Gorit
 * @Date 2021/11/27
 **/
public class Main {
    public static void main(String[] args) {
        Printerable p = new PrinterProxy("Alice");
        System.out.println("现在的名字是 " + p.getPrinterName() + "。");
        p.setPrinterName("Bob");
        System.out.println("现在的名字是 " + p.getPrinterName() + "。");
        p.print("Hello World");
    }
}
