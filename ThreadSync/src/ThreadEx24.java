
/**
 * 쓰레드의 동기화되지 않은 예제
 */

public class ThreadEx24 {

    public static void main(String[] args) {

        RunnableEx24 r = new RunnableEx24();

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }
}

class Account {

    int balance = 1000;

    public void withdraw(int money) {

        if (balance >= money) {

            try {

                Thread.sleep(1000); // 다른 쓰레드에게 제어권을 넘기도록 한다.
            } catch (Exception e) {
            }

            balance -= money;
        }
    } // withdraw()
}

class RunnableEx24 implements Runnable {

    Account acc = new Account();

    @Override
    public void run() {

        while (acc.balance > 0) {

            int money = (int) (Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance= " + acc.balance);
        }
    } // run()
}
