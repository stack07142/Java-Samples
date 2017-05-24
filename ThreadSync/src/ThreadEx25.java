
/**
 * 쓰레드 동기화
 */

public class ThreadEx25 {

    public static void main(String[] args) {

        RunnableEx25 r = new RunnableEx25();

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }
}

class AccountEx25 {

    int balance = 1000;

    public synchronized void withdraw(int money) {

        if (balance >= money) {

            try {

                Thread.sleep(1000); // 다른 쓰레드에게 제어권을 넘기도록 한다.
            } catch (Exception e) {
            }

            balance -= money;
        }
    } // withdraw()
}

class RunnableEx25 implements Runnable {

    AccountEx25 acc = new AccountEx25();

    @Override
    public void run() {

        while (acc.balance > 0) {

            int money = (int) (Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance= " + acc.balance);
        }
    } // run()
}
