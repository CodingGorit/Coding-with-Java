package Builder;

/**
 * @Author Gorit
 * @Date 2021/9/12
 **/
public class Main {
    public static void main(String[] args) {
        TextBuilder textBuilder = new TextBuilder();
        Director director = new Director(textBuilder);
        director.construct();
        String result = textBuilder.getResult();
        System.out.println(result);

//        HTMLBuilder htmlBuilder = new HTMLBuilder();
//        Director director = new Director(htmlBuilder);
//        director.construct();
//        String result = htmlBuilder.getResult();
//        System.out.println(result);

    }
}
