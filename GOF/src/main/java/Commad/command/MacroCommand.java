package Commad.command;

import java.util.Iterator;
import java.util.Stack;

/**
 * @Author Gorit
 * @Date 2021/11/28
 **/
public class MacroCommand implements Command {
    // 命令的集合
    private Stack commands = new Stack();
    public void execute() {
        Iterator it = commands.iterator();
        while (it.hasNext()) {
            ((Command)it.next()).execute();
        }
    }
    // 添加命令
    public void append(Command cmd) {
        if (cmd != this) {
            commands.push(cmd);
        }
    }
    // 撤销最后一个命令
    public void undo() {
        if (!commands.empty()) {
            commands.pop();
        }
    }
    // 删除所有命令
    public void clear() {
        commands.clear();
    }
}
