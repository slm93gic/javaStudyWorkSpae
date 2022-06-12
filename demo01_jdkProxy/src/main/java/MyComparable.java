
public class MyComparable {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserService jdkProxy = (UserService) ProxyFactory.getJdkProxy(userService);
        jdkProxy.doSomething("eat");
    }


}
