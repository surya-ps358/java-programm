package lambdaExpression;

//@FunctionalInterface 
interface Str
{
	String str(String str);
}

public class FunctionalInterface {
	public static void main(String[] args) {
		Str nit = s -> "Naresh"+s;
		System.out.println(nit.str("IT"));
	}
}
