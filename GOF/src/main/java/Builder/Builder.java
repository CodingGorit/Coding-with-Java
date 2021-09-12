package Builder;

/**
 * @Author Gorit
 * @Date 2021/9/12
 *
 * 声明编写文档的方法的抽象类
 * 1. makeTitle 编写标题
 * 2. makeString 编写普通文本
 * 3. makeTimes  条目
 * 4. close 完成文档编写的方法
 */
public abstract class Builder {
    public abstract void makeTtile(String title);
    public abstract void makeString(String str);
    public abstract void makeTimes(String[] items);
    public abstract void close();
}