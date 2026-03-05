package lambdaExpression;

interface Runnable
{
   void run();
}

public class demo2
{
	public static void main(String[] args) {
		Runnable nit = () -> System.out.println("Thread Started");
		nit.run();
	}
}


