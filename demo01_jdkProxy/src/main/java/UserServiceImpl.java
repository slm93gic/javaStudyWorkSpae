public class UserServiceImpl implements UserService {

    @Override
    @Transactional
    public void doSomething(String thing) {
        System.out.println("do something : " + thing);
    }
}