package EXepetionHandling;

import java.util.Scanner;

class FinancialTransaction {

    public void processTransication(double amount, long AccountNumber) {
        try {
            if (amount < 0) {
                throw new IllegalArgumentException("Amount Must be positive !!");
            }
            System.out.println("Processing transaction...");
            System.out
                    .println("Transaction successful: Amount Rs." + amount + "transferred to account " + AccountNumber);

        } catch (RuntimeException e) {
            System.err.println("Error processing transaction: " + e.getMessage());

        }
    }
}

public class main{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        FinancialTransaction ft=new FinancialTransaction();
        try{
        System.out.println("Enter Your Amount :");
        double  amount=Double.parseDouble(sc.nextLine());

        System.out.println("Enter your AccountNumber :");
        long AccountNumber=Long.parseLong(sc.nextLine());

        ft.processTransication(amount, AccountNumber);
        }
        catch(NumberFormatException e){
            System.out.println("Invalid input: Please enter a valid number for transaction amount.");
        }
        sc.close();
        
    }

}

