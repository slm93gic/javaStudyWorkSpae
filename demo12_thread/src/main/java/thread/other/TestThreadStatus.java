package thread.other;

public class TestThreadStatus {

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //观测状态
        Thread.State state = thread.getState();
        System.out.println(state);

        //观测启动
        thread.start();
        state = thread.getState();
        System.out.println(state);


        //只要线程不终止就一直执行
        while (state != Thread.State.TERMINATED) {
            Thread.sleep(1000);
            state = thread.getState();
            System.out.println(state);
        }
    }
}
