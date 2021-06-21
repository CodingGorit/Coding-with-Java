package Adapter.extend;

/**
 * 实际情况
 */
public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    // 括号
    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    public void showWithAster() {
        System.out.println("**" + string + "**");
    }


}
