package thread.other.proxy;

import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

/**
 * 2
 * 静态代理
 * 代理的真实对象
 */
public class P09StaticProxy {

    public static void main(String[] args) {

        WeddingCompany company = new WeddingCompany(new You());
        company.happyMarry();

        Vector<Map<String, Object>> vector = new Vector<>();
        Iterator<Map<String, Object>> iterator = vector.iterator();
    }

}
