package Mediator;

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/**
 * @Author Gorit
 * @Date 2021/11/21
 **/
public class ColleagueTextField extends TextField implements TextListener, Colleague {
    private Mediator mediator;
    public ColleagueTextField(String text, int columns) {   // 构造函数
        super(text, columns);
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void setColleagueEnabled(boolean enabled) {      // Mediator 下达启用，禁用指令
        setEnabled(enabled);
        setBackground(enabled ? Color.WHITE : Color.LIGHT_GRAY);
    }

    public void textValueChanged(TextEvent e) {     // 当文字发生变化时，通知 Mediator
        mediator.colleagueChanged();
    }
}
