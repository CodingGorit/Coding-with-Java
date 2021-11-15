package Responsibility;

/**
 * @Author Gorit
 * @Date 2021/11/15
 * Support 的子类
 * 永不解决的类
 **/
public class NotSupport extends Support {
    public NotSupport(String name) {
        super(name);
    }

    protected boolean resolve(Trouble trouble) {    // 永远不解决
        return false;
    }
}
