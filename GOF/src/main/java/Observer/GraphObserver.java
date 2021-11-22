package Observer;

/**
 * @Author Gorit
 * @Date 2021/11/22
 * 用 *** 的数量表示显示的数字
 **/
public class GraphObserver implements Observer{
    public void update(NumberGenerator generator) {
        System.out.println("GraphObserver:");
        int count = generator.getNumber();
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println("");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
