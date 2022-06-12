package thread.other.daemon;

public class God implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("我是上帝，我在守护你");
        }
    }
}