package lambdaExpression;

interface Drawable
{
   void draw();
}
public class demo1 {
	public static void main(String[] args)
	{
	   Drawable d=() -> System.out.println("Drawing...");
	   d.draw();
	}
	
}

//error

