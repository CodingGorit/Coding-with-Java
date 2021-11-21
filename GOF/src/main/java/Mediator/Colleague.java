package Mediator;

/**
 * @Author Gorit
 * @Date 2021/11/21
 * 组员向仲裁者报告的接口
 **/
public interface Colleague {
    /**
     * LoginFrame 类，会实现 Mediator 接口，首先调用 setMediator 方法，该方法是通知组员
     * “我是仲裁者，有事情报告我”
     * @param mediator
     */
    public abstract void setMediator(Mediator mediator);
    public abstract void setColleagueEnabled(boolean enabled);  // 告知组员仲裁者下达的指示
}
