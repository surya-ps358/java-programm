package Simple_Method;
import java.util.Scanner;

public class payment1 {
    public static void main(String[] args)
    {
        {

            Scanner sc = new Scanner(System.in);
            PaymentGateway gatway = new PaymentGateway();
            System.out.println("Select your payment Option ");
            System.out.println("\t 1) Credit Card");
            System.out.println("\t 2) UPI");
            System.out.println("Please enter your Choice");
            int choice = sc.nextInt();
            sc.nextLine();

            Payment payment = null;
            switch (choice) {
                case 1:
                    payment = gatway.initiatePayment(new CredicardPayment());
                    break;
                case 2:
                    payment = gatway.initiatePayment(new UPIPayment());
                    break;
                case 3:
                    System.err.println("Wrong choice");
                    break;
            }
            if (payment != null) {
                payment.applyDiscount();
                payment.processPayment();
            }
            sc.close();
        }
    }

}

interface Payment {
    public void processPayment();

    public void applyDiscount();
}

class CredicardPayment implements Payment {

    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment...");
        
    }

    @Override
    public void applyDiscount() {
        System.out.println("Applying 10% discount for credit card users.");
    }

}

class UPIPayment implements Payment {

    @Override
    public void processPayment() {
        System.err.println("Processing UPI payment...");
    }

    @Override
    public void applyDiscount() {
        System.out.println("Applying ₹100 cashback for UPI users.");
    }

}

class PaymentGateway {
    public Payment initiatePayment(Payment payment) {
        if (payment instanceof CredicardPayment) {
            System.out.println("Initiating Credit Card payment.");
            return payment;
        } else if (payment instanceof UPIPayment) {
            System.out.println("Initiating UPI payment.");
            return payment;

        } else {
            System.out.println("Wrong Choice...");
             return null;
        }
       
    }
}
