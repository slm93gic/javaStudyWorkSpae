package stream;

import lamdba.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 3．排序
 */
public class StreamTest3 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Status.FREE),
            new Employee("李四", 58, 5555.55, Status.BUSY),
            new Employee("王五", 26, 3333.33, Status.VOCATION),
            new Employee("赵六", 36, 6666.66, Status.FREE),
            new Employee("田七", 12, 8888.88, Status.BUSY)
    );

    /*
     * 排序
     * sorted()-自然排序（按照对象类实现Comparable接口的compareTo()方法 排序）
     * sorted(Comparator com)-定制排序（Comparator）
     */
    @Test
    public void test7() {
        List<String> list = Arrays.asList("ccc", "bbb", "aaa");
        list.stream().sorted().forEach(System.out::println);

        System.out.println("------------------------");

        employees.stream().sorted((e1, e2) -> {
            if (e1.getAge().equals(e2.getAge())) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return e1.getAge().compareTo(e2.getAge());
            }
        }).forEach(System.out::println);
    }


}
