package Simple_Method;

import java.util.Scanner;

class Customer {
    protected String name;

    public Customer(String name) {
        super();

        if (name.isEmpty() || name == "null" || name == null) {
            System.err.println("Name can not be null or empty");
            System.exit(0);
        }

        this.name = name;
    }

    public void calculateBill(double... prices) {
        double total = 0;
        for (double price : prices) {
            if (price < 0) {
                System.err.println("Error items !!");
                System.exit(0);

            } else {

                total = +price;

            }

        }
        System.out.println("Name of the items :" + name);
        System.out.println("The Total bill of items :" + total);
        System.out.println("For genaral customer not eligibal for discount");

    }
}

class GenaralCustomer extends Customer {

    public GenaralCustomer(String name) {
        super(name);

    }

    public void calculateBill(double... prices) {
        double total = 0;
        for (double price : prices) {
            if (price < 0) {
                System.out.println("Item Price Can not be neagtive !!");
            } else {
                total += price;

            }
        }

        System.out.println("GenaralCustmor not Eligibil for discount :");
        System.out.println("Name of the items :" + name);
        System.out.println("The Total bill of items :" + total);

    }

}

class PrimeCustomer extends Customer {
    protected double discountRate = 10.0;

    public PrimeCustomer(String name) {
        super(name);

    }

    public void calculateBill(double... prices) {
        double total = 0;
        double finalbill = 0;
        double discount = 0;
        for (double price : prices) {

            if (price < 0) {
                System.err.println("Item Price Can not be neagtive !!");
                System.exit(0);
            } else {
                total += price;

                discount = total * (discountRate / 100);
                finalbill = total - discount;

            }
        }
        System.out.println("Name of the items :" + name);
        System.out.println("PrimeCustmor is eligibal discount up to :" + discount);
        System.out.println("The Total bill of items" + total);
        System.out.println("The final bill of prime Customer is :" + finalbill);

    }
}

class VIPCustomer extends Customer {

    protected double discountRate = 15.0;

    public VIPCustomer(String name) {
        super(name);
        this.name = name;

    }

    public void calculateBill(double... prices) {
        double total = 0;
        double finalbill = 0;
        double discount = 0;
        for (double price : prices) {
            if (price < 0) {
                System.err.println("Item Price Can not be neagtive !!");
                System.exit(0);
            } else {
                total += price;
                discount = total * (discountRate / 100);
                finalbill = total - discount;

            }
        }

        System.out.println("Name of the items :" + name);
        System.out.println("VIPCustomer is Eligibal discount up to :" + discount);
        System.out.println("The Total bill of items" + total);
        System.out.println("The final bill of prime Customer is :" + finalbill);

    }
}

public class ShoppingMall {
    public static void generateBill(Customer c1, double... prices) {
        c1.calculateBill(prices);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select the Customer Type to get additional Discount :");
        System.out.println("\t\t\t1) General Customer ");
        System.out.println("\t\t\t2) Prime Customer  ");
        System.out.println("\t\t\t3)VIP Customer ");
        System.out.println("------------------------------------------------------------");
        System.out.println("Please enter Customer type :");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1: {
                System.out.println("Please enter your Name :");
                String name = sc.nextLine();
                System.out.println("Enter Number Of Items");
                int item = sc.nextInt();
                sc.nextLine();
                System.out.println("Please Enter the Item Name and Price :");
                double[] a = new double[item];
                for (int i = 0; i < item; i++) {
                    System.out.println("items name :");
                    System.out.println("Items Prices :");
                    int p = sc.nextInt();
                    a[i] = p;
                    generateBill(new GenaralCustomer(name), a);
                    System.out.println("----------------------------------------------");
                }

            }
            case 2: {
                System.out.println("Please enter your Name :");
                String name = sc.nextLine();
                System.out.println("Enter Number Of Items");
                int item = sc.nextInt();
                sc.nextLine();
                System.out.println("Please Enter the Item Name and Price :");
                double[] a = new double[item];
                for (int i = 0; i < item; i++) {
                    System.out.println("items name :");
                    System.out.println("Items Prices :");
                    int p = sc.nextInt();
                    a[i] = p;
                    generateBill(new PrimeCustomer(name), a);
                    System.out.println("----------------------------------------------");
                }
            }
            case 3: {
                System.out.println("Please enter your Name :");
                String name = sc.nextLine();
                System.out.println("Enter Number Of Items");
                int item = sc.nextInt();
                sc.nextLine();
                System.out.println("Please Enter the Item Name and Price :");
                double[] a = new double[item];
                for (int i = 0; i < item; i++) {
                    System.out.println("items name :");
                    System.out.println("Items Prices :");
                    int p = sc.nextInt();
                    a[i] = p;
                    generateBill(new VIPCustomer(name), a);
                    System.out.println("----------------------------------------------");
                }
            }
        }
        sc.close();
    }
}
