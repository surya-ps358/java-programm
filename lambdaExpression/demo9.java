package lambdaExpression;


interface Nit {
    int square(int x);

    default int add (int a,int b){
        return a+b;
    }

    default int sub(int a,int b){
        return a-b;
    }

    static int multiply(int a,int b){
        return a*b;
    }
    static int divide(int a,int b){
        return a/b;
    }
}




public class  demo9 implements Nit
{
    public static void main(String[] args) {
        int a=25;
        int b=5;

        demo9 D=new demo9();
        int add=D.add(a, b);
        int sub=D.sub(a, b);
        int multiply=Nit.multiply(a,b);
    int divide=Nit.divide(a,b);
     int square = D.square(a);
    System.out.println(add+" "+sub+" "+multiply+" "+divide);
    System.out.println(square);
 }
 @Override
 public int square(int x)
  {
     return x*x;
 }
 
}

    

