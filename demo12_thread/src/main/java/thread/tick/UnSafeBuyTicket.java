package thread.tick;

public class UnSafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket ticket = new BuyTicket();
        new Thread(ticket, "苦逼的我").start();
        new Thread(ticket, "牛批的你").start();
        new Thread(ticket, "可恶的黄牛").start();
    }
}
