package stream.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculate extends RecursiveTask<Long> {

    private static final long serialVersionUID = 1234567890L;//序列号

    private long start;
    private long end;
    private static final long THRESHOLD = 10000L;//临界值

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        //判断数据量有没有1万个，超过就分为几次，否则就一次性for循环解决
        if (length <= THRESHOLD) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }

        //增加forkJoin,分为2段
        long middle = (start + end) / 2;
        ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
        left.fork();

        ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
        right.fork();
        return left.join() + right.join();
    }
}
