package Interpreter;

import java.text.ParseException;

/**
 * @Author Gorit
 * @Date 2021/11/29
 * 展示迷你语言的语法描述（BNF）
 * <program> ::= program <command list>
 **/
public class ProgramNode extends Node {
    private Node commandListNode;
    // 根据标记导出语法树
    public void parse(Context context) throws Interpreter.ParseException {
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }
    public String toString() {
        return "[program " + commandListNode + "]";
    }
}
