package Multithreding;

public class Tread17 extends Thread {

    public void run() {
        System.out.println("Print me");
    }

    public static void main(String[] args) {
        try {
            for (int i = 0; i <= 10; i++) {
                System.out.println("value :" + i);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread Exception !!");
        }

        Thread t1 = new Thread();
        t1.start();
    }

}
