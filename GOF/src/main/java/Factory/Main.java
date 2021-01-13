package Factory;

import Factory.framework.Factory;
import Factory.framework.Product;
import Factory.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("小明");
        Product card2 = factory.create("小张");
        card1.use();
        card2.use();
    }
}
