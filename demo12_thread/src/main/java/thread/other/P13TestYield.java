package thread.other;

/**
 * 礼让
 * 礼让不一定成功，看CPU
 */
public class P13TestYield {
    public static void main(String[] args) {
        MyYield yield = new MyYield();
        new Thread(yield, "a").start();
        new Thread(yield, "b").start();
    }
}


class MyYield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程停止");
    }
}