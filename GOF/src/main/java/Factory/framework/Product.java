package Factory.framework;

/**
 * 声明产品的类，仅声明 use 方法，方法的实现交给子类负责
 * 定义产品 ”任意是可以 use 的“
 */
public abstract class Product {
    public abstract void use();
}
