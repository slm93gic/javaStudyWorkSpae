package thread.other.daemon;

/**
 * 上帝守护者
 * 当人的生命结束，上帝就停止守护
 */
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        Person you = new Person();

        Thread thread = new Thread(god);
        thread.setDaemon(true);
        thread.start();

        new Thread(you).start();

    }
}
