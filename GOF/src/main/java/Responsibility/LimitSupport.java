package Responsibility;

/**
 * @Author Gorit
 * @Date 2021/11/15
 * 解决编号小于 limit 的问题
 * resolve 方法在判断编号小于 limit 值之后，只是返回 true，但实际上这里应该是解决问题的代码
 **/
public class LimitSupport extends Support {
    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    protected boolean resolve(Trouble trouble) {    // 解决问题的方法
        if (trouble.getNumber() < limit) {
            return true;
        } else {
            return false;
        }
    }
}
