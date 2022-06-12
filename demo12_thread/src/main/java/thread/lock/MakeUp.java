package thread.lock;

public class MakeUp extends Thread {

    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String girlName;

    MakeUp(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //化妆
    private void makeup() throws Exception {
        if (choice == 0) {
            synchronized (lipstick) {//获取口红的锁
                System.out.println(girlName + "获取口红的锁");
                Thread.sleep(1000);
            }

            synchronized (mirror) {
                System.out.println(girlName + "获取镜子的锁");
            }
        } else {
            synchronized (mirror) {//获取口红的锁
                System.out.println(girlName + "获取镜子的锁");
                Thread.sleep(2000);
            }

            synchronized (lipstick) {
                System.out.println(girlName + "获取口红的锁");
            }
        }
    }
}
