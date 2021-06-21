package Adapter.weituo;

public class PrintBanner extends Print{
    private Banner banner;

    public PrintBanner(String s) {
        this.banner = new Banner(s);
    }

    public void printWeak() {
        banner.showWithParen();
    }

    public void printStrong() {
        banner.showWithAster();
    }
}
