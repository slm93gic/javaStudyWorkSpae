package thread.tick;

public class BuyTicket implements Runnable {

    private int tickNum = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
            buy();
        }
    }

    //加入synchronized
    public synchronized void buy() {
        if (tickNum <= 0) {
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + "拿到" + tickNum--);
    }
}