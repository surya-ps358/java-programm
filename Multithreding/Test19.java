package Multithreding;

public class Test19 extends Thread {
    public static void main(String[] args) {
        System.out.println("The currentThread is a :" + Thread.currentThread().getName());
        Thread t1 = new Thread(new Test19(), "Pandurang");
        Thread t2 = new Thread(new Test19(), "Shivam");
        Thread t3 = new Thread(new Test19(), "Imran");
        Thread t4 = new Thread(new Test19(), "Rushikesh");
        Thread t5 = new Thread(new Test19(), "Suraj");
        t1.start();
        t2.start();
        t2.run();
        t3.start();
        t4.start();
        t5.start();
    }

    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println(Thread.currentThread().getName() + " I am  " + i);
            System.out.println();
        }
    }
}
