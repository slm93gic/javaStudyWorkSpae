package thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

    public static void main(String[] args) {
        TestLock2 lock2 = new TestLock2();
        new Thread(lock2, "张三").start();
        new Thread(lock2, "李四").start();
    }

}

class TestLock2 implements Runnable {

    private int tick = 10;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (tick > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {

                    }
                    System.out.println(Thread.currentThread().getName() + ":" + tick--);
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }


    }
}