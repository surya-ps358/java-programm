package lambdaExpression;

import java.util.Random;
import java.util.function.Supplier;

public class Function {
    public static void main(String[] args) {

        String Upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digit = "0123456789";
        String special = "@#!$%&*";
        String TotalChars = Upper + lower + digit + special;

        Random rr = new Random();

        Supplier<String> captcha = () -> {
            String captch = "";
            for (int i = 0; i < 6; i++) {
                int index = rr.nextInt(TotalChars.length());
                captch = captch + TotalChars.charAt(index);

            }
            return captch.toString();

        };
        System.out.println(captcha.get());

    }
}
// package lambdaExpression;

// import java.util.Random;
// import java.util.function.Supplier;

// public class Function {
// public static void main(String[] args) {

// String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
// String lower = "abcdefghijklmnopqrstuvwxyz";
// String digits = "0123456789";
// String special = "@#!$%&*";
// String totalChars = upper + lower + digits + special;

// Random rr = new Random();

// // Supplier to generate a captcha of 6 characters
// Supplier<String> captcha = () -> {
// StringBuilder captch = new StringBuilder();
// for (int i = 0; i < 6; i++) {
// int index = rr.nextInt(totalChars.length());
// captch.append(totalChars.charAt(index));
// }
// return captch.toString();
// };

// // Print the generated captcha
// System.out.println("Generated Captcha: " + captcha.get());
// }
// }
