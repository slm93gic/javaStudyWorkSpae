package method;

public interface MyFunc {

    default String getName() {
        return "哈哈哈";
    }

    public static String getAge() {
        return "18";
    }
}
