package Visitor;

/**
 * @Author Gorit
 * @Date 2021/10/24
 * 表示访问者的抽象类，依赖它所访问的数据结构（File 类 和 Directory 类）
 **/
public abstract class Visitor {
    // 访问文件的类
    public abstract void visit(File file);
    // 访问目录的类
    public abstract void visit(Directory director);
}
