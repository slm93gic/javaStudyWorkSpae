package stream;

import lamdba.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 4. 查找与匹配
 */
public class StreamTest4 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Status.FREE),
            new Employee("李四", 58, 5555.55, Status.BUSY),
            new Employee("王五", 26, 3333.33, Status.VOCATION),
            new Employee("赵六", 36, 6666.66, Status.FREE),
            new Employee("田七", 12, 8888.88, Status.BUSY)
    );


    @Test
    public void test1() {
        //allMatch-检查是否匹配所有元素
        boolean b1 = employees.stream().allMatch((e) -> e.getStatus().equals(Status.BUSY));
        System.out.println(b1);//false

        //anyMatch-检查是否至少匹配一个元素
        boolean b2 = employees.stream().anyMatch((e) -> e.getStatus().equals(Status.BUSY));
        System.out.println(b2);//true

        //noneMatch-检查是否没有匹配所有元素
        boolean b3 = employees.stream().noneMatch((e) -> e.getStatus().equals(Status.BUSY));
        System.out.println(b3);//false

        //findFirst-返回第一个元素//Optional是Java8中避免空指针异常的容器类
        Optional<Employee> op = employees.stream().sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).findFirst();
        System.out.println(op.get());//Employee [name=王五, age=26, salary=3333.33, Status=VOCATION]

        //findAny-返回当前流中的任意元素
        Optional<Employee> op2 = employees.parallelStream().filter((e) -> e.getStatus().equals(Status.FREE)).findAny();
        System.out.println(op2.get());//Employee [name=赵六, age=36, salary=6666.66, Status=FREE]

        //count-返回流中元素的总个数
        Long count = employees.stream().count();
        System.out.println(count);//5

        //max-返回流中最大值
        Optional<Employee> op3 = employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(op3.get());//Employee [name=张三, age=18, salary=9999.99, Status=FREE]

        ////min-返回流中最小值
        Optional<Double> op4 = employees.stream().map(Employee::getSalary).min(Double::compare);
        System.out.println(op4.get());//3333.33

    }

}
