package State;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author Gorit
 * @Date 2021/11/26
 * 设置背景色
 * 设置布局管理器
 * 设置控件
 * 设置监听器（Listener）
 **/
public class SafeFrame extends Frame implements ActionListener, Context {
    private TextField textClock = new TextField(60);    // 显示当前时间
    private TextArea textScreen = new TextArea(10, 60);     // 显示警报中心记录
    private Button buttonUse = new Button("使用金库");
    private Button buttonAlert = new Button("按下警铃");
    private Button buttonPhone = new Button("正常通话");
    private Button buttonExit = new Button("结束");

    private State state = DayState.getInstance();   // 当前状态

    public SafeFrame(String title) throws HeadlessException {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        // 配置 textClock
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);
        // 配置 text Screen
        add(textScreen, BorderLayout.CENTER);
        // 为界面添加按钮
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlert);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        // 配置界面
        add(panel, BorderLayout.SOUTH);
        // 显示
        pack();
        setVisible(true);
        // 设置监听器
        buttonUse.addActionListener(this);
        buttonAlert.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    public void setClock(int hour) {
        String clockString = "现在时间是:";
        if (hour < 10) {
            clockString += "0" + hour + ":00";
        } else {
            clockString += hour + ":00";
        }
        System.out.println(clockString);
        textClock.setText(clockString);
        state.doClock(this, hour);
    }
    // 联系警报中心
    public void callSecurityCenter(String msg) {
        textScreen.append("call!!!" + msg + "\n");
    }
    // 警告中心留下记录
    public void recordLog(String msg) {
        textScreen.append("record...." + msg + "\n");
    }
    // 改变状态
    public void changeState(State state) {
        System.out.println("从" + this.state + "状态变为" + state + "状态");
        this.state = state;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        if (e.getSource() == buttonUse) {
            state.doUse(this);  // 金库使用按钮
        } else if (e.getSource() == buttonAlert) {
            state.doAlram(this);    // 按下报警按钮
        } else if (e.getSource() == buttonPhone) {
            state.doPhone(this);    // 按下打电话
        } else if (e.getSource() == buttonExit) {
            System.exit(0);     // 退出
        } else {
            System.out.println("?");
        }
    }
}
