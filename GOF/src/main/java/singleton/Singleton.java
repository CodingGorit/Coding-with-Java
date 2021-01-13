package singleton;

/**
 * 单例模式的实现  （饿汉式）
 */
public class Singleton {
    private static Singleton singleton = new Singleton();
    // 禁止从外部调用构造函数，为了保证只生成一个实例，就必须这么做
    // 防止使用 new 关键字，对构造方法设置 private
    private Singleton () {
        System.out.println("生成一个实例");
    }
    // 返回实例的 static 方法
    public static Singleton getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println("Begin...");
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        if (s1 == s2) {
            System.out.println("s1 和 s2 是相同的实例");
        } else {
            System.out.println("s1 和 s2 不是相同的实例");
        }
        System.out.println("End...");
    }
}
