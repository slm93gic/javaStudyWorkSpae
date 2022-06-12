package thread.create;

/**
 * p3
 * 创建线程的方式2
 */
public class P05ImplRunable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码");
        }
    }


    /**
     * 代理模式
     */
    public static void main(String[] args) {
        new Thread(new P05ImplRunable()).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程");
        }
    }
}

