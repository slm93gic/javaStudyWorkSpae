package thread.tick;

/**
 * 引入 并发问题
 */
public class P06Concurrent implements Runnable {

    private int tickNums = 10;

    @Override
    public void run() {
        while (true) {
            if (tickNums <= 0) {
                break;
            }

            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " 得到第几" + tickNums-- + "票");
        }

    }

    public static void main(String[] args) {
        P06Concurrent thread1 = new P06Concurrent();
        new Thread(thread1, "小明").start();
        new Thread(thread1, "老师").start();
        new Thread(thread1, "黄牛").start();

    }

}
