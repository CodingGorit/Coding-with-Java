package Responsibility;

/**
 * @Author Gorit
 * @Date 2021/11/15
 * 解决奇数编号问题
 **/
public class OddSupport extends Support {
    public OddSupport(String name) {
        super(name);
    }

    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() % 2 == 0) {
            return true;
        }
        return false;
    }
}
