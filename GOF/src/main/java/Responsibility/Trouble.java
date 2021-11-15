package Responsibility;

/**
 * @Author Gorit
 * @Date 2021年11月9日
 * Border 和 Display 具有相同的属性和方法
 * display 代表被装饰物，也有可能是其他装饰物的边框
 **/
public class Trouble {

    private int number;     // 问题编号

    public Trouble(int number) {    // 生成问题
        this.number = number;
    }

    public int getNumber() {      // 获取问题编号
        return number;
    }

    public String toString() {      // 代表问题字符串
        return "{Trouble " + number + "}";
    }
}