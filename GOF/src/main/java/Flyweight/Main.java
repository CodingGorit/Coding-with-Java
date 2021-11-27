package Flyweight;

import java.util.Scanner;

/**
 * @Author Gorit
 * @Date 2021/11/27
 **/
public class Main {
    public static void main(String[] args) {
//        if (args.length == 0) {
//            System.out.println("Usage: java Main digits");
//            System.out.println("Example: java Main 123123");
//            System.exit(0);
//        }
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要打印的字符数字：（比如 123131）");
        String nums = sc.next();
        BigString bs = new BigString(nums);
        bs.print();
    }
}
