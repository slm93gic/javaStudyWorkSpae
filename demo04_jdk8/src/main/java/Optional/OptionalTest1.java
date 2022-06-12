package Optional;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest1 {

    @Test
    public void test1() {
        Man man = new Man();
        String name = getGodnessName(man);
        System.out.println(name);
    }

    //需求：获取一个男人心中女神的名字
    public String getGodnessName(Man man) {
        if (man == null) {
            return "苍老师";
        }

        Godness g = man.getGod();
        if (g != null) {
            return g.getName();
        }
        return "苍老师";
    }

    //运用Optional的实体类
    @Test
    public void test6() {
        Optional<Godness> godness = Optional.ofNullable(new Godness("林志玲"));
        Optional<NewMan> op = Optional.ofNullable(new NewMan(godness));
        String name = getGodnessName2(op);
        System.out.println(name);
    }

    public String getGodnessName2(Optional<NewMan> man) {
        return man.orElse(new NewMan()).getGodness().orElse(new Godness("苍老师")).getName();
    }

}
