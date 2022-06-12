package thread.create;

/**
 * p1
 * 创建线程方式1
 */
public class P03ExtendsThread extends Thread {


    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码");
        }
    }


    public static void main(String[] args) {
        P03ExtendsThread mythread = new P03ExtendsThread();
        mythread.start();

        /**
         * 按道理，主线程main应该先执行，但加入多线程后，开辟新的线程，并发执行
         */
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程");
        }
    }
}
