package Multithreding;

class Test9 {
	public static void main(String[] args) {
		try {
			Horse h = new Horse();
			Thread t1 = new Thread(h, "MyHorse");
			Thread t2 = new Thread(h, "YourHorse");
			new Test9().go(t2);
			t1.start();
			t2.start();
		} catch (Exception e) {
			System.out.println(e);
		}

		// void go(Thread t)
		// {
		// //t.start();
		// }
	}

	public void go(Thread t2) {

	}
}

class Horse implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName() + " ");
	}
}