package thread.other;

/**
 * 1
 * 龟兔赛跑
 */
public class P07Race implements Runnable {

    //胜利者
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (gameOver(i)) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-->跑了" + i + "步");
        }
    }

    private boolean gameOver(int steps) {
        //判断是否有胜利者
        if (winner != null) {//已经有胜利者了
            return true;
        }
        if (steps == 100) {
            winner = Thread.currentThread().getName();
            System.out.println("winner is " + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        P07Race race = new P07Race();
        new Thread(race, "小兔子").start();
        new Thread(race, "乌龟").start();
    }

}
