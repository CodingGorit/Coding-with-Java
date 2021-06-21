package Factory.idcard;

import Factory.framework.Factory;
import Factory.framework.Product;

import java.util.*;

/**
 * 实现了
 *  1. createProduct() 通过 IDCard
 *  2. reigisterProduct() 方法
 */
public class IDCardFactory extends Factory {
    private List owners = new ArrayList();
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    protected void registerProduct(Product p) {
        owners.add(((IDCard)p).getOwner());

    }

    public List getOwners() {
        return owners;
    }
}
