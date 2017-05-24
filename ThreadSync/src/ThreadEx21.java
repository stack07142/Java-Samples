// Thread간 객체 공유 (Runnable Interface 구현)

public class ThreadEx21 {

    public static void main(String[] args) {

        RunnableImp1 r = new RunnableImp1();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }
}

class RunnableImp1 implements Runnable {

    int iv = 0; // 인스턴스 변수 -> Heap 메모리에 생성, Thread간 공유

    @Override
    public void run() {

        int lv = 0; // 로컬 변수 -> JVM Stack 메모리에 생성되고 Thread가 종료되면서 해제됨
        String name = Thread.currentThread().getName();

        while (lv < 3) {

            System.out.println(name + " Local Var:" + ++lv);
            System.out.println(name + " Instance Var:" + ++iv);
            System.out.println();
        }
    } // run()
}