package Observer;

/**
 * @Author Gorit
 * @Date 2021/11/22
 * generator执行 —> excute —> 通知 notifyObserver —> update（打印）
 **/
public class Main {
    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        Observer observer1 = new DigitObservers();  // 创建观察者
        Observer observer2 = new GraphObserver();
        generator.addObserver(observer1);   // 注册观察者
        generator.addObserver(observer2);
        generator.execute();
    }
}
