package EXepetionHandling;

import java.util.Scanner;

public class ExceptionHandlingDemo1{
    public static void handleExceptions(String name){
        try
        {
            if(name== null){
                throw new NullPointerException();
            }

            System.out.println("Length of the input string: "+name.length());

            int number=Integer.parseInt(name);
            System.out.println("Converted to integer: "+number);
            name.toLowerCase();
        }
        catch(NumberFormatException e){
        System.out.println("NumberFormatException: Input is not a valid integer.");
        }
        catch(NullPointerException e)
        {System.out.println("NullPointerException: Input is null.");
        }

        

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter a String: ");
        String input=sc.nextLine();

        if(input.equals("null"))
        {
            input=null;
        }
        handleExceptions(input);
        sc.close();
    }
}