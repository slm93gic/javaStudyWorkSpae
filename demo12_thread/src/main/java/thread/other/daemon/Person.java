package thread.other.daemon;

public class Person implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("我现在" + i + "岁了");
        }
        System.out.println("我化作尘土");
    }
}