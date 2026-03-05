package Multithreding;

class Test0 extends Thread
{
	int a;
	public void run() {
		a++;
	}
}
public class Test23
{
	public static void main(String[] args) {
		Test0 test = new Test0();
		test.run();
		System.out.println(test.a);
		test.start();
		System.out.println(test.a);
		System.out.println(test.isAlive());
		System.out.println(test.getName());
	}
}