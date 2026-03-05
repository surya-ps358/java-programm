package EXepetionHandling;

import java.util.Scanner;

public class AreaCalculator{
    public static double calculateArea(double length,double width){
        return length*width;
    }

    public static void main(String[]args)
{
    Scanner sc=new Scanner(System.in);

    try
    {
        System.out.println("Enter length of rectangle:");
        double length=Double.parseDouble(sc.nextLine());

        System.out.println("Enter width of rectangle");
        double width=Double.parseDouble(sc.nextLine());

        double Area=calculateArea(length,width);
        System.out.println("Area of rectangle with length "+length+" and width "+ width+" is: "+Area);
    }
    catch(IllegalArgumentException e){
        System.out.println("Error: Length and width must be > 0.");
    }
    catch(Exception e){
        System.out.println("");
    }
    finally{
        sc.close();
    }
}
}