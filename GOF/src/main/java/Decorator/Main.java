package Decorator;

/**
 * @Author Gorit
 * @Date 2021/10/17
 **/
public class Main {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("Hello , World"); // 被修饰物
        Display b2 = new SideBorder(b1, '#');
        Display b3 = new FullBorder(b2);
        b1.show();
        b2.show();
        b3.show();
        Display d4 =
                    new SideBorder(
                            new FullBorder(
                                    new FullBorder(
                                            new SideBorder(
                                                    new FullBorder(
                                                            new StringDisplay("你好，世界")
                                                    ),
                                                    '*'
                                            )
                                    )
                            ),
                            '/'
                    );
        d4.show();
    }
}
