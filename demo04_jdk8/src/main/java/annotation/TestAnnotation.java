package annotation;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestAnnotation {

    //checker framework框架提供此注解
    private /*@NonNull*/ Object obj = null;

    @MyAnnotation
    TestAnnotation() {
        List<String> arrays = new ArrayList<>();

        for (String str : arrays){

        }
    }


    @Test
    public void test1() throws NoSuchMethodException, SecurityException {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method m1 = clazz.getMethod("show", String.class);
        MyAnnotation[] mas = m1.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation : mas) {
            System.out.println(myAnnotation.value());
        }
    }

    @MyAnnotation("Hello")
    @MyAnnotation("world")
    public void show(@MyAnnotation("abc") String str) {

    }

}
