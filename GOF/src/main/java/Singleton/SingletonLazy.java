package Singleton;

/**
 * 懒汉式单例模式（线程不安全）
 */
public class SingletonLazy {
    private static SingletonLazy singletonLazy = null;
    private SingletonLazy() {
        System.out.println("实例化了");
    }
    public static SingletonLazy getInstance() {
        if (singletonLazy == null) {
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}
