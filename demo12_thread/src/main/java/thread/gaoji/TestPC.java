package thread.gaoji;

/**
 * 测试，生产者消费模式
 */

public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Productor(container).start();
        new Consumer(container).start();

    }
}

/**
 * 生产者
 */
class Productor extends Thread {
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了" + i + "只鸡");
        }
    }
}

/**
 * 消费者
 */
class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            container.pop();
            System.out.println("消费了" + i + "只鸡");
        }

    }
}

//产品鸡
class Chicken {
    int id;

    Chicken(int id) {
        this.id = id;
    }
}

//缓冲区，产品放在这里，消费者去拿
class SynContainer {

    //容器大小
    Chicken[] chickens = new Chicken[10];
    //计数器
    int counter = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken) {
        //如果满了，等待消费
        if (counter == chickens.length) {
            //通知消费者消费，生产等待
            try {
                this.wait();
            } catch (Exception e) {
            }

        }

        //未满放入产品
        chickens[counter] = chicken;
        counter++;

        //可以通知消费者，进行消费了
        this.notifyAll();
    }

    //消费者拿走
    public synchronized Chicken pop() {
        //能否消费
        if (counter == 0) {
            //等待生产，消费者等待
            try {
                this.wait();
            } catch (Exception e) {
            }

        }
        //如果可以消费
        counter--;
        Chicken chicken = chickens[counter];

        //吃完了，通知生产者生产
        this.notifyAll();

        return chicken;
    }
}