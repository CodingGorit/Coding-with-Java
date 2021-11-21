package Mediator;

import java.awt.*;

/**
 * @Author Gorit
 * @Date 2021/11/21
 * 与 LoginFrame 协作
 **/
public class ColleagueButton extends Button implements Colleague {
    private Mediator mediator;

    public ColleagueButton(String caption) {
        super(caption);
    }
    public void setMediator(Mediator mediator) {    // 保存 Mediator
        this.mediator = mediator;
    }

    public void setColleagueEnabled(boolean enabled) {     // Mediator 下达启用， 禁用指示
        setEnabled(enabled);
    }
}
