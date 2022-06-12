package thread.other;

/**
 * 3
 * 停止线程
 */
public class P11StopThread implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("running...thread：" + i++);
        }
    }

    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        P11StopThread thread = new P11StopThread();
        new Thread(thread).start();

        for (int i = 0; i < 100000; i++) {
            if (i == 9000) {
                thread.stop();
                System.out.println("线程停止了");
            }

        }
    }

}
