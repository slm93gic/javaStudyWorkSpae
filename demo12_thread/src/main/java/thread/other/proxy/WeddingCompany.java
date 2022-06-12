package thread.other.proxy;

/**
 * 婚庆公司
 */
public class WeddingCompany implements Marry {

    private final Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();
        after();
    }

    private void before() {
        System.out.println("结婚之前布置现场");
    }

    private void after() {
        System.out.println("结婚之后收尾款");
    }
}
