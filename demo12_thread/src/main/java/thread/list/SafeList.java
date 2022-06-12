package thread.list;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SafeList {

    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> lists = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                lists.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        System.out.println(lists.size());
    }
}
