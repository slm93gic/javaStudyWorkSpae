package thread.bank;

public class UnSafeBank {

    public static void main(String[] args) {
        Account account = new Account(70, "结婚基金");
        Drawing coolMan = new Drawing(account, 50, "丈夫");
        Drawing girlFriend = new Drawing(account, 50, "妻子");
        coolMan.start();
        girlFriend.start();
    }
}

