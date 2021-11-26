package State;

/**
 * @Author Gorit
 * @Date 2021/11/26
 **/
public class DayState implements State{
    private static DayState singleton = new DayState();
    private DayState() {}
    // 单例模式获取唯一实例
    public static State getInstance() {
        return singleton;
    }
    public void doClock(Context context, int hour) {
        if (hour < 9 || hour >= 17) {
            context.changeState(NightState.getInstance());
        }
    }

    public void doUse(Context context) {
        context.recordLog("使用金库（白天)");
    }

    public void doAlram(Context context) {
        context.callSecurityCenter("按下警铃（白天）");
    }

    public void doPhone(Context context) {
        context.callSecurityCenter("正常通话（白天）");
    }

    public String toString() {
        return "[白天]";
    }
}
