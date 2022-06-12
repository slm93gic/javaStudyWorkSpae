package thread.other;

/**
 * 模拟倒计时
 */
public class P12TestSleep implements Runnable {
    @Override
    public void run() {
        for (int i = 10; i >= 1; i--) {
            System.out.println("倒计时：" + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        P12TestSleep sleep = new P12TestSleep();
        new Thread(sleep).start();
    }
}
