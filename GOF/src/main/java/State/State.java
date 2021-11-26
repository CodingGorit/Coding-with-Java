package State;

/**
 * @Author Gorit
 * @Date 2021/11/26
 * 设置时间
 * 使用金库
 * 按下警铃
 * 正常通话
 **/
public interface State {
    public abstract void doClock(Context context, int hour);    // 设置时间
    public abstract void doUse(Context context);    // 使用金库
    public abstract void doAlram(Context context);  // 按下警铃
    public abstract void doPhone(Context context);  // 正常通话
}
