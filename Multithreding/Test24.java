package Multithreding;

public class Test24 extends Thread
{
	public void run() {
		System.out.println(Thread.currentThread().getId());
	}
	public static void main(String[] args) {
		Test24 nit = new Test24();
		for(int i=0;i<10;i++)
		{
			nit.start();
		}
	}
}
