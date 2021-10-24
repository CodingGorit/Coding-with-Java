package Decorator;

/**
 * @Author Gorit
 * @Date 2021/10/17
 * Border 和 Display 具有相同的属性和方法
 * display 代表被装饰物，也有可能是其他装饰物的边框
 **/
public abstract class Border extends Display {
    protected Display display;      // 表示被装饰物
    protected Border(Display display) {     // 在生成实例时通过参数指定被装饰物
        this.display = display;
    }
}
