package lamdba;

import org.junit.jupiter.api.Test;
import stream.Status;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestMethodRef {

    /**
     * 方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”（可以理解为方法引用时Lambda表达式的另一种表现形式）
     * * 主要有三种语法格式：
     * * 对象::实例方法名
     * * 类::静态方法名
     * * 类::实例方法名
     * *
     * * 注意：
     * * 1、Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致！
     * * 2、若Lambda参数列表中的第一个参数是 实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
     */

    //对象::实例方法名v,`````````````````````````
    @Test
    public void test1() {
        PrintStream ps1 = System.out;
        Consumer<String> con = (x) -> ps1.println(x);//生成了一个实现了Consumer接口的类的对象
        con.accept("123");

        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;//相当于上面，引用了ps对象的println()方法
        con1.accept("123");

        Consumer<String> con2 = System.out::println;
        con2.accept("123");
    }

    @Test
    public void test2() {
        final Employee emp = new Employee("张三", 18, 9999.99, Status.FREE);
        Supplier<String> sup = () -> emp.getName();
        System.out.println(sup.get());

        Supplier<String> sup1 = emp::getName;
        System.out.println(sup1.get());
    }

    //类::静态方法名
    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> com1 = Integer::compare;
    }

    //构造器引用
    @Test
    public void test5() {
        Supplier<Employee> employee = () -> new Employee();

        //构造器引用方式
        Supplier<Employee> employee1 = Employee::new;
    }


    //数组引用
    @Test
    public void test6() {
        Function<Integer, String[]> fun = (x) -> new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);

        Function<Integer, String[]> fun1 = String[]::new;
        String[] strs1 = fun1.apply(10);
        System.out.println(strs1.length);
    }

}
