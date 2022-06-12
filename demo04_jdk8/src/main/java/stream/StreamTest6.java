package stream;

import lamdba.Employee;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 6．收集
 */
public class StreamTest6 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Status.FREE),
            new Employee("李四", 58, 5555.55, Status.BUSY),
            new Employee("王五", 26, 3333.33, Status.VOCATION),
            new Employee("赵六", 36, 6666.66, Status.FREE),
            new Employee("田七", 12, 8888.88, Status.BUSY)
    );

    //收集为list
    @Test
    public void test() {
        List<String> list = employees.stream().map(Employee::getName).collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    //收集为Set
    @Test
    public void test1() {
        Set<String> set = employees.stream().map(Employee::getName).collect(Collectors.toSet());
        set.forEach(System.out::println);
    }

    //为HashMap
    @Test
    public void test2() {
        HashSet<String> hashSet = employees.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
        hashSet.forEach(System.out::println);
    }

    //总和
    @Test
    public void test3() {
        Long collect = employees.stream().collect(Collectors.counting());
        System.out.println(collect);
    }

    //平均值
    @Test
    public void test4() {
        Double avg = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);
    }

    //总和
    @Test
    public void test5() {
        Double sum = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);
    }

    //最大值
    @Test
    public void test6() {
        Optional<Employee> max = employees.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(max.get());

        Optional<Double> ma1 = employees.stream().map(Employee::getSalary).collect(Collectors.maxBy(Double::compare));
        System.out.println(ma1);
    }

    //最小值
    @Test
    public void test7() {
        Optional<Double> min = employees.stream().map(Employee::getSalary).collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());

        Optional<Employee> collect = employees.stream().collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(collect.get().getSalary());
    }

    //分组
    @Test
    public void test8() {
        Map<Status, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
    }

    //多级分组
    @Test
    public void test9() {
        Map<Status, Map<String, List<Employee>>> map2 = employees.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
            if (e.getAge() <= 35) {
                return "青年";
            } else if (e.getAge() <= 50) {
                return "中年";
            } else {
                return "老年";
            }
        })));
        System.out.println(map2);
    }

    //分区
    @Test
    public void test10() {
        Map<Boolean, List<Employee>> map3 = employees.stream().collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000));
        System.out.println(map3);
    }

    @Test
    public void test11() {
        DoubleSummaryStatistics dss = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getSum());
        System.out.println(dss.getAverage());
        System.out.println(dss.getMax());


    }

    //拼接
    @Test
    public void test12() {
        String str = employees.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(str);//张三李四王五赵六田七
    }

}
