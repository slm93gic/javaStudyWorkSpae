package thread.list;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 线程不安全的的集合
 */
public class UnSafeList {

    public static void main(String[] args) throws InterruptedException {


        List<String> lists = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                synchronized (lists) {
                    lists.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        System.out.println(lists.size());
    }
}
