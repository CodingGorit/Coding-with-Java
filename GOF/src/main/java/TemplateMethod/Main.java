package TemplateMethod;

public class Main {
    public static void main(String[] args) {
        CharDisplay cd  = new CharDisplay('H');
        cd.display();

        StringDisplay sd = new StringDisplay("Hello World");
        sd.display();
    }
}
