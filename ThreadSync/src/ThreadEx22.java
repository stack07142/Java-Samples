// Thread간 객체 공유 (Thread 상속)

public class ThreadEx22 {

    public static void main(String[] args) {

        Data d = new Data();

        MyThreadEx22 t1 = new MyThreadEx22(d);
        MyThreadEx22 t2 = new MyThreadEx22(d);

        t1.start();
        t2.start();
    }
}

class Data {

    int iv = 0; // 인스턴스 변수
}

class MyThreadEx22 extends Thread {

    Data d; // 1. Thread를 상속받는 클래스에 공유할 객체 타입의 인스턴스 변수를 선언하고

    // 2. 공유할 객체를 매개변수로 받는 생성자를 선언하였다.
    MyThreadEx22(Data d) {

        this.d = d;
    }

    @Override
    public void run() {

        int lv = 0;

        while (lv < 3) {
            System.out.println(getName() + " Local Var:" + ++lv);
            System.out.println(getName() + " Instance Var:" + ++d.iv);
            System.out.println();
        }
    }
}