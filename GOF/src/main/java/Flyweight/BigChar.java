package Flyweight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author Gorit
 * @Date 2021/11/26
 **/
public class BigChar {
    // 字符名字
    private char charname;
    // 大型字符串对应字符串（由 # . \n）组成
    private String fontData;

    public BigChar(char charname) {
        this.charname = charname;
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("big" + charname + ".txt")
            );
            String line;
            StringBuffer buf = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buf.append(line);
                buf.append("\n");
            }
            reader.close();
            this.fontData = buf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 显示大型字符
    public void print () {
        System.out.println(fontData);
    }
}
