package Commad.drawer;

import Commad.command.Command;

import java.awt.*;

/**
 * @Author Gorit
 * @Date 2021/11/28
 * 实现绘制一个点的功能
 **/
public class DrawPointCommand implements Command {
    // 绘制的对象
    protected Drawable drawable;
    // 绘制位置
    private Point position;

    public DrawPointCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    public void execute() {
        drawable.draw(position.x, position.y);
    }
}
