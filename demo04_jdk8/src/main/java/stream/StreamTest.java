package stream;

import lamdba.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Status.FREE),
            new Employee("李四", 58, 5555.55, Status.BUSY),
            new Employee("王五", 26, 3333.33, Status.VOCATION),
            new Employee("赵六", 36, 6666.66, Status.FREE),
            new Employee("田七", 12, 8888.88, Status.BUSY)
    );


    //内部迭代：迭代操作由 Stream API 完成
    @Test
    public void test1() {
        employees.stream().filter(employee -> employee.getAge() > 35).forEach(System.out::println);
    }

    //发现“短路”只输出了两次，说明只要找到 2 个 符合条件的就不再继续迭代
    //找出工资少于5000的且只输出2个
    @Test
    public void test2() {
        employees.stream().filter(employee -> {
            System.out.println("短路！");
            return employee.getSalary() > 5000;
        }).limit(2).forEach(System.out::println);
    }

    //中间操作
    /*
     * 映射
     * map--接收Lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新元素。
     * flatMap--接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */
    @Test
    public void test3() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        list.stream().map(str -> str.toLowerCase()).forEach(System.out::println);

        System.out.println("------------------------");
        employees.stream().map(Employee::getName).forEach(System.out::println);

        System.out.println("------------------------");
        list.stream().map(StreamTest::filterChatacter).forEach(System.out::println);

        System.out.println("------------------------");
        list.stream().flatMap(StreamTest::filterChatacter).forEach(System.out::println);

    }

    public static Stream<Character> filterChatacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }


    //创建Stream
    @Test
    public void test() {
        //1.可以通过Collection 系列集合提供的stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2.通过 Arrays 中的静态方法stream()获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        //3.通过Stream 类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        //4.创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10).forEach(System.out::println);
        //生成
        Stream.generate(() -> Math.random()).limit(5).forEach(System.out::println);

    }

}
