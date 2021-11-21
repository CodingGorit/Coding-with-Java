package Mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author Gorit
 * @Date 2021/11/21
 * 仲裁者代码
 **/
public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueRadioBox checkGuest;
    private ColleagueRadioBox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    /**
     * 设置背景色
     * 设置布局管理器 （4行 2列）
     * 调用 createColleagues 方法生成 Colleagues
     * 设置 Colleague
     * 设置初始状态
     * 显示
     * @param title
     */
    public LoginFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        // 使用布局管理器生成 4x2的窗格
        setLayout(new GridLayout(4, 2));
        // 生成各个 Colleague
        createColleagues();
        // 配置
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);
        // 设置初始化应用 禁用状态
        colleagueChanged();
        // 显示
        pack();
        show();
    }
    // 生成各个 Colleague
    public void createColleagues() {
        // 生成
        CheckboxGroup q = new CheckboxGroup();
        checkGuest = new ColleagueRadioBox("Guest", q, true);
        checkLogin = new ColleagueRadioBox("Login", q, false);
        textUser = new ColleagueTextField("", 16);
        textPass = new ColleagueTextField("", 16);
        textPass.setEchoChar('*');
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");
        // 设置 Mediator
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);
        // 设置 Listener
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);

    }

    // 接收来自 Colleague 的通知然后判断各 Colleague 的启用 / 禁用。 简单的登录框逻辑转换
    public void colleagueChanged() {
        if (checkGuest.getState()) {        // Guest mode
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        } else {                            // Login mode
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }
    }

    // 当 textUser 或 textPass 文本输入框中的文字发生变化时
    // 判断各 Colleague 的启用 | 禁用
    private void userpassChanged() {
        if (textUser.getText().length() > 0) {
            textPass.setColleagueEnabled(true);
            if (textPass.getText().length() > 0) {
                buttonOk.setColleagueEnabled(true);
            } else {
                buttonOk.setColleagueEnabled(false);
            }
        } else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}
