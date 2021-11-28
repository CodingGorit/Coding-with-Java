package Commad.drawer;

import Commad.command.MacroCommand;

import java.awt.*;

/**
 * @Author Gorit
 * @Date 2021/11/28
 **/
public class DrawCanvas extends Canvas implements Drawable {
    // 颜色
    private Color color = Color.red;
    // 绘制的圆点半径
    private int radius = 6;
    // 命令的历史记录
    private MacroCommand history;
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }
    // 重新全部绘制
    public void paint(Graphics q) {
        history.execute();
    }
    // 绘制
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius,radius * 2, radius * 2);
    }
}
