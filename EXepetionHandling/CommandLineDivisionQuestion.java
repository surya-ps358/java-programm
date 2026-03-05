package EXepetionHandling;

public class CommandLineDivisionQuestion {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new IllegalArgumentException("Two arguments required.");
            }

            try {
                int dividend = Integer.parseInt(args[0]);
                int divisor = Integer.parseInt(args[1]);

                try {
                    double result = (double) dividend / divisor;
                    System.out.println("Division result: " + result);
                } catch (ArithmeticException ae) {
                    System.out.println("Arithmetic error: " + ae.getMessage());
                }
            } catch (NumberFormatException nfe) {
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }
        } catch (IllegalArgumentException iae) {
            System.out.println("IllegalArgumentException: " + iae.getMessage());
        } finally {
            System.out.println("Division operation completed.");
        }
    }
}

