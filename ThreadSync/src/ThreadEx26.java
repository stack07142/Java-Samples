/**
 * wait(), notify(), notifiyAll() 를 사용하여 쓰레드 동기화 효율을 높인다
 * - Object에 정의된 메서드이므로 모든 객체에서 호출이 가능하다
 * - 동기화 블록(synchronized 블록) 내에서만 사용할 수 있다
 * - 보다 효율적인 동기화를 가능하게 한다
 */

public class ThreadEx26 {

    public static void main(String[] args) {

        AccountEx26 account = new AccountEx26();

        RunnableEx26 r = new RunnableEx26(account);

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }
}

class AccountEx26 {

    int balance = 1000;

    public synchronized void withdraw(int money) {

        while (balance < money) {

            try {

                wait();
                // 출금 시 잔고가 부족하면
                // wait()을 호출하여 쓰레드가 객체의 lock을 풀고
                // 그 객체의 wating pool에 들어가면서 제어권을 다른 쓰레드에 양보한다
            } catch (Exception e) {
            }
        }

        balance -= money;
        System.out.println("withdraw -> balance= " + balance);
    } // withdraw()

    public synchronized void deposit(int money) {

        balance += money;
        System.out.println("deposit -> balance= " + balance);
        notify();
        // 다른 쓰레드에 의해서 deposit()메서드가 호출되어 잔고가 증가하면서 notify()를 호출하면
        // 객체의 wating pool에서 기다리고 있던 쓰레드를 깨우게 된다 <- 현재 예제에서 해당 Thread를 구현하지는 않음
    }
}

class RunnableEx26 implements Runnable {

    AccountEx26 account;

    public RunnableEx26(AccountEx26 account) {

        this.account = account;
    }

    @Override
    public void run() {

        while (account.balance > 0) {

            int money = (int) (Math.random() * 3 + 1) * 100;
            account.withdraw(money);
        }
    } // run()
}

