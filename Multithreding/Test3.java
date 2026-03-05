package Multithreding;

public class Test3 {
    public static void main(String[] args) {
        // new Thread(){
        // public void run(){
        // System.out.println("Task one");
        // }
        // }.start();
        // new Thread(){
        // public void run (){
        // System.out.println("Task two");
        // }
        // }.start();
        // new Thread(){
        // public void run(){
        // System.out.println("Task three");
        // }
        // }.start();
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("one");
            }
        };
        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println("two");
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
