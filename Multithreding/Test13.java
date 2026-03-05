package Multithreding;

class MyThreadA extends Thread {
    String s;

    public void run(String s) {
        this.s = s;
        for (int i = 0; i < 5; i++) {
            System.out.println(" swill be printed:" + s);
        }
    }
}

class MyThreadB extends Thread {
    String t;

    public void run(String t) {
        this.t = t;
        for (int i = 0; i < 5; i++) {
            System.out.println("t will be printed :" + t);
        }
    }
}

public class Test13 {
    public static void main(String[] args) {
        MyThreadA t1 = new MyThreadA();
        MyThreadB t2 = new MyThreadB();
        t1.start();
        t1.run("Pandurang");
        t2.start();
        t2.run("Suraj");
    }
}
