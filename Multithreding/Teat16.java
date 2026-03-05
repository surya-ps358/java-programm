package Multithreding;

public class Teat16 {
    public static void main(String[] args) {

        Thread t1 = Thread.currentThread();
        System.out.println(t1);

        System.out.println("The current thread name is :" + t1.getName());
        System.out.println("The current thread id is :" + t1.getId());
        t1.setName("thread First");
        System.out.println("The new thred name :" + t1.getName());

    }

}
