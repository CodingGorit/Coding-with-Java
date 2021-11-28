package Interpreter;


/**
 * @Author Gorit
 * @Date 2021/11/29
 * 表示语法树各个节点中最底层的类
 **/
public abstract class Node {
    public abstract void parse(Context context) throws ParseException;
}
