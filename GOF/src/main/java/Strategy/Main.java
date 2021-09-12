package Strategy;

/**
 * @Author Gorit
 * @Date 2021/9/12
 * 创建两个 Player 分别使用不同的策略进行猜拳游戏
 **/
public class Main {
    public static void main(String[] args) {

        int seed1 = 1001;
        int seed2 = 1002;
        Player player1 = new Player("coco",new WinningStrategy(seed1));
        Player player2 = new Player("Gorit",new ProbStrategy(seed2));
        for (int i = 0; i < 1000; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner!!!" + player1);
                player1.win();
                player2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("Winner!!!"+player2);
                player2.win();
                player1.lose();
            } else {
                System.out.println("Even....");
                player1.even();
                player2.even();
            }
        }
        System.out.println("Total result");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }
}
