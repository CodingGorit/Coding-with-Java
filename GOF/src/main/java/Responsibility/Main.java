package Responsibility;

/**
 * @Author Gorit
 * @Date 2021/11/15
 **/
public class Main {
    public static void main(String[] args) {
        Support alice = new NotSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charlie = new SpecilSupport("Charlie", 429);
        Support diana = new LimitSupport("Diana", 200);
        Support elmo = new OddSupport("elmo");
        Support fred = new LimitSupport("fred", 300);
        // 形成责任链
        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
        for (int i = 0; i < 500; i += 33) {
            alice.support(new Trouble(i));
        }
    }
}
