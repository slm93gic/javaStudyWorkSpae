package thread.bank;

/**
 * 取钱
 */
public class Drawing extends Thread {

    //账户
    Account account;
    //取的多少钱吗
    int drawingMoney;
    //现在手里的钱
    int nowMoney;

    Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }


    @Override
    public void run() {
        //锁账号
        synchronized (account) {
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "取钱，账户余额不足");
                return;
            }

            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //账户余额  = 余额 - 取的钱
            account.money -= drawingMoney;
            //手上的钱
            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.name + "余额：" + account.money);
            System.out.println(this.getName() + "手上的钱：" + nowMoney);
        }


    }
}
