package Composite;

/**
 * @Author Gorit
 * @Date 2021/10/7
 * 使用 main 创建如下目录树
 * - root
 *      - bin
 *          - vi
 *          - latex
 *      - tmp
 *      - usr
 *          - yuki
 *              - diary.html
 *              - Composite.java
 *           - hanko
 *              - memo.tax
 *            -  tomura
 *              - game.doc
 *              - junk.mail
 **/
public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Making root entries...");
            Dirextory rootDir = new Dirextory("root");
            Dirextory bindDir = new Dirextory("bin");
            Dirextory tmpDir = new Dirextory("tmp");
            Dirextory usrDir = new Dirextory("usr");
            rootDir.add(bindDir);
            rootDir.add(tmpDir);
            rootDir.add(usrDir);

            bindDir.add(new File("vi", 10000));
            bindDir.add(new File("latex", 20000));
            rootDir.printList();

            System.out.println("");
            System.out.println("Making user entries...");
            Dirextory yuki = new Dirextory("yuki");
            Dirextory hanko = new Dirextory("hanko");
            Dirextory tomura = new Dirextory("tomura");
            usrDir.add(yuki);
            usrDir.add(hanko);
            usrDir.add(tomura);
            yuki.add(new File("diary.html", 1001));
            yuki.add(new File("Composite.java", 200));
            hanko.add(new File("memo.tak", 300));
            tomura.add(new File("game.doc", 400));
            tomura.add(new File("junk.mail", 500));
            rootDir.printList();
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
