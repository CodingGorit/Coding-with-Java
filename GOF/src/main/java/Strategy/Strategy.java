package Strategy;

/**
 * @Author Gorit
 * @Date 2021/9/12
 *  定义了猜拳策略的抽象方法的接口
 **/
public interface Strategy {
    //    获取下一局要出的手势
    public abstract Hand nextHand();
    //    学习 ”上一局的手势是否获胜了“，获胜则调用 study(true)，stury(false)，为下一次的 nextHand 做出依据
    public abstract void study(boolean win);

}
