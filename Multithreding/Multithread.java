package Multithreding;

public class Multithread implements Runnable {
    @Override
    public void run() {
        System.out.println("hello students..");
    }

    public static void main(String[] args) {
        try {
            Multithread mt1=new Multithread();

            Thread t1 = new Thread(mt1);
            t1.start();
            System.out.println("hello Nareshit");
            t1.join();
            System.out.println("java full stack");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    
}
