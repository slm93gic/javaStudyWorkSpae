package lamdba;

import com.sun.deploy.net.MessageHeader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DemoTest {

    public static void main(String[] args) {
        List<String> list = getList();
        sortUsingJava7(list);
        list.forEach(System.out::print);

        System.out.println();
        list = getList();
        sortUsingJava8(list);
        list.forEach(System.out::print);
    }

    // 使用 java 7 排序
    private static void sortUsingJava7(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    // 使用 java 8 排序
    private static void sortUsingJava8(List<String> list) {
        Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
    }


    //获取数据
    private static List<String> getList() {
        List<String> list = new ArrayList<String>();
        list.add("Google ");
        list.add("Runboy ");
        list.add("Taobao ");
        list.add("Baidu ");
        list.add("Sina ");
        return list;
    }

}
