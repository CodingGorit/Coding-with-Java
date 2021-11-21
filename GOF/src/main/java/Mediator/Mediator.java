package Mediator;

/**
 * @Author Gorit
 * @Date 2021/11/21
 * 仲裁者接口
 **/
public interface Mediator {
    public abstract void createColleagues();    // 生成 Mediator 要管理的成员
    public abstract void colleagueChanged();    // 该方法会被各个 Colleague 组员调用。它的作用是让组员可以向仲裁者汇报
}
