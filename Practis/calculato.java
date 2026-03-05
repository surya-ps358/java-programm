import java.util.Scanner;

public class calculato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the first number");

        int a = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the second number");
        int b = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the choise of operation ");

        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println(a + b);

                break;
            case 2:
                System.out.println(a - b);
                break;
            case 3:
                System.out.println(a * b);
                break;
            case 4:
                System.out.println(a / b);
                break;

            default:
                break;
        }
    }
}
