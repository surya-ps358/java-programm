package Method_Overriding;

import java.util.Scanner;

class BankAccount {
    protected String accountHolderName;
    protected String accountNumber;
    protected double amount;
    public static final String IFSC_CODE = "SBI00001";

    public BankAccount(String accountHolderName, String accountNumber, double amount) {
        this.accountHolderName = accountHolderName;
        if (accountHolderName.isEmpty() || accountHolderName == "null" || accountHolderName == null) {
            System.err.println("Account holder name cannot be empty.");
            System.exit(0);
        }

        this.accountNumber = accountNumber;
        

        this.amount = amount;
        if (amount < 0) {
            System.err.println("Balance cannot be negative");
            System.exit(0);
        }

    }

    public void calculateInterest() {
        System.out.println("");
    }

    public void displyaAccountDetails() {
        System.out.println("Enter account Holder Name :" + accountHolderName);
        System.out.println(" Enter account Number :" + accountNumber);
        System.out.println("Balance RS :" + amount);
        System.out.println("IFSC Code is :" + IFSC_CODE);
    }

}

class Savingaccount extends BankAccount {
    protected double interestRate = 4.0;

    public Savingaccount(String accountHolderName, String accountNumber, double amount) {
        super(accountHolderName, accountNumber, amount);
        this.interestRate = interestRate;

    }

    public void calculateInterest() {
        double intrest = (amount * interestRate) / 100;
        System.out.println("Saving account intrest is :" + intrest);
    }
}

class CurrentAccount extends BankAccount {

    protected double OverdraftLimit = 5000.0;

    public CurrentAccount(String accountHolderName, String accountNumber, double amount) {
        super(accountHolderName, accountNumber, amount);
        this.OverdraftLimit = OverdraftLimit;

    }

    public void calculateInterest() {
        System.out.println("Statement that Current accounts do not earn interest.");
    }

    public void checkOverdraftLimit() {
        System.out.println("In this method print overdraftLimit Amount." + OverdraftLimit);
    }

}

class FixedDepositeAccount extends BankAccount {

    protected double interestRate = 6.5;
    protected int depositTerm;

    public FixedDepositeAccount(String accountHolderName, String accountNumber, double amount, int depositTerm) {
        super(accountHolderName, accountNumber, amount);
        this.interestRate = interestRate;
        this.depositTerm = depositTerm;
        if (depositTerm < 0) {
            System.err.println("DepositTerm can't be negative.");

        }
    }

    public void calculateInterest() {
        double interest = (interestRate * amount * depositTerm) / 100;
        System.out.println("Fixed Deposit Interest for" + depositTerm + "years RS :" + interest);
    }
}

public class BankApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please select the Account Type :");
        System.out.println("\t\t\t1) Saving Account");
        System.out.println("\t\t\t2) Current Account");
        System.out.println("\t\t\t3) Fixed Deposit Account");
        System.out.println("Please enter the type of account you want to open : [1/2/3]");

        int type = sc.nextInt();
        sc.nextLine();

        switch (type) {
            case 1:
                System.out.print("Enter account Holder Name :");
                String name1 = sc.nextLine();
                System.out.print("  Enter account Number :");
                String Acnumber1 = sc.nextLine();
                System.out.print(" Enter the Amount :");
                double balance1 = sc.nextDouble();

                sc.nextLine();

                Savingaccount saving = new Savingaccount(name1, Acnumber1, balance1);

                saving.displyaAccountDetails();
                saving.calculateInterest();

                break;

            case 2:
                System.out.print("Enter account Holder Name :");
                String name2 = sc.nextLine();
                System.out.print("  Enter account Number :");
                String Acnumber2 = sc.nextLine();
                System.out.print(" Enter the Amount :");
                double balance2 = sc.nextDouble();
                CurrentAccount current = new CurrentAccount(name2, Acnumber2, balance2);

                current.displyaAccountDetails();
                current.calculateInterest();
                current.checkOverdraftLimit();
                break;
            case 3:
                System.out.print("Enter account Holder Name :");
                String name3 = sc.nextLine();
                System.out.print("  Enter account Number :");
                String Acnumber3 = sc.nextLine();
                System.out.print(" Enter the Amount :");
                double balance3 = sc.nextDouble();
                System.out.print("Enter the deposit term For [ How many years you want to deposit] :");
                int Term = sc.nextInt();
                sc.nextLine();
                FixedDepositeAccount fixaccount = new FixedDepositeAccount(name3, Acnumber3, balance3, Term);

                fixaccount.displyaAccountDetails();
                fixaccount.calculateInterest();
                break;

            default:
                break;
        }
        sc.close();
        
    }
}
