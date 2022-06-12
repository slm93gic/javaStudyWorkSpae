package stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Stream练习：
 */
public class StreamTest7 {

    List<Transaction> transaction = null;

    @Before
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transaction = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    //1.找出2011年发生的所有交易，并按交易额排序(从低到高)
    @Test
    public void test1() {
        Stream<Transaction> sorted = transaction.stream().filter(e -> e.getYear() == 2011).sorted((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()));
        sorted.forEach(System.out::println);
    }

    //2.交易员都在哪些不同的城市工作过？
    @Test
    public void test2() {
        Stream<String> distinct = transaction.stream().map(e -> e.getTrader().getCity()).distinct();
        distinct.forEach(System.out::println);
    }

    //3.查找所有来自剑桥的交易员，并按姓名排序
    @Test
    public void test3() {
        Stream<Trader> cambridge = transaction.stream().filter(e -> e.getTrader().getCity().equals("Cambridge")).map(Transaction::getTrader).sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).distinct();
        cambridge.forEach(System.out::println);

    }

    //4.返回所有交易员的姓名字符串，按字母顺序排序
    @Test
    public void test4() {
        Stream<String> sorted = transaction.stream().map(e -> e.getTrader().getName()).sorted().distinct();
        sorted.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------");
        Stream<String> sorted1 = transaction.stream().map(Transaction::getTrader).map(Trader::getName).distinct().sorted();
        sorted1.forEach(System.out::println);

        System.out.println("-------------------------");

        //返回的每个String合成一个流
        Stream<String> sorted2 = transaction.stream().map((t) -> t.getTrader().getName()).flatMap(this::filterCharacter).sorted((s1, s2) -> s1.compareToIgnoreCase(s2));
        sorted2.forEach(System.out::println);


    }

    public Stream<String> filterCharacter(String str) {
        List<String> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch.toString());
        }
        return list.stream();
    }


    //5.有没有交易员是在米兰工作的？
    @Test
    public void test5() {
        Stream<Trader> milan = transaction.stream().filter(e -> e.getTrader().getCity().equals("Milan")).map(Transaction::getTrader).distinct();
        milan.forEach(System.out::println);
        System.out.println("-------------------------");
        boolean b1 = transaction.stream().anyMatch((t) -> t.getTrader().getCity().equals("Milan"));
        System.out.println(b1);
    }

    //6.打印生活在剑桥的交易员的所有交易额
    @Test
    public void test6() {
        Optional<Integer> sum = transaction.stream().filter(e -> e.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).reduce(Integer::sum);
        System.out.println(sum.get());
    }

    //7.所有交易中，最高的交易额是多少
    @Test
    public void test7() {
        Optional<Integer> max = transaction.stream().map(t -> t.getValue()).max(Integer::compareTo);
        System.out.println(max.get());
    }

    //8.找到交易额最小的交易
    @Test
    public void test8() {
        Optional<Integer> min = transaction.stream().map(t -> t.getValue()).min(Integer::compare);
        System.out.println(min.get());
    }

}
