package method;

import org.junit.jupiter.api.Test;

public class SubClass extends MyClass implements MyFunc {

    @Test
    public void test() {
        //嘿嘿嘿嘿
        SubClass subClass = new SubClass();
        System.out.println(subClass.getName());

        //嘿嘿嘿嘿
        MyClass clazz = new SubClass();
        System.out.println(clazz.getName());

        //嘿嘿嘿嘿
        MyFunc func = new SubClass();
        System.out.println(func.getName());

        System.out.println(MyFunc.getAge());


    }

}
