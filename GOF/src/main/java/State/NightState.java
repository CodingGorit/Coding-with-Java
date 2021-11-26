package State;

/**
 * @Author Gorit
 * @Date 2021/11/26
 **/
public class NightState implements State {
    private static NightState singleton = new NightState();
    private NightState() {}
    // 单例模式获取唯一实例
    public static State getInstance() {
        return singleton;
    }
    public void doClock(Context context, int hour) {
        if (hour <= 9 && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }

    public void doUse(Context context) {
        context.callSecurityCenter("紧急！晚上使用金库！");
    }

    public void doAlram(Context context) {
        context.callSecurityCenter("按下警铃（晚上）");
    }

    public void doPhone(Context context) {
        context.recordLog("晚上通话录音");
    }

    public String toString() {
        return "[夜晚]";
    }
}
