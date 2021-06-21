package TemplateMethod;

public class StringDisplay extends AbstractDisplay{
    private String string;
    private int width;

    public StringDisplay(String string) {
        this.string = string;
        this.width = string.getBytes().length; // 以字节为单位计算出字符串的长度
    }

    public void open() {
        printLine();
    }

    public void print() {
        System.out.println("|"+string+"|");
    }

    public void close() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i=0;i<width;i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
