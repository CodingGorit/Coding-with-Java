package Visitor;

/**
 * @Author Gorit
 * @Date 2021/10/24
 **/
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Making root entries");
            Directory rootDir = new Directory("root");
            Directory bindDir = new Directory("bin");
            Directory tmpDir = new Directory("tmp");
            Directory usrDir = new Directory("usr");
            rootDir.add(bindDir);
            rootDir.add(tmpDir);
            rootDir.add(usrDir);
            bindDir.add(new File("vi", 10000));
            bindDir.add(new File("latex", 20000));
            rootDir.accept(new ListVisitor());

            System.out.println("");
            System.out.println("Making user entries...");
            Directory yuki = new Directory("yuki");
            Directory hanok = new Directory("hanok");
            Directory tomura = new Directory("tomura");
            usrDir.add(yuki);
            usrDir.add(hanok);
            usrDir.add(tomura);
            yuki.add(new File("diary.html", 5000));
            yuki.add(new File("Visitor.java", 1024));
            hanok.add(new File("emo.jpg", 256));
            hanok.add(new File("game.doc", 500));
            tomura.add(new File("yuku.mail", 300));
            rootDir.accept(new ListVisitor());
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
