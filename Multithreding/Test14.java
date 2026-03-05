package Multithreding;

public class Test14 extends Thread {
    public static void main(String[] args) {
        Test14 t1 = new Test14();
        Test14 t2 = new Test14();
        t1.start();
        t2.run();
    }

    public void start() {
        for (int i = 0; i < 10; i++) {
            System.out.println("valuee of i=" + i);

        }
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Value of i :" + i);
        }
    }
}
