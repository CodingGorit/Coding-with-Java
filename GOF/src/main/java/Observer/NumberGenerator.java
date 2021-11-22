package Observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author Gorit
 * @Date 2021/11/22
 * 生成数值的抽象类
 **/
public abstract class NumberGenerator {
    private ArrayList observers = new ArrayList();  // 保存 Observer的
    public void addObserver(Observer observer) {    // 注册 Observer
        observers.add(observer);
    }
    public void deleteObserver(Observer observer) {     // 删除 Observer
        observers.remove(observer);
    }
    public void notifyObservers() {                 // 通知 Observer，我的数值发生变化了，要修改数据
        Iterator it = observers.iterator();
        while (it.hasNext()) {
            Observer o = (Observer) it.next();
            o.update(this);
        }
    }
    public abstract int getNumber();               // 获取数值
    public abstract void execute();                 // 生成数值
}
