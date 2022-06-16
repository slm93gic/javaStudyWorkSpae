import org.reflections.Reflections;

import java.util.Set;

public class MyProxy {

    public static void main(String[] args) {
        Reflections reflections = new Reflections();
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Service.class);
        for (Class<?> aClass : annotated) {
            System.out.println(aClass);
        }
    }

}
