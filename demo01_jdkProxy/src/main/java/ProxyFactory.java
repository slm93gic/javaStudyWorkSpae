
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static Object getJdkProxy(Object object) {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    Object result;
                    if (method.isAnnotationPresent(Transactional.class) || method.getDeclaringClass().isAnnotationPresent(Transactional.class)) {
                        try {
                            System.out.println("开启事务");
                            result = method.invoke(object, args);
                            System.out.println("提交事务");
                        } catch (Exception e) {
                            System.out.println("回滚事务");
                            throw e;
                        }
                    } else {
                        result = method.invoke(object, args);
                    }

                    return result;
                });
    }

}
