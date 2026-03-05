package Multithreding;

public class Test10 extends Thread {
	static Thread t;

	public static void main(String[] args) {
		try {
			t = new Thread(new Test10(), "Ravi");
			t.start();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void run() {
		for (int i = 1; i < 5; i++) {
			try {
				System.out.print(Thread.currentThread().getName() + " ");
				t.start();
			} catch (Exception e) {
				System.out.println(" will not bother about but " + e + " happened " + i + " times");
			}
		}
	}
}
