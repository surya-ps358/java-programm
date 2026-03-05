package Multithreding;

public class Test21 {
    public static void main(String[] args) {
        try {
            System.out.println("Thread is Started !");
            Thread t1 = Thread.currentThread();
            String name = t1.getName();
            for (int i = 0; i <= 10; i++) {
                System.out.println(i + " is Thread by " + name + " Thread");
                Thread.sleep(1000);

            }
            t1.start();

        } catch (InterruptedException e) {

        }
        System.out.println("Thread is ended");
    }

}
