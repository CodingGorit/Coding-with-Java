package Adapter.extend;

public class Main {
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printStrong();
        p.printWeak();
    }
}
