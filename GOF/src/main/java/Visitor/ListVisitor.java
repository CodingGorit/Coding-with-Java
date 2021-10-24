package Visitor;

import java.util.Iterator;

/**
 * @Author Gorit
 * @Date 2021/10/24
 * 功能：访问数据结构，并显示一览
 * 实现：visit(File) visit(Directory) 访问
 * 在 Visitor 模式中，visit 方法将处理集中在 ListVisitor
 **/
public class ListVisitor extends Visitor {
    private String currentDir = ""; // 当前访问文件夹的名字

    @Override
    public void visit(File file) {      // 在访问文件时调用
        System.out.println(currentDir + "/" + file);
    }

    /**
     * visit(File) 方法用来实现 “对 File 类的实例要进行的处理”
     * visit(Directory) 方法实现了 “对 Directory 类的实例进行的处理”
     * @param director
     */
    @Override
    public void visit(Directory director) {     // 在访问文件夹时调用
        System.out.println(currentDir + "/" + director);
        String saveDir = currentDir;
        currentDir = currentDir + "/" + director.getName();
        Iterator it = director.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            entry.accept(this);
        }
        currentDir = saveDir;
    }
}
