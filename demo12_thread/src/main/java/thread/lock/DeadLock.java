package thread.lock;

/**
 * 死锁：多个线程互相拥有对象需要的资源，然后形成僵持
 */
public class DeadLock {
    public static void main(String[] args) {
        MakeUp girl1 = new MakeUp(0, "灰姑凉");
        MakeUp girl2 = new MakeUp(1, "白雪公主");
        girl1.start();
        girl2.start();
    }

}
