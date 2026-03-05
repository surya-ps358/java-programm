package Multithreding;

class Test extends Thread {
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Hello Welome here...." + i);
        }
    }
}

public class Test1 {
    public static void main(String[] args) {
        // try{

        Test t1 = new Test();
        Test t2 = new Test();

        t1.start();
        // t1.join();
        // Thread.sleep(5000);
        t2.start();
        // }
        // catch(InterruptedException e){
        // e.printStackTrace();
        // System.err.println("completed");
        // }
    }
}
