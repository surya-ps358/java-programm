package Multithreding;

import java.util.Scanner;

public class MobileEmailValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String mobileNumber = sc.nextLine();
        String email =sc.nextLine();

        String mobileRegex = "^[6-9]\\d{9}$";

        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

        if (mobileNumber.matches(mobileRegex)) {
            System.out.println("Valid Mobile Number");
        } else {
            System.out.println("Invalid Mobile Number");
        }

        if (email.matches(emailRegex)) {
            System.out.println("Valid Email ID");
        } else {
            System.out.println("Invalid Email ID");
        }

        sc.close();
    }
}
