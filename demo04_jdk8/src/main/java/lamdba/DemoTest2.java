package lamdba;

import java.util.Comparator;

public class DemoTest2 {

    public static void main(String[] args) {

    }

    //1
    public void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };
    }

    //2
    public void test2() {
        Runnable r = () -> System.out.println("Hello World!");
    }

    //3
    public void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    //4
    public void test4() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }

    //5
    public void test5() {
    }


}
