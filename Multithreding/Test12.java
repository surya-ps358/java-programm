package Multithreding;

class Parrot implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName() + " ");
	}
}

public class Test12 {
	static Parrot p;

	static {
		p = new Parrot();
	}

	{
		Thread t1 = new Thread(p, "Peacock");
		t1.start();
	}

	public static void main(String[] args) {
		new Test12();

		new Thread(new Runnable() {
			public void run() {
				;
			}
		}, "Koyal").start();

		new Thread(new Parrot(), "Parrot").start();
	}

	{
		Thread t2 = new Thread(p, "Sparrow");
		t2.start();
	}
}
