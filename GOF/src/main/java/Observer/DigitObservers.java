package Observer;

/**
 * @Author Gorit
 * @Date 2021/11/22
 * 以数字形式展现观察到的值
 **/
public class DigitObservers implements Observer{
    public void update(NumberGenerator generator) {
        System.out.println(generator.getNumber());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
