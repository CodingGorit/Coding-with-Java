package Responsibility;


/**
 * @Author Gorit
 * @Date 2021/11/15
 * 用来解决问题的抽象类，它是职责链上的对象
 * next     字段中指定了要推卸给的对象，可以通过 setNext 方法设定该对象
 * resolve  该方法需要子类去实现的抽象方法。 resolve 返回 true 则表示被处理，反之
 * support  该方法会调用 resolve 方法，如果 resolve 方法返回 false，则 support 方法会将问题转交给下一个对象
 **/
public abstract class Support {
    private String name;    // 解决问题实例的名字
    private Support next;    // 要推卸给的对象, 类似于链表结构

    public Support(String name) {   // 生成问题的实例
        this.name = name;
    }

    public Support setNext(Support next) {      // 设置要推卸给的对象, 链式调用
        this.next = next;
        return next;
    }

    public final void support(Trouble trouble) {    // 解决问题的步骤
        if (resolve(trouble)) {     //      属于 Template Method
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    @Override
    public String toString() {      // 显示字符串
        return "{" + name +"}";
    }

    protected abstract boolean resolve(Trouble trouble);    // 解决问题的方法
    protected void done(Trouble trouble) {      // 解决
        System.out.println(trouble + " is resolved by " + this + ".");
    }
    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resoled.");
    }
}
