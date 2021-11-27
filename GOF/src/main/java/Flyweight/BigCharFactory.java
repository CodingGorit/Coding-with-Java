package Flyweight;

import java.util.HashMap;

/**
 * @Author Gorit
 * @Date 2021/11/26
 **/
public class BigCharFactory {
    // 管理已经生成的 BigChar 实例
    private HashMap pool = new HashMap(16);
    // Singleton 模式
    private static BigCharFactory singleton = new BigCharFactory();

    public BigCharFactory() {
    }
    // 获取唯一实例
    public static BigCharFactory getInstance() {
        return singleton;
    }
    // 生成（共享）BigChar 实例 （使用 synchronized 保证在多线程中原子性）
    public synchronized BigChar getBigChar(char charname) {
        BigChar br = (BigChar) pool.get("" + charname);
        if (br == null) {
            br = new BigChar(charname);     // 生成 BigChar 实例
            pool.put("" + charname, br);
        }
        return br;
    }
}
