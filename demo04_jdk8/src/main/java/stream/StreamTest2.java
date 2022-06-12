package stream;

import lamdba.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 2．映射
 */
public class StreamTest2 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Status.FREE),
            new Employee("李四", 58, 5555.55, Status.BUSY),
            new Employee("王五", 26, 3333.33, Status.VOCATION),
            new Employee("赵六", 36, 6666.66, Status.FREE),
            new Employee("田七", 12, 8888.88, Status.BUSY)
    );

    /*
     * 映射
     * map--接收Lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新元素。
     * flatMap--接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */
    @Test
    public void test5() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        list.stream().map((str) -> str.toUpperCase()).forEach(System.out::println);

        System.out.println("------------------------");

        employees.stream().map(Employee::getName).forEach(System.out::println);
        System.out.println("------------------------");

        Stream<Stream<Character>> stream = list.stream().map(StreamTest2::filterChatacter);
        stream.forEach((sm) -> {
            sm.forEach(System.out::println);
        });

        System.out.println("------------------------");

        Stream<Character> sm = list.stream().flatMap(StreamTest2::filterChatacter);
        sm.forEach(System.out::println);
    }

    public static Stream<Character> filterChatacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    @Test
    public void test6() {//map和flatMap的关系  类似于 add(Object)和addAll(Collection coll)
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        List list2 = new ArrayList<>();
        list2.add(11);
        list2.add(22);
        list2.addAll(list);
        System.out.println(list2);
    }

}
