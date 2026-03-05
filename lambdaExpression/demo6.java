package lambdaExpression;

import java.util.function.Predicate;

public class demo6
{
	public static void main(String[] args) 
	{
		Predicate<String> str =s -> s.equals("goolge");
		System.out.println(str.test("google"));
		
	}
}

// public class FunctionalInterface 
// {
// 	public static void main(String[] args) 
// 	{
// 		String str = (String s) -> s.equals("goolge");
// 		System.out.println(str);
// 	}
// }

