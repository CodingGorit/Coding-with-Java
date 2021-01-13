package TemplateMethod;

/**
 * 子类实现了父类中的方法
 */
public class CharDisplay extends AbstractDisplay{
    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    public void open() {
        System.out.print("<<");
    }

    public void print() {
        System.out.print(ch);
    }

    public void close() {
        System.out.println(">>");
    }
}
