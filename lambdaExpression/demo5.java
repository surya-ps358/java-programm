package lambdaExpression;

import java.util.function.Function;

public class demo5

{
  public static void main(String[] args)
  {
    Function<String, Boolean> fun = str -> str.startsWith("A");	
		
		System.out.println(fun.apply("Ankit"));
	}
}

