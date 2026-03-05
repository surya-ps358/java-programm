package Multithreding;

public class Test15 {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            public void run() {
                int n = 5;
                try {
                    while (n != 0) {
                        System.out.println("Hello friends !!");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable r2 = new Runnable() {
            public void run() {
                int n1 = 3;
                try {
                    while (n1 != 0) {
                        System.out.println("Good Morninig!!");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        try {
            t1.start();
            t1.join();
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
