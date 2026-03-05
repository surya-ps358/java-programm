package Interface;

import java.util.Scanner;

class InsufficientFundsException extends Exception {
    InsufficientFundsException(String sms) {
        super(sms);
    }
}

class InvalidAmountException extends Exception {
    InvalidAmountException(String sms) {
        super(sms);
    }
}

class AccountNotFoundException extends Exception {
    AccountNotFoundException(String sms) {
        super(sms);

    }
}

class LoanNotAllowedException extends Exception {
    LoanNotAllowedException(String sms) {
        super(sms);
    }
}

interface Bank {
    public void deposit(double amount) throws InvalidAmountException;

    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException;

    public void transfer(BankAccount toAccount, double amount)
            throws InsufficientFundsException, AccountNotFoundException, InvalidAmountException;

    public void applyForLoan(double amount) throws LoanNotAllowedException, InvalidAmountException;

    public double getBalance();

}

class BankAccount implements Bank {
    private long accountNumber;
    private double balance;

    public BankAccount(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            System.err.println("amount must be positive !!");
        }
        balance += amount;
        System.out.println("incresed amount is :" + balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount > balance) {
            System.err.println("amount can not be withdraw !!");
        }

        balance -= amount;
        System.out.println("your Account Balance is :" + balance);

    }

    @Override
    public void transfer(BankAccount toAccount, double amount)
            throws InsufficientFundsException, AccountNotFoundException, InvalidAmountException {
        if (amount <= 0) {
            System.err.println("amount is invalid in your account !");
        }
        if (amount > this.balance) {
            System.err.println("insufficient balance in your account !!");
        }
        if (toAccount == null) {
            System.err.println("Account is not Found !!");
        }
    }

    @Override
    public void applyForLoan(double amount) throws LoanNotAllowedException, InvalidAmountException {
        if (amount <= 0) {
            System.err.println("Enter the positive amount");
        }
        if (amount >= 50000) {
            System.err.println("Your amount is exceeds in your balance !!");
        }
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

}

class Customer {
    private String name;
    private BankAccount account;

    public Customer(String name, BankAccount account) {
        this.name = name;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public BankAccount getAccount() {
        return account;
    }

}

public class Atm {
    public static void main(String[] args)
            throws InvalidAmountException, InsufficientFundsException, AccountNotFoundException,
            LoanNotAllowedException {
        Scanner sc = new Scanner(System.in);

        BankAccount acc1 = new BankAccount(1111, 60000);
        BankAccount acc2 = new BankAccount(2222, 3000);
        Customer customer1 = new Customer("Alice", acc1);
        Customer customer2 = new Customer("Bob", acc2);

        System.out.println("Display menu using switch-case: \n Select an option :");
        System.out.println(" 1. Deposit");
        System.out.println(" 2. Withdraw");
        System.out.println(" 3. Transfer");
        System.out.println(" 4. Loan Application");
        System.out.println(" 5. Check Balance");
        System.out.println("  6. Exit");

        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1:
                System.out.println("enter Customer Name :");
                String name = sc.nextLine();
                System.out.println("enter Deposite amount :");
                double deposit = sc.nextDouble();
                sc.nextLine();
                System.out.println("Output :");
                acc1.deposit(deposit);

                break;
            case 2:
                System.out.println("enter the Customer name :");
                String name1 = sc.nextLine();
                System.out.println("enter the withdraw Amount ");
                double wamount = sc.nextDouble();
                sc.nextLine();
                acc1.withdraw(wamount);
                break;
            case 3:
                System.out.println("enter the custome name :");
                String name2 = sc.nextLine();
                System.out.println("Enter the Transfer amount ");
                double tamount = sc.nextDouble();
                sc.nextLine();
                acc1.transfer(acc2, tamount);
                break;

            case 4:
                System.out.println("enter the custome name :");
                String name3 = sc.nextLine();
                System.out.println("Enter Your Loan amount :");
                double LAmount = sc.nextDouble();
                sc.nextLine();
                acc2.applyForLoan(LAmount);
                break;

            case 5:
                System.out.println("enter the custome name :");
                String name4 = sc.nextLine();
                System.out.println("Enter the Account number:");
                long accountNumber = sc.nextLong();
                sc.nextLine();
                acc1.getBalance();

                break;

            case 6:
                System.exit(0);

                break;

        }
        sc.close();

    }
}
