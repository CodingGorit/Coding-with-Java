package Factory.framework;

/**
 * 我们使用 Template Method 模式
 * 声明：
 *  1. 用于生成产品的 createProduct 抽象方法
 *  2. 用于注册产品的 registerProduct 抽象方法
 *  具体实现内容根据 Factory Method 适用的场景不同而不同，具体生成示例的时候一定会使用到 Template Method 模式
 */
public abstract class Factory {
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    protected abstract void registerProduct(Product p);

    protected abstract Product createProduct(String owner);
}
