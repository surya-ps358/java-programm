package lambdaExpression;

//@FunctionalInterface    //error
interface NIT
{
	String nit(String courseName);
}

interface Course extends NIT
{
	String courseName();
	String facultyName();
	String duration();
}
public class demo4
{
	public static void main(String[] args) {
		NIT nit = (String course) -> course;
		System.out.println(nit.nit("Java"));
	}
}

