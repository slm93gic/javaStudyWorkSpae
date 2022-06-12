package stream;

import lamdba.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 5．归约
 */
public class StreamTest5 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Status.FREE),
            new Employee("李四", 58, 5555.55, Status.BUSY),
            new Employee("王五", 26, 3333.33, Status.VOCATION),
            new Employee("赵六", 36, 6666.66, Status.FREE),
            new Employee("田七", 12, 8888.88, Status.BUSY)
    );

    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Test
    public void test1() {
        //reduce(T identity,BinaryOperator b)
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);//0为起始值
        Optional su1 = list.stream().map(e -> e.intValue()).reduce(Integer::sum);
        System.out.println(su1.get());
        System.out.println(sum);

        System.out.println("--------------------------");

        //reduce(BinaryOperator b)//没有起始值，map返回可能为空，所以返回Optional类型
        Optional<Double> op = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(op.get());


    }

}
