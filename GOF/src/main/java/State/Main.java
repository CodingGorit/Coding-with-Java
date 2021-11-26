package State;

/**
 * @Author Gorit
 * @Date 2021/11/26
 **/
public class Main {
    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("State Simple");
        while (true) {
            for (int hour = 0; hour < 24; hour++) {
                frame.setClock(hour);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
