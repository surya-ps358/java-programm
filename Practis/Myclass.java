

public class Myclass {

    public void calc(float i, float j) {
       System.out.println(i+j);
    }
    public static void main(String[]args){
        System.out.println("hello");
        Myclass m= new Myclass();
        m.calc(1.0f, 5.2f);
    }

}
