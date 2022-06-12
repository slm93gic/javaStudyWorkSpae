package thread.other;

/**
 * 合并线程 代此线程结束执行完成后，在执行其他的线程，其他的阻塞
 * 非常霸道
 * 可以想象成插队
 */
public class P14TestJoin {


    public static void main(String[] args) throws Exception {
        Thread vip = new Thread(new Vip());
        vip.start();

        //主线程
        for (int i = 0; i < 500; i++) {
            if (i == 200) {
                vip.join();
            }
            System.out.println("main" + i);
        }
    }
}

class Vip implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程Vip来了" + i);
        }
    }
}
