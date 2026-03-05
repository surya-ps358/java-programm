package Multithreding;

class simpleThread extends Thread {
    public simpleThread(String str) {
        super(str);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {

            }
            System.out.println("Done!" + getName());
        }
    }
}

public class Test5 {
    public static void main(String[] args) {
        new simpleThread("Pandurang").start();
        new simpleThread("Shivam").start();
    }

}
