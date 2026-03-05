package Multithreding;

class foo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Run by" + Thread.currentThread().getName() + " i is" + i);
        }
    }

    public void run(String name) {
        System.out.println("The second  name is thread " + name);
    }

}

public class Test18 {
    public static void main(String[] args) {
        try {
            foo f1 = new foo();
            Thread t1 = new Thread(f1);
            t1.start();
            t1.join();
        } catch (InterruptedException e) {

        }

        try {
            for (int j = 0; j < 10; j++) {
                System.out.println("After completion of first Thread!!");
                System.out.println("This is the second Thread by run j is :" + j);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
