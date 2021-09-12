package Builder;

/**
 * @Author Gorit
 * @Date 2021/9/12
 * 使用 Builder 类中声明的方法来编写文档
 **/
public class Director {
    private Builder builder;
    public Director (Builder builder) {  // 接受的是 Builder 类的子类
        this.builder = builder;          // 将子类保存至 builder 字段中
    }

    public void construct() { // 编写文档
        builder.makeTtile("Greeting"); // 标题
        builder.makeString("从早上至下午");  // 字符串
        builder.makeTimes(new String[] {   // 条目
                "早上好",
                "下午好"
        });
        builder.makeString("晚上");
        builder.makeTimes(new String[] {
                "晚上好",
                "晚安",
                "再见"
        });
        builder.close();
    }

}
