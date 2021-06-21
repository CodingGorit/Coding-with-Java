package Prototype.framework;
import java.util.*;

/**
 * 使用 product 接口复制实例
 */
public class Manager {
    private HashMap showcase = new HashMap();
    public void register(String name, Product proto) {
        showcase.put(name,proto);
    }

    public Product create(String protoname) {
        Product p = (Product) showcase.get(protoname);
        return p.createClone();
    }
}
