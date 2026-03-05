package EXepetionHandling;

import java.util.Scanner;

public class DivisionExample {

    public static int performDivision(int dividend, int divisor) {

        return dividend / divisor;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Enter dividend : ");
            int dividend = scanner.nextInt();

            System.out.print("Enter divisor : ");
            int divisor = scanner.nextInt();

            int result = performDivision(dividend, divisor);
            System.out.println("Result of division : " + result);

        } catch (ArithmeticException e) {

            System.out.println("Error: Division by zero is not allowed.");
        } catch (Exception e) {

            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {

            scanner.close();
        }
    }
}
