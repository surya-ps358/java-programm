package Multithreding;

public class Test4 {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(i + ") Hi");
                        Thread.sleep(2000);

                    }
                    System.out.println("Messages are Completed...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable r2 = new Runnable() {

            @Override
            public void run() {

                System.out.println("Task two");
            }

        };
        try {
            Thread t1 = new Thread(r1);
            Thread t2 = new Thread(r2);
            t1.start();
            t1.join();
            t1.sleep(2000);
            t2.start();
        }

        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
