package Multithreding;

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello");
        }
    }
}

public class Test20 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println(" ERROR :Thread is Interrupted!!");

        }
        System.out.println("Thread is done !!");

    }

}
