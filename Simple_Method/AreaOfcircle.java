package Simple_Method;

//import java.util.Scanner;

public  class AreaOfcircle {
    
    public static String getArea(double redius){
        if(redius <0){
            return ""+(-1);

        }
        else{
            final double pi=3.14;
            double Area= pi*redius*redius;
            return "" +Area;
        }
    }
}

 class circle{
    public static void main(String[] args) {
        
        // Scanner sc;
        // Scanner.sc  =new Scanner(System.in);
        // System.out.println("Enter the radius Of Circle :");
        // Double redius =sc.nextDouble();
        // sc.nextLine();

        System.out.println("The Area Of Circle :"+AreaOfcircle.getArea(1.5));
    }
}
