package Multithreding;

class Account {
    private int balance = 0;

    public synchronized void withdraw(int amount) {
        Thread.currentThread().getName();
        while (balance < amount) {
            try {

                System.out.println("Current Thread is waiting...");
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        if (balance > amount) {
            balance = balance - amount;
            System.out.println("updated amount after withdraw:" + balance);
            notify();
            System.out.println("Notification is sent ");

        }

    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Updeted balance  is after deposite " + balance);
        notify();
        System.out.println("Notification is sent!!");

    }
}

class Drawer extends Thread {
    private Account account;

    public Drawer(Account account) {
        this.account = account;

    }

    public void run() {
        int[] withdraw = { 50, 50 };

        for (int amt : withdraw) {
            account.withdraw(amt);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }
}

class Depositer extends Thread {
    private Account account;

    public Depositer(Account account) {
        super();
        this.account = account;
    }

    public void run() {
        int[] deposit = { 100, 200 };
        for (int dpt : deposit) {
            account.deposit(dpt);
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ATMMachine {
    public static void main(String[] args) {
        Account ac = new Account();
        Drawer d1 = new Drawer(ac);
        Depositer depositer = new Depositer(ac);
        d1.start();
        depositer.start();

    }
}
