/**
 * Thread간 객체 공유 - 잘못된 예
 */
public class ThreadEx23 {

    public static void main(String[] args) {

        MyThreadEx23 t1 = new MyThreadEx23();
        MyThreadEx23 t2 = new MyThreadEx23();

        t1.start();
        t2.start();
    }
}

class MyThreadEx23 extends Thread {

    int iv = 0; // 공유할 인스턴스 변수 선언

    @Override
    public void run() {

        int lv = 0;

        while (lv < 3) {

            System.out.println(getName() + " Local Var:" + ++lv);
            System.out.println(getName() + " Instance Var:" + ++iv);
            System.out.println();
        }
    }
}
