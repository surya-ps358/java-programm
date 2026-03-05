import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First number :");
        //int a = Integer.parseInt(sc.nextLine());
        double a=Double.parseDouble(sc.nextLine());

        System.out.print("Enter Second number :");
        //int b = Integer.parseInt(sc.nextLine());
        double b=Double.parseDouble(sc.nextLine());

        System.out.print("Enter operation operator :");
        String symbol = sc.nextLine();

        switch (symbol) {
            case "+":
                System.out.print("Add is :" + (a + b));

                break;
            case "-":
                System.out.print("Sub is :" + (a - b));
                break;
            case "*":
                System.out.print("Multiplication is :" + (a * b));
                break;
            case "/":
                System.out.print("Division is :" + (a / b));
                break;

            default:
                System.out.println("Enter the valid symbol !!!!");
                
                break;
        }
    }
}
