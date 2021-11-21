package Mediator;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @Author Gorit
 * @Date 2021/11/21
 **/
public class ColleagueRadioBox extends Checkbox implements ItemListener,Colleague {
    private Mediator mediator;

    public ColleagueRadioBox(String label, CheckboxGroup group, boolean state) {
        super(label, group, state);
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }

    public void itemStateChanged(ItemEvent e) {
        mediator.colleagueChanged();
    }
}
