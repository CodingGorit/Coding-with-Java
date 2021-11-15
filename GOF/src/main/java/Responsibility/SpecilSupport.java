package Responsibility;

/**
 * @Author Gorit
 * @Date 2021/11/15
 * 只解决指定编号问题
 **/
public class SpecilSupport extends Support {
    private int number;

    public SpecilSupport(String name, int number) {     // 只能解决指定编号的问题
        super(name);
        this.number = number;
    }

    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() == number) {
            return true;
        }
        return false;
    }
}
