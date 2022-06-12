package thread.other;

public class TestPriority {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());


        MyPriority priority = new MyPriority();
        Thread thread1 = new Thread(priority);
        Thread thread2 = new Thread(priority);
        Thread thread3 = new Thread(priority);
        Thread thread4 = new Thread(priority);
        Thread thread5 = new Thread(priority);
        Thread thread6 = new Thread(priority);

        //设置优先级，在启动
        thread1.start();
        thread2.setPriority(1);
        thread2.start();
        thread3.setPriority(4);
        thread3.start();
        thread4.setPriority(10);
        thread4.start();
        thread5.setPriority(8);
        thread5.start();
        thread6.setPriority(7);
        thread6.start();

    }

}

class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());
    }
}
