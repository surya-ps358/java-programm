package CollectionFramwork;



import java.util.Vector;

public class VectorDemo1 {

	public static void main(String[] args) {
		
	
	Vector v1=new Vector(4,2);
	v1.addElement(new Integer(2));
	v1.addElement(new Integer(3));
	v1.addElement(new Integer(6));
	System.out.println("Data is the  from position  :"+v1.elementAt(1));
	
	}
}
