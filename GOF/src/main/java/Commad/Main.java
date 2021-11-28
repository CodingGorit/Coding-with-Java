package Commad;

import Commad.command.Command;
import Commad.command.MacroCommand;
import Commad.drawer.DrawCanvas;
import Commad.drawer.DrawPointCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @Author Gorit
 * @Date 2021/11/28
 **/
public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {
    // 绘制历史记录
    private MacroCommand history = new MacroCommand();
    // 绘制区域
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 删除按钮
    private JButton clearButton = new JButton("clear");
    // 撤销按钮
    private JButton undoButton = new JButton("undo");

    public Main(String title) throws HeadlessException {
        super(title);
        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(this);
        undoButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
//        buttonBox.add(undoButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    // ActionListener 中的方法
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            history.clear();
            canvas.repaint();
        }
        if (e.getSource() == undoButton) {
            history.undo();
            canvas.repaint();
        }
    }
    // MouseMotionListener 接口中的方法
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawPointCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    public void mouseMoved(MouseEvent e) {}

    // WindowListener 中的方法
    public void windowOpened(WindowEvent e) {

    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowClosed(WindowEvent e) {}

    public void windowIconified(WindowEvent e) {}

    public void windowDeiconified(WindowEvent e) {}

    public void windowActivated(WindowEvent e) {}

    public void windowDeactivated(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Simple");
    }
}
